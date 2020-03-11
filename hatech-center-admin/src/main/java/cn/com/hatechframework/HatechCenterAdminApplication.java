package cn.com.hatechframework;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 * @program hatech-framework
 * @package cn.com.hatechframework
 * @className HatechCenterAdminApplication
 * @description springboot admin服务监控类
 * @create 2020/2/13 10:42
 * @author YeMeng
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2020/2/13 10:42             1.0                         springboot admin服务监控类
 */
@EnableAdminServer
@SpringBootApplication
public class HatechCenterAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HatechCenterAdminApplication.class, args);
    }

}
