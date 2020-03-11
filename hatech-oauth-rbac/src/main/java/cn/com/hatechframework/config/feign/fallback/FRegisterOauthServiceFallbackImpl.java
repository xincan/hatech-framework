package cn.com.hatechframework.config.feign.fallback;

import cn.com.hatechframework.config.feign.IFRegisterOauthService;
import cn.com.hatechframework.entity.oauth.server.dto.ClientDetailDTO;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.feign.fallback
 * @className FRegisterOauthServiceFallbackImpl
 * @description 将服务注册到oauth-server
 * @author WangMingShuai
 * @create 2019/12/20 15:38
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 15:38             1.0                         将服务注册到oauth-server
 */
@Component
public class FRegisterOauthServiceFallbackImpl implements IFRegisterOauthService {

    /**
     * 注册资源服务
     * @param clientDetailDTO
     * @author WangMingShuai
     * @date 2019/12/25 9:30
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public ResponseObject addClient(ClientDetailDTO clientDetailDTO) {
        return ResponseResult.error(ResponseCode.REQUEST_TIMEOUT);
    }
}
