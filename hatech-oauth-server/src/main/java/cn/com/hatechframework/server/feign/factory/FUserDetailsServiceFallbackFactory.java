package cn.com.hatechframework.server.feign.factory;

import cn.com.hatechframework.server.feign.IFUserDetailsService;
import cn.com.hatechframework.server.feign.fallback.FUserDetailsServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.feign.factory
 * @className FUserDeatilsServiceFallbackFactory
 * @description 用户详情UserDeatilsService的feign fallback工厂实现
 * @author YeMeng
 * @create 2019/12/18 9:41
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 9:41             1.0                         用户详情UserDeatilsService的feign fallback工厂实现
 */
@Slf4j
@Component
public class FUserDetailsServiceFallbackFactory implements FallbackFactory<IFUserDetailsService> {

    /**
     * 用户详情fallback
      */
    private FUserDetailsServiceFallbackImpl userDetailsServiceFallback;

    public FUserDetailsServiceFallbackFactory(FUserDetailsServiceFallbackImpl userDetailsServiceFallback) {
        this.userDetailsServiceFallback = userDetailsServiceFallback;
    }

    /**
     *  用户详情Fallback工厂类
     * @param throwable  feign请求异常
     * @author YeMeng
     * @date 2019/12/24 19:19
     * @return cn.com.hatechframework.feign.IFUserDetailsService
     */
    @Override
    public IFUserDetailsService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return userDetailsServiceFallback;
    }
}
