package cn.com.hatechframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework
 * @className HatechOauthRbacApplication
 * @description Rbac服务启动类
 * @author WangMingShuai
 * @create 2019/12/27 14:49
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 14:49             1.0                         Rbac服务启动类
 */
@EnableFeignClients
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
})
public class HatechOauthRbacApplication {

    public static void main(String[] args) {
        SpringApplication.run(HatechOauthRbacApplication.class, args);
    }

}
