package cn.com.hatechframework.config.swagger;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 * @description 自定义建立相应的swagger-resource端点控制类
 * @program hatech-framework
 * @package cn.com.hatechframework.config.swagger
 * @className SwaggerHandlerController
 * @author YeMeng
 * @create 2020/1/2 14:51
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2020/1/2 14:51             1.0                          自定义建立相应的swagger-resource端点控制类
 */
@RestController
public class SwaggerHandlerController {

    private final SwaggerResourcesProvider swaggerResources;

    public SwaggerHandlerController(SwaggerResourcesProvider swaggerResources) {
        this.swaggerResources = swaggerResources;
    }

    @GetMapping("/swagger-resources")
    public Mono<ResponseEntity> swaggerResources() {
        return Mono.just((new ResponseEntity<>(swaggerResources.get(), HttpStatus.OK)));
    }

}
