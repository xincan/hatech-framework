package cn.com.hatechframework.server.service.impl;

import cn.com.hatechframework.config.exception.BusinessException;
import cn.com.hatechframework.data.config.redis.RedisTemplateOperator;
import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.entity.oauth.rbac.dto.UserLoginDTO;
import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.entity.oauth.server.dto.OAuthParamDTO;
import cn.com.hatechframework.entity.oauth.server.dto.OAuthRefreshParamDTO;
import cn.com.hatechframework.server.dto.OAuthCodeTokenDTO;
import cn.com.hatechframework.server.feign.IFUserDetailsService;
import cn.com.hatechframework.server.po.OAuthRequestPO;
import cn.com.hatechframework.server.po.UserPO;
import cn.com.hatechframework.server.service.IUserService;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.context.BaseContextHandler;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.statics.DataKeyPrefix;
import cn.com.hatechframework.utils.token.TokenUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.*;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestValidator;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.service.impl
 * @className UserServiceImpl
 * @description 用户oauth处理实现类
 * @author YeMeng
 * @create 2019/12/23 16:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:59             1.0                       用户oauth处理实现类
 */
@Slf4j
@Service
public class UserServiceImpl extends AbstractService<UserPO> implements IUserService {

    /**
     * implicit类型
     */
    private static final String IMPLICIT_TYPE = "implicit";

    /**
     * refresh_token类型
     */
    private static final String REFRESH_TOKEN_TYPE = "refresh_token";

    /**
     * authorization_code类型
     */
    private static final String AUTHORIZATION_CODE_TYPE = "authorization_code";

    /**
     * 用户登录配置
     * 客户端id
     */
    @Value("${spring.login.client-id}")
    private String oauthServerClientId;

    /**
     * 用户登录配置
     * 客户端密码
     */
    @Value("${spring.login.client-secret}")
    private String oauthServerClientSecret;

    /**
     * 用户登录配置
     * oauth登录类型
     */
    @Value("${spring.login.grant-type}")
    private String oauthServerGrantType;

    /**
     * 用户登录配置
     * scope范围
     */
    @Value("${spring.login.scope}")
    private String oauthServerScope;

    /**
     * 注入redis token store
     */
    private TokenStore tokenStore;

    /**
     * 注入自定义的MybatisClientDetails
     */
    private ClientDetailsService clientDetails;

    /**
     * 注入根据上述自定义MybatisClientDetails生成的DefaultOAuth2RequestFactory
     */
    private OAuth2RequestFactory oAuth2RequestFactory;

    /**
     * 注入默认的DefaultOAuth2RequestValidator
     */
    private OAuth2RequestValidator oAuth2RequestValidator;

    /**
     * 注入token生成器
     */
    private TokenGranter tokenGranter;

    /**
     * 注入 redis token service
     */
    private ResourceServerTokenServices resourceServerTokenServices;

    /**
     * 注入密码处理器
     */
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * token 访问转换
     */
    private AccessTokenConverter accessTokenConverter;

    /**
     * redis操作
     */
    private RedisTemplateOperator redisTemplateOperator;

    /**
     * 注入feign调用rbac的/user/findUserByUsername请求
     */
    private IFUserDetailsService fUserDetailsService;

    /**
     * 对象转换成map, 以下属性驼峰类型变为下划线类型
     */
    private static final Map<String, String> CONFIG_MAP = new HashMap<>();

    static {
        //对象转换成map, 以下属性驼峰类型变为下划线类型
        CONFIG_MAP.put("clientId", OAuth2Utils.CLIENT_ID);
        CONFIG_MAP.put("clientSecret", "client_secret");
        CONFIG_MAP.put("grantType", OAuth2Utils.GRANT_TYPE);
        CONFIG_MAP.put("refreshToken", OAuth2AccessToken.REFRESH_TOKEN);
        CONFIG_MAP.put("redirectUri", OAuth2Utils.REDIRECT_URI);
    }


    public UserServiceImpl(TokenStore tokenStore, ClientDetailsService clientDetails, BCryptPasswordEncoder bCryptPasswordEncoder,
                           AuthorizationServerEndpointsConfiguration authorizationServerEndpointsConfiguration,
                           ResourceServerTokenServices resourceServerTokenServices, RedisTemplateOperator redisTemplateOperator,
                           IFUserDetailsService fUserDetailsService) {
        // redis token store
        this.tokenStore = tokenStore;
        // 自定义的MybatisClientDetails
        this.clientDetails = clientDetails;
        // 密码处理器
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        // OAuth2Request工厂, 使用自定义的MybatisClientDetails
        this.oAuth2RequestFactory = new DefaultOAuth2RequestFactory(clientDetails);
        // OAuth2Request校验
        this.oAuth2RequestValidator = new DefaultOAuth2RequestValidator();
        // token生成器
        this.tokenGranter = authorizationServerEndpointsConfiguration.getEndpointsConfigurer().getTokenGranter();
        // redis token service
        this.resourceServerTokenServices = resourceServerTokenServices;
        //  token 访问转换
        this.accessTokenConverter = authorizationServerEndpointsConfiguration.getEndpointsConfigurer().getAccessTokenConverter();
        // redis 操作
        this.redisTemplateOperator = redisTemplateOperator;
        // feign调用rbac
        this.fUserDetailsService = fUserDetailsService;
    }

    /**
     *  用户登录(用户名密码)
     * @param userLoginDTO  用户名密码
     * @author YeMeng
     * @date 2020/1/6 14:07
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public OAuth2AccessToken usernamePasswordLogin(UserLoginDTO userLoginDTO) {
        OAuthRequestPO request = OrikaUtils.map(userLoginDTO,OAuthRequestPO.class);
        request.setClientId(oauthServerClientId);
        request.setClientSecret(oauthServerClientSecret);
        request.setGrantType(oauthServerGrantType);
        request.setScope(oauthServerScope);
        return userOAuthToken(request);
    }

    /**
     *  用户oauth登录
     * @param oAuthParamDTO  oauth登陆参数
     * @author YeMeng
     * @date 2020/1/6 14:27
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public OAuth2AccessToken userOAuthLogin(OAuthParamDTO oAuthParamDTO) {
        OAuthRequestPO request = OrikaUtils.map(oAuthParamDTO, OAuthRequestPO.class);
        return userOAuthToken(request);
    }

    /**
     *  用户校验码获取token
     * @param oAuthCodeTokenDTO  校验码登录参数
     * @author YeMeng
     * @date 2020/1/6 14:34
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public OAuth2AccessToken userCodeLogin(OAuthCodeTokenDTO oAuthCodeTokenDTO) {
        OAuthRequestPO request = OrikaUtils.map(oAuthCodeTokenDTO, OAuthRequestPO.class);
        return userOAuthToken(request);
    }

    /**
     *  用户刷新token
     * @param oAuthRefreshParamDTO  刷新token参数
     * @author YeMeng
     * @date 2020/1/6 14:41
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public OAuth2AccessToken userRefreshLogin(OAuthRefreshParamDTO oAuthRefreshParamDTO) {
        OAuthRequestPO request = OrikaUtils.map(oAuthRefreshParamDTO, OAuthRequestPO.class);
        return userOAuthToken(request);
    }

    /**
     *  用户token接口(重写spring /oauth/token 接口)
     * @param oAuthRequestPO  oAuthParam 登陆参数
     * @author YeMeng
     * @date 2019/12/24 19:36
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @SuppressWarnings("all")
    @Override
    public OAuth2AccessToken userOAuthToken(OAuthRequestPO oAuthRequestPO) {
        String clientId = oAuthRequestPO.getClientId();
        String clientSecret = oAuthRequestPO.getClientSecret();
        log.info("查询ClientDetails");
        ClientDetails authenticatedClient = clientDetails.loadClientByClientId(clientId);
        log.info("校验 clientId");
        if (StringUtils.isEmpty(clientSecret) || authenticatedClient == null ||
                !bCryptPasswordEncoder.matches(clientSecret, authenticatedClient.getClientSecret())) {
            log.error("{}","客户端client账号不存在或密码错误");
            throw new UnauthorizedClientException("客户端client账号不存在或密码错误");
        }
        Map<String, String> parameters = OrikaUtils.map(oAuthRequestPO, CONFIG_MAP, Map.class);
        log.info("生成 token request");
        TokenRequest tokenRequest = oAuth2RequestFactory.createTokenRequest(parameters, authenticatedClient);
        if (!StringUtils.isEmpty(clientId) && !clientId.equals(tokenRequest.getClientId())) {
            log.error("clientId ({})与authenticated client({})不一致",clientId,tokenRequest.getClientId());
            throw new InvalidClientException("clientId与authenticated client不一致");
        }
        log.info("{}","校验scope");
        oAuth2RequestValidator.validateScope(tokenRequest, authenticatedClient);
        if (!StringUtils.hasText(tokenRequest.getGrantType())) {
            log.error("{}","grant_type不存在");
            throw new InvalidRequestException("grant_type不存在");
        }
        if (IMPLICIT_TYPE.equals(tokenRequest.getGrantType())) {
            log.error("不支持implicit类型的grant_type: {}", tokenRequest.getGrantType());
            throw new InvalidGrantException("不支持implicit类型的grant_type");
        }
        log.info("{}","使用校验码验证时清空scope");
        if (AUTHORIZATION_CODE_TYPE.equals(parameters.get(OAuth2Utils.GRANT_TYPE)) && parameters.get("code") != null
                && !tokenRequest.getScope().isEmpty()) {
            tokenRequest.setScope(Collections.emptySet());
        }
        log.info("{}","设置refresh_token的scope");
        if (REFRESH_TOKEN_TYPE.equals(parameters.get(OAuth2Utils.GRANT_TYPE)) && parameters.get(OAuth2AccessToken.ACCESS_TOKEN) != null) {
            tokenRequest.setScope(OAuth2Utils.parseParameterList(parameters.get(OAuth2Utils.SCOPE)));
        }
        log.info("{}","生成token");
        OAuth2AccessToken token = tokenGranter.grant(tokenRequest.getGrantType(), tokenRequest);
        if (token == null) {
            log.error("不支持的grant_type: {}", tokenRequest.getGrantType());
            throw new UnsupportedGrantTypeException("不支持的grant_type: " + tokenRequest.getGrantType());
        }
        log.info("{}","当用户存在时将用户存入缓存");
        if (saveUserDetailsToken(token)) {
            return token;
        }
        else {
            throw new BusinessException(ResponseCode.EXCEPTION, "用户token保存失败");
        }
    }

    /**
     *  将token保存至redis
     * @param token  token值
     * @author YeMeng
     * @date 2019/12/30 16:38
     * @return void
     */
    private boolean saveUserDetailsToken(OAuth2AccessToken token) {
        try {
            Object userVO = BaseContextHandler.getUser();
            // refresh token时不会调用 UserDetailService 中查询用户详情的方法
            if (Objects.isNull(userVO)) {
                String username = TokenUtils.getUserName(token.getValue());
                String tenantNames = TokenUtils.getTenant(token.getValue());
                log.info("查询用户及其角色信息, 用户:{}, 租户:{}", username, tenantNames);
                ResponseObject<UserVO> userResp = fUserDetailsService.findUserByUsername(username, tenantNames);
                if (userResp.getCode() != ResponseCode.REQUEST_SUCCESS.code()) {
                    throw new BusinessException(ResponseCode.USER_NOT_EXIST, userResp.getMsg());
                }
                userVO = userResp.getData();
            }
            redisTemplateOperator.set(DataKeyPrefix.LOGIN_USER_TOKEN_PREFIX + token.getValue(), userVO, token.getExpiresIn());
            return true;
        } catch (Exception e) {
            log.error("用户token保存失败", e);
        }
        return false;
    }

    /**
     *  用户退出登录
     * @param oAuth2Authentication 删除redis中储存的access token
     * @author YeMeng
     * @date 2019/12/24 19:37
     * @return boolean
     */
    @Override
    public boolean userLogout(OAuth2Authentication oAuth2Authentication) {
        if (StringUtils.isEmpty(oAuth2Authentication)) {
            return false;
        }
        try {
            RedisTokenStore customRedisTokenStore = (RedisTokenStore)tokenStore;
            //以下计算redis中的key
            String user = oAuth2Authentication.getName();
            log.info("已登录的用户名:{}", user);
            String token = ((OAuth2AuthenticationDetails)oAuth2Authentication.getDetails()).getTokenValue();
            log.info("token:{}", token);
            // 解析access token
            Claims claims = TokenUtils.decodeToken(token);
            String clientId = claims.get("client_id", String.class);
            log.info("删除redis 中的 access token: {}", token);
            customRedisTokenStore.removeAccessToken(token);
            redisTemplateOperator.del("uname_to_access:"+clientId+":"+user);
            redisTemplateOperator.del(DataKeyPrefix.LOGIN_USER_TOKEN_PREFIX + token);
            return true;
        } catch (Exception e) {
            log.error("用户退出解析token错误", e);
        }
        return false;
    }

    /**
     *  校验token
     * @param value token 校验结果
     * @author YeMeng
     * @date 2019/12/24 19:37
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> checkToken(@RequestParam("token") String value) {
        OAuth2AccessToken token = resourceServerTokenServices.readAccessToken(value);
        if (token == null) {
            log.error("{}", "Token不存在");
            throw new InvalidTokenException("Token不存在");
        }
        if (token.isExpired()) {
            log.error("{}", "Token过期");
            throw new InvalidTokenException("Token过期");
        }
        OAuth2Authentication authentication = resourceServerTokenServices.loadAuthentication(token.getValue());
        Map<String, Object> response = (Map<String, Object>)accessTokenConverter.convertAccessToken(token, authentication);
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(value);
        log.info("token 有效: {}, token 值: {}", oAuth2AccessToken != null, value);
        response.put("active", oAuth2AccessToken != null);
        return response;
    }

    /**
     *  通过token获取用户信息
     * @param principal  用户认证 OAuth2Authentication
     * @author YeMeng
     * @date 2020/1/7 19:27
     * @return java.security.Principal
     */
    @Override
    public Principal principal(Principal principal) {
        if (!(principal instanceof OAuth2Authentication)) {
            return null;
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication)principal;
        String token = ((OAuth2AuthenticationDetails)oAuth2Authentication.getDetails()).getTokenValue();
        String key = DataKeyPrefix.LOGIN_USER_TOKEN_PREFIX + token;
        return redisTemplateOperator.hasKey(key) != null && redisTemplateOperator.hasKey(key)? principal: null;
    }

}
