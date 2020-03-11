package cn.com.hatechframework.config.oauth;

import cn.com.hatechframework.config.exception.OAuthResponseExceptionTranslator;
import cn.com.hatechframework.server.mapper.oauth.IMybatisClientDetailMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.oauth
 * @className OAuth2AuthorizationConfig
 * @description oauth认证配置类
 * @author YeMeng
 * @create 2019/12/20 18:33
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/20 18:33             1.0                        oauth认证配置类
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    /**
     *  签名信息
     */
    @Value("${security.oauth2.sign}")
    private String signKey;

    /**
     * token有效期自定义设置，默认12小时
     */
    @Value("${security.validity.access-token-seconds}")
    private int accessTokenSeconds;

    /**
     *  默认30天，这里修改为7天
     */
    @Value("${security.validity.refresh-token-seconds}")
    private int refreshTokenSeconds;


    /**
     * 认证管理器设置
     */
    private final AuthenticationManager authenticationManager;

    /**
     * 鉴权数据库配置
     */
    private final DataSource dataSource;

    /**
     * token store redis配置
     */
    private final RedisConnectionFactory redisConnectionFactory;

    /**
     * 后台接口调用，重写UserDetailsService
     */
    private final UserDetailsService userDetailsServiceImpl;

    /**
     * 注入自定义client details查询
     */
    @Resource
    private IMybatisClientDetailMapper mybatisClientDetailMapper;

    public OAuth2AuthorizationConfig(@Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager,
                                     DataSource dataSource, RedisConnectionFactory redisConnectionFactory,
                                     UserDetailsService userDetailsServiceImpl, TokenEnhancer jwtTokenEnhancer) {
        this.authenticationManager = authenticationManager;
        this.dataSource = dataSource;
        this.redisConnectionFactory = redisConnectionFactory;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtTokenEnhancer = jwtTokenEnhancer;
    }

    /**
     *  配置token存储入库配置
     * @author YeMeng
     * @date 2020/1/6 20:47
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     */
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     *  客户端调用鉴权详情配置,定义授权的请求的路径
     * @author YeMeng
     * @date 2020/1/6 20:48
     * @return org.springframework.security.oauth2.provider.ClientDetailsService
     */
    @Bean
    public ClientDetailsService clientDetails() {
        return new MybatisClientDetailsService(dataSource, mybatisClientDetailMapper);
    }

    /**
     *  对称加密HS256（也可以采用非对称加密RS256）对Jwt签名时，增加一个密钥，JwtAccessTokenConverter：对Jwt来进行编码以及解码的类
     * @author YeMeng
     * @date 2020/1/6 20:48
     * @return org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(this.signKey);
        return converter;
    }

    /**
     * 注入jwt token增强器
     */
    public final TokenEnhancer jwtTokenEnhancer;

    /**
     *  自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
     * @author YeMeng
     * @date 2020/1/6 20:49
     * @return org.springframework.security.oauth2.provider.token.DefaultTokenServices
     */
    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setReuseRefreshToken(false);
        // jwt token 增强链
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancerList = new ArrayList<>();
        enhancerList.add(jwtTokenEnhancer);
        enhancerList.add(jwtAccessTokenConverter());
        enhancerChain.setTokenEnhancers(enhancerList);
        // 设置jwt token 增强链
        tokenServices.setTokenEnhancer(enhancerChain);
        log.info("token有效期自定义设置: {} 秒", accessTokenSeconds);
        tokenServices.setAccessTokenValiditySeconds(accessTokenSeconds);
        log.info("token刷新有效期自定义设置: {} 秒", refreshTokenSeconds);
        tokenServices.setRefreshTokenValiditySeconds(refreshTokenSeconds);
        return tokenServices;
    }

    /**
     * ClientDetailsServiceConfigurer：
     * 用来配置客户端详情服务（ClientDetailsService），
     * 客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     *
     * 支持授权类型：
     * authorization_code：  授权码类型。
     * implicit：            隐式授权类型。
     * password：            资源所有者（即用户）密码类型。
     * client_credentials：  客户端凭据（客户端ID以及Key）类型。
     * refresh_token：       通过以上授权获得的刷新令牌来获取新的令牌。
     *
     * 链式调用：
     * clientId：            （必须的）用来标识客户的Id。
     * secret：              （需要值得信任的客户端）客户端安全码，如果有的话。
     * scope：               用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围。
     * authorizedGrantTypes：此客户端可以使用的授权类型，默认为空。
     * authorities：         此客户端可以使用的权限（基于Spring Security authorities）。
     *
     * 存储方式：
     * InMemoryTokenStore：  这个版本的实现是被默认采用的，它可以完美的工作在单服务器上（即访问并发量压力不大的情况下，并且它在失败的时候不会进行备份），大多数的项目都可以使用这个版本的实现来进行尝试，你可以在开发的时候使用它来进行管理，因为不会被保存到磁盘中，所以更易于调试。
     * JdbcTokenStore：      这是一个基于JDBC的实现版本，令牌会被保存进关系型数据库。使用这个版本的实现时，你可以在不同的服务器之间共享令牌信息，使用这个版本的时候请注意把"spring-jdbc"这个依赖加入到你的classpath当中。
     * JwtTokenStore：       这个版本的全称是 JSON Web Token（JWT），它可以把令牌相关的数据进行编码（因此对于后端服务来说，它不需要进行存储，这将是一个重大优势），但是它有一个缺点，那就是撤销一个已经授权令牌将会非常困难，所以它通常用来处理一个生命周期较短的令牌以及撤销刷新令牌（refresh_token）。另外一个缺点就是这个令牌占用的空间会比较大，如果你加入了比较多用户凭证信息。JwtTokenStore 不会保存任何数据，但是它在转换令牌值以及授权信息方面与 DefaultTokenServices 所扮演的角色是一样的。
     *
     *
     *  读取已经接入鉴权系统的服务列表
     * @param clients  客户端配置
     * @author YeMeng
     * @date 2020/1/6 20:51
     * @return void
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails());
    }

    /**
     *  自定义oauth异常返回
     * @author YeMeng
     * @date 2019/12/25 17:56
     * @return cn.com.hatechframework.config.exception.OAuthResponseExceptionTranslator
     */
    @Bean(name = "exceptionTranslator")
    public OAuthResponseExceptionTranslator getWebResponseExceptionTranslator() {
        return new OAuthResponseExceptionTranslator();
    }

    /**
     *
     * AuthorizationServerEndpointsConfigurer：
     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     *
     *  配置服务鉴权存储端点
     * @param endpoints  鉴权端点
     * @author YeMeng
     * @date 2020/1/6 20:52
     * @return void
     */
    @Override
    @SuppressWarnings("unchecked")
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenServices(defaultTokenServices())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsServiceImpl)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .reuseRefreshTokens(true)
                .exceptionTranslator(getWebResponseExceptionTranslator());
    }

    /**
     *
     * AuthorizationServerSecurityConfigurer：
     * 用来配置令牌端点(Token Endpoint)的安全约束
     *
     *  定义令牌端点上的安全约束
     * @param oauthServer  oauth服务端配置
     * @author YeMeng
     * @date 2020/1/6 20:53
     * @return void
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                //对获取token的请求不进行拦截，只需验证获取token的验证信（用户名username和密码password），这些准确无误，就返回Token
                .tokenKeyAccess("permitAll()")
                //检查token的策略
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients(); // 支持表单验证
    }

}
