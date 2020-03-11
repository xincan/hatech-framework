package cn.com.hatechframework.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config
 * @className MyBatisPlusConfig
 * @description MyBatisPlus基础配置类
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/20 17:03             1.0                         MyBatisPlus基础配置类
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     *  分页配置
     * @method: paginationInterceptor
     * @author Xincan Jiang
     * @date 2019-11-01 10:11:35
     * @return PaginationInterceptor
     * @exception:
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return  new PaginationInterceptor();
    }

}
