package cn.com.hatechframework.server.feign.fallback;

import cn.com.hatechframework.entity.center.log.dto.SystemLogSaveDTO;
import cn.com.hatechframework.server.feign.IFSystemLogService;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.feign.fallback
 * @className FSystemLogServiceFallback
 * @description 系统日志feign接口fallback
 * @author YeMeng
 * @create 2019/12/26 16:53
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/26 16:53             1.0                         系统日志feign接口fallback
 */
@Component
public class FSystemLogServiceFallbackImpl implements IFSystemLogService {

    /**
     *  保存系统日志
     * @param systemLogSaveDTO 系统日志
     * @author YeMeng
     * @date 2019/12/26 16:54
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public ResponseObject save(SystemLogSaveDTO systemLogSaveDTO) {
        return ResponseResult.error("{}", "保存系统日志失败");
    }
}
