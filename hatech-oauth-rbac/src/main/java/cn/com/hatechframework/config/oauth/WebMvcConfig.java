package cn.com.hatechframework.config.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.mvc
 * @className WebMvcConfig
 * @description 配置 spring mvc
 * @author WangMingShuai
 * @create 2019/12/23 15:13
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/23 15:13             1.0                         配置 spring mvc
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final UserAuthTenantRestInterceptor userAuthTenantRestInterceptor;

    public WebMvcConfig(UserAuthTenantRestInterceptor userAuthTenantRestInterceptor) {
        this.userAuthTenantRestInterceptor = userAuthTenantRestInterceptor;
    }

    /**
     * 解决controller返回字符串中文乱码问题
     * @param converters
     * @author WangMingShuai
     * @date 2020/1/7 10:28
     * @return void
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter)converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }

    /**
     * 添加资源
     * @param registry
     * @author WangMingShuai
     * @date 2020/1/7 10:28
     * @return void
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 允许swagger-ui静态资源访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 接入拦截器
     * @param registry  拦截器注册
     * @author YeMeng
     * @date 2019/12/26 17:23
     * @return void
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthTenantRestInterceptor).addPathPatterns("/**");
    }

}
