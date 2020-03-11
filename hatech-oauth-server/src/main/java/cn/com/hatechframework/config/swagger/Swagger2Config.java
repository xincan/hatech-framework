package cn.com.hatechframework.config.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.swagger
 * @className Swagger2Config
 * @description swagger 配置
 * @author YeMeng
 * @create 2019/12/23 16:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:59             1.0                         swagger 配置
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config {

    /**
     *  创建swagger rest api
     * @author YeMeng
     * @date 2019/12/24 17:46
     * @return springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.com.hatechframework"))
                .paths(PathSelectors.any())
                .build()
                // 配置 swagger oauth认证
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    /**
     *  api详情
     * @author YeMeng
     * @date 2019/12/24 17:47
     * @return springfox.documentation.service.ApiInfo
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("xincan","http://localhost:8070/doc.html","");
        return new ApiInfoBuilder()
                .title("swagger-ui RESTful APIs")
                .description("swagger-ui")
                .termsOfServiceUrl("http://localhost:8070/")
                .contact(contact)
                .version("1.0")
                .build();
    }

    /**
     *  配置token类型为Bearer
     * @author YeMeng
     * @date 2019/12/24 17:47
     * @return springfox.documentation.service.ApiKey
     */
    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }

    /**
     *  将所有请求接口纳入swagger认证
     * @author YeMeng
     * @date 2019/12/24 17:48
     * @return springfox.documentation.spi.service.contexts.SecurityContext
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    /**
     *  默认认证内容
     * @author YeMeng
     * @date 2019/12/24 17:49
     * @return java.util.List<springfox.documentation.service.SecurityReference>
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }


}
