package cn.com.hatechframework.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.security
 * @className WebSecurityConfig
 * @description web安全配置
 * @author YeMeng
 * @create 2019/12/23 16:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:09             1.0                        web安全配置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注入UserDetailsService实现对象
     */
    private final UserDetailsService userDetailsServiceImpl;

    public WebSecurityConfig(UserDetailsService userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    /**
     *  密码编码解码器
     * @author YeMeng
     * @date 2019/12/24 17:43
     * @return org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     *  鉴权管理bean
     * @author YeMeng
     * @date 2019/12/24 17:42
     * @return org.springframework.security.authentication.AuthenticationManager
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     *  使用自定义的UserDetailsService实现和密码
     * @param auth  认证关联
     * @author YeMeng
     * @date 2019/12/24 17:44
     * @return void
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    /**
     *  url拦截配置
     * @param http  http认证
     * @author YeMeng
     * @date 2019/12/24 17:45
     * @return void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //不拦截 oauth 开放的资源
        http.csrf().disable();
        //使HttpSecurity接收以"/login/","/oauth/"开头请求, 配置HttpSecurity不阻止swagger页面
        http
            .authorizeRequests()
            .antMatchers("/webjars/**","/swagger-ui.html/**", "/swagger-resources/**", "/v2/api-docs/**")
            .permitAll()
            .antMatchers("/oauth/**", "/user/**")
            .authenticated()
            .and().httpBasic()
        ;
    }


}
