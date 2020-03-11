package cn.com.hatechframework.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.mybatisplus
 * @className MyBatisPlusConfig
 * @description MyBatisPlus 配置
 * @author WangMingShuai
 * @create 2019/12/20 15:27
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 15:27             1.0                         MyBatisPlus 配置
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     * MyBatisPlus配置分页
     * @author WangMingShuai
     * @date 2020/1/7 10:22
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return  new PaginationInterceptor();
    }

}
