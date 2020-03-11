package cn.com.hatechframework.server.feign.factory;

import cn.com.hatechframework.server.feign.IFUserOauthService;
import cn.com.hatechframework.server.feign.fallback.FUserOauthServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.feign.factory
 * @className FUserOauthServiceFallbackFactory
 * @description 用户登陆认证feign fallback工厂实现
 * @author WangMingShuai
 * @create 2019/12/18 16:50
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/18 16:50             1.0                         用户登陆认证feign fallback工厂实现
 */
@Component
@Slf4j
public class FUserOauthServiceFallbackFactory implements FallbackFactory<IFUserOauthService> {

    private FUserOauthServiceFallbackImpl userOauthServiceFallback;

    @Autowired
    public FUserOauthServiceFallbackFactory(FUserOauthServiceFallbackImpl userOauthServiceFallback) {
        this.userOauthServiceFallback = userOauthServiceFallback;
    }

    @Override
    public IFUserOauthService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return userOauthServiceFallback;
    }
}
