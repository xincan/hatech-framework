package cn.com.hatechframework.server.feign;

import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.feign.factory.FUserDetailsServiceFallbackFactory;
import cn.com.hatechframework.utils.response.ResponseObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.feign
 * @className IFUserDeatilsService
 * @description 用户详情UserDetails的feign接口
 * @author YeMeng
 * @create 2019/12/18 9:39
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 9:39             1.0                         用户详情UserDetails的feign接口
 */
@FeignClient(
        name = "HATECH-OAUTH-RBAC"
        ,fallbackFactory = FUserDetailsServiceFallbackFactory.class
)
@Component("fUserDetailsService")
public interface IFUserDetailsService {

    /**
     *  根据用户名查询用户详情
     * @param username 用户名
     * @param tenantName 租户名
     * @author YeMeng
     * @date 2019/12/24 19:16
     * @return cn.com.hatechframework.utils.response.ResponseObject<cn.com.hatechframework.po.UserPO>
     */
    @GetMapping("/user/findUserByUsername")
    ResponseObject<UserVO> findUserByUsername(@RequestParam("username") String username, @RequestParam("tenantName") String tenantName);

}
