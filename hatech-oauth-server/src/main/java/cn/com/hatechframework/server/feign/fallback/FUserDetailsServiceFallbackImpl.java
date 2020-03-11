package cn.com.hatechframework.server.feign.fallback;

import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.feign.IFUserDetailsService;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.feign.fallback
 * @className FUserDetailsServiceFallback
 * @description 用户详情UserDeatilsService的feign fallback实现
 * @author YeMeng
 * @create 2019/12/18 9:43
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 9:43             1.0                         用户详情UserDeatilsService的feign fallback实现
 */
@Component
public class FUserDetailsServiceFallbackImpl implements IFUserDetailsService {

    /**
     *  根据用户名查询用户详情Fallback接口
     * @param username 用户名
     * @param tenantName 租户
     * @author YeMeng
     * @date 2019/12/24 19:16
     * @return cn.com.hatechframework.utils.response.ResponseObject<cn.com.hatechframework.po.UserVO>
     */
    @Override
    public ResponseObject<UserVO> findUserByUsername(String username, String tenantName) {
        return ResponseResult.error(ResponseCode.USER_NOT_EXIST);
    }
}
