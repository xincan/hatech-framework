package cn.com.hatechframework.server.feign.factory;

import cn.com.hatechframework.server.feign.IFSystemLogService;
import cn.com.hatechframework.server.feign.fallback.FSystemLogServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.feign.factory
 * @className FSystemLogServiceFallbackFactory
 * @description 系统日志feign接口fallback工厂类
 * @author YeMeng
 * @create 2019/12/26 16:56
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/26 16:56             1.0                         系统日志feign接口fallback工厂类
 */
@Slf4j
@Component
public class FSystemLogServiceFallbackFactory implements FallbackFactory<IFSystemLogService> {

    private final FSystemLogServiceFallbackImpl fSystemLogServiceFallback;

    public FSystemLogServiceFallbackFactory(FSystemLogServiceFallbackImpl fSystemLogServiceFallback) {
        this.fSystemLogServiceFallback = fSystemLogServiceFallback;
    }

    @Override
    public IFSystemLogService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return fSystemLogServiceFallback;
    }
}
