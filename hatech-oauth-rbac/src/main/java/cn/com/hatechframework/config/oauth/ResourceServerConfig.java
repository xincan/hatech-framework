package cn.com.hatechframework.config.oauth;

import cn.com.hatechframework.config.exception.ResourceAccessDeniedHandler;
import cn.com.hatechframework.config.exception.ResourceAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.oauth
 * @className ResourceServerConfig
 * @description 配置oauth2资源服务
 * @author WangMingShuai
 * @create 2019/12/23 15:13
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/23 15:13             1.0                         配置oauth2资源服务
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {

    /**资源服务id*/
    @Value("${security.oauth2.resource.id}")
    private String resourceId;

    /**注入密码加密解密类*/
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 配置资源授权路径
     * @param http
     * @author WangMingShuai
     * @date 2020/1/7 10:26
     * @return void
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 允许未授权访问的请求路径
                .antMatchers("/doc.html", "/webjars/**", "/swagger-resources/**", "/v2/api-docs/**", "/actuator", "/actuator/**",
                        "/user/login", "/user/logout", "/user/findUserByUsername","/tenant/register")
                .permitAll()
                .anyRequest().authenticated();
    }

    /**
     * 配置资源授权
     * @param resources  资源授权
     * @author YeMeng
     * @date 2019/12/24 17:34
     * @return void
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .resourceId(resourceId)
                .stateless(true)
                .accessDeniedHandler(new ResourceAccessDeniedHandler())
                .authenticationEntryPoint(new ResourceAuthenticationEntryPoint());
    }
}
