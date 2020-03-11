package cn.com.hatechframework.config.feign;

import cn.com.hatechframework.config.feign.factory.FRegisterOauthServiceFallbackFactory;
import cn.com.hatechframework.entity.oauth.server.dto.ClientDetailDTO;
import cn.com.hatechframework.utils.response.ResponseObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.feign
 * @className IFRegisterOauthService
 * @description 将服务注册到oauth-server
 * @author WangMingShuai
 * @create 2019/12/20 15:30
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 15:30             1.0                         将服务注册到oauth-server
 */
@FeignClient(value = "HATECH-OAUTH-SERVER",
        contextId = "registerOauthService",
        fallbackFactory = FRegisterOauthServiceFallbackFactory.class)
@Component("registerOauthService")
public interface IFRegisterOauthService {

    /**
     *  注册资源服务
     * @param clientDetailDTO
     * @author WangMingShuai
     * @date 2019/12/25 9:30
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @PostMapping("/client")
    ResponseObject addClient (@RequestBody ClientDetailDTO clientDetailDTO);
}
