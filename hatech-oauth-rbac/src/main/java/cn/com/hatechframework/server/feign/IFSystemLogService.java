package cn.com.hatechframework.server.feign;

import cn.com.hatechframework.entity.center.log.dto.SystemLogSaveDTO;
import cn.com.hatechframework.server.feign.factory.FSystemLogServiceFallbackFactory;
import cn.com.hatechframework.utils.response.ResponseObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.feign
 * @className IFLogService
 * @description log日志feign接口
 * @author YeMeng
 * @create 2019/12/26 16:23
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/26 16:23             1.0                         log日志feign接口
 */
@FeignClient(
        name = "HATECH-CENTER-LOG",
        contextId = "fSystemLogService",
        fallbackFactory = FSystemLogServiceFallbackFactory.class
)
@Component("fSystemLogService")
public interface IFSystemLogService {

    /**
     * 添加日志
     * @param systemLogSaveDTO  添加日志参数
     * @author WangMingShuai
     * @date 2020/1/7 9:56
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @PostMapping("/system/insert")
    ResponseObject save(@RequestBody SystemLogSaveDTO systemLogSaveDTO);

}
