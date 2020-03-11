package cn.com.hatechframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework
 * @className HatechOauthServerApplication
 * @description 系统启动类
 * @author YeMeng
 * @create 2019/12/23 16:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:59             1.0                         系统启动类
 */
@EnableFeignClients
@EnableWebMvc
@SpringBootApplication
public class HatechOauthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HatechOauthServerApplication.class, args);
    }

}

