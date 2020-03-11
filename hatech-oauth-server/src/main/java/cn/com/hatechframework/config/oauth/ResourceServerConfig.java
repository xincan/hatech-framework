package cn.com.hatechframework.config.oauth;

import cn.com.hatechframework.config.exception.ResourceAccessDeniedHandler;
import cn.com.hatechframework.config.exception.ResourceAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Copyright (C), 2018,北京同创永益科技发展有限公司
 * @package  cn.com.hatechframework.oauth.config.oauth
 * @className ResourceServerConfig
 * @author Xincan
 * @description ${description}
 * @date 2019/5/15 17:06
 * @version 1.0
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     *  资源id
     */
    @Value("${spring.application.name}")
    private String resourceId;

    /**
     *  配置资源接口认证
     * @param http 校验
     * @author YeMeng
     * @date 2019/12/24 17:51
     * @return void
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 过滤不需要认证的资源
        http
            .authorizeRequests()
            .antMatchers("/user/login").permitAll();
    }

    /**
     *  配置资源授权
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
