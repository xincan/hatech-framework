package cn.com.hatechframework.server.controller;

import cn.com.hatechframework.entity.oauth.server.dto.OAuthParamDTO;
import cn.com.hatechframework.server.service.IUserService;
import cn.com.hatechframework.utils.response.ResponseObject;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.Map;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.controller
 * @className OAuthController
 * @description oauth内部接口类, 不对外暴露
 * @author YeMeng
 * @create 2020/1/7 16:49
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2020/1/7 16:49             1.0                         oauth内部接口类, 不对外暴露
 */
@ApiIgnore
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    /**
     * 注入用户service
     */
    private final IUserService userService;

    public AuthenticationController(IUserService userService) {
        this.userService = userService;
    }

    /**
     *  用户oauth登录
     * @param oAuthParamDTO  登录参数
     * @author YeMeng
     * @date 2019/12/24 18:08
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @PostMapping("/login")
    public OAuth2AccessToken login(@Validated @RequestBody OAuthParamDTO oAuthParamDTO) {
        return userService.userOAuthLogin(oAuthParamDTO);
    }

    /**
     *  校验token, 此处返回类型为Map<String, Object>, 为了给oauth resource资源端提供对应的返回类型
     * @param value  token
     * @author YeMeng
     * @date 2019/12/24 18:09
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @PostMapping("/check_token")
    public Map<String, Object> checkToken(@RequestParam("token") String value) {
        return userService.checkToken(value);
    }

    /**
     *  通过token获取用户信息
     * @param principal  用户详情
     * @author YeMeng
     * @date 2019/12/24 18:10
     * @return java.security.Principal
     */
    @PostMapping("/principal")
    public Principal principal(Principal principal) {
        return userService.principal(principal);
    }

}
