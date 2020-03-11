package cn.com.hatechframework.server.feign.fallback;

import cn.com.hatechframework.entity.oauth.server.dto.OAuthParamDTO;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.server.feign.IFUserOauthService;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.feign.fallback
 * @className FUserOauthServiceFallbackImpl
 * @description 用户登陆认证feign fallback实现
 * @author WangMingShuai
 * @create 2019/12/18 16:40
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/18 16:40             1.0                         用户登陆认证
 */
@Component
public class FUserOauthServiceFallbackImpl implements IFUserOauthService {

    /**
     * 用户登陆
     * @param oAuthParamDTO
     * @author WangMingShuai
     * @date 2019/12/30 19:05
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public ResponseObject userLogin(OAuthParamDTO oAuthParamDTO) {
        return ResponseResult.error(ResponseCode.REQUEST_TIMEOUT);
    }

    /**
     * 用户退出
     * @author WangMingShuai
     * @date 2019/12/30 19:05
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public ResponseObject logout() {
        return ResponseResult.error(ResponseCode.REQUEST_TIMEOUT);
    }

    /**
     * 查询租户数据源超时
     * @author YeMeng
     * @date 2019/12/27 13:43
     * @return cn.com.hatechframework.utils.response.ResponseObject<cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO>
     */
    @Override
    public ResponseObject<List<TenantDataSourceVO>> findAllTenantDataSource() {
        return ResponseResult.error(ResponseCode.REQUEST_TIMEOUT);
    }
}
