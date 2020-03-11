package cn.com.hatechframework.server.feign;

import cn.com.hatechframework.entity.center.log.dto.SystemLogSaveDTO;
import cn.com.hatechframework.server.feign.factory.FSystemLogServiceFallbackFactory;
import cn.com.hatechframework.utils.response.ResponseObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.feign
 * @className IFLogService
 * @description log日志feign接口
 * @author YeMeng
 * @create 2019/12/26 16:23
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/26 16:23             1.0                         log日志feign接口
 */
@FeignClient(
        name = "HATECH-CENTER-LOG"
        ,fallbackFactory = FSystemLogServiceFallbackFactory.class
)
@Component("fSystemLogService")
public interface IFSystemLogService {

    /**
     * 添加日志信息
     * @param systemLogSaveDTO  系统日志实体
     * @author YeMeng
     * @date 2020/2/10 16:34
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @PostMapping("/system/insert")
    ResponseObject save(@RequestBody SystemLogSaveDTO systemLogSaveDTO);

}
