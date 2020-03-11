package cn.com.hatechframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework
 * @className HatechCenterGatewayApplication
 * @description gateway启动类
 * @author YeMeng
 * @create 2019/12/30 14:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/30 14:59             1.0                       gateway启动类
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
})
public class HatechCenterGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HatechCenterGatewayApplication.class, args);
    }

}
