package cn.com.hatechframework.config.mvc;

import cn.com.hatechframework.config.oauth.UserAuthTenantRestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.mvc
 * @className WebMvcConfig
 * @description web mvc配置
 * @author YeMeng
 * @create 2019/12/23 16:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:59             1.0                         web mvc配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     *  允许静态资源访问
     * @param registry 资源注册
     * @author YeMeng
     * @date 2019/12/24 17:50
     * @return void
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 允许swagger-ui静态资源访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /**
     *  解决controller返回字符串中文乱码问题
     * @param converters http请求转换列表
     * @author YeMeng
     * @date 2019/12/25 11:02
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
     *  接入拦截器
     * @param registry  拦截器注册
     * @author YeMeng
     * @date 2019/12/26 17:23
     * @return void
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserAuthTenantRestInterceptor()).addPathPatterns("/**");
    }

}
