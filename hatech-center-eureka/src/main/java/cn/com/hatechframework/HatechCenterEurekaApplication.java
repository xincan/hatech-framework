package cn.com.hatechframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework
 * @className HatechCenterEurekaApplication
 * @description eureka启动类
 * @author YeMeng
 * @create 2019/12/25 18:12
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 18:12             1.0                       eureka启动类
 */
@EnableEurekaServer
@SpringBootApplication
public class HatechCenterEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HatechCenterEurekaApplication.class, args);
    }

}
