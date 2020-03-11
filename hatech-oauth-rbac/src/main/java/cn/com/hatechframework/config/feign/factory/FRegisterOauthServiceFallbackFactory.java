package cn.com.hatechframework.config.feign.factory;

import cn.com.hatechframework.config.feign.IFRegisterOauthService;
import cn.com.hatechframework.config.feign.fallback.FRegisterOauthServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.feign.factory
 * @className FRegisterOauthServiceFallbackFactory
 * @description 将服务注册到oauth-server
 * @author WangMingShuai
 * @create 2019/12/20 15:39
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 15:39             1.0                         将服务注册到oauth-server
 */
@Component
@Slf4j
public class FRegisterOauthServiceFallbackFactory implements FallbackFactory<IFRegisterOauthService> {

    private FRegisterOauthServiceFallbackImpl fRegisterOauthServiceFallback;

    public FRegisterOauthServiceFallbackFactory (FRegisterOauthServiceFallbackImpl fRegisterOauthServiceFallback) {
        this.fRegisterOauthServiceFallback = fRegisterOauthServiceFallback;
    }

    @Override
    public IFRegisterOauthService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return fRegisterOauthServiceFallback;
    }
}
