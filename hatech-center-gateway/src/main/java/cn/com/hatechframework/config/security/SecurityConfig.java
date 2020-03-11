package cn.com.hatechframework.config.security;

import cn.com.hatechframework.config.filter.TokenFilterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.security
 * @className SecurityConfig
 * @description 安全配置
 * @author YeMeng
 * @create 2020/1/2 14:51
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2020/1/2 14:51             1.0                          安全配置
 */
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    /**
     * 注入token过滤配置
     */
    private final TokenFilterConfig tokenFilterConfig;

    public SecurityConfig(TokenFilterConfig tokenFilterConfig) {
        this.tokenFilterConfig = tokenFilterConfig;
    }

    /**
     * 创建安全过滤链
     * @param http http安全设置
     * @author YeMeng
     * @date 2020/2/10 15:20
     * @return org.springframework.security.web.server.SecurityWebFilterChain
     */
    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        return http.csrf().disable()
                // 启用token过滤
                .addFilterAt(tokenFilterConfig, SecurityWebFiltersOrder.HTTP_BASIC)
                .authorizeExchange().pathMatchers("/**")
                // GatewayFilter中配置了权限校验, 此处不校验权限配置
                .permitAll()
                .and()
                .build();
    }

}
