package cn.com.hatechframework.server.controller;

import cn.com.hatechframework.config.log.OptionLog;
import cn.com.hatechframework.entity.oauth.rbac.dto.UserLoginDTO;
import cn.com.hatechframework.entity.oauth.server.dto.OAuthRefreshParamDTO;
import cn.com.hatechframework.server.dto.OAuthCodeDTO;
import cn.com.hatechframework.server.dto.OAuthCodeTokenDTO;
import cn.com.hatechframework.server.service.IAuthorizeService;
import cn.com.hatechframework.server.service.IUserService;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.controller.UserController
 * @className UserController
 * @description UserController接口类
 * @author YeMeng
 * @create 2019/12/18 16:37
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 16:37             1.0                        UserController接口类
 */
@Slf4j
@Api(value = "cn.com.hatechframework.server.controller.UserController", tags = {"用户接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 注入用户service
     */
    private final IUserService userService;

    /**
     * 注入认证service
     */
    private final IAuthorizeService authorizeService;

    public UserController(IUserService userService, IAuthorizeService authorizeService) {
        this.userService = userService;
        this.authorizeService = authorizeService;
    }

    /**
     *  用户登陆(用户名密码)
     * @param userLoginDTO  用户登陆参数
     * @author WangMingShuai
     * @date 2019/12/24 19:53
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @OptionLog()
    @ApiOperation(value="用户名密码登录",httpMethod="POST",notes="根据用户名密码登陆系统")
    @PostMapping(value = "/login")
    public ResponseObject login(@ApiParam @Validated @RequestBody UserLoginDTO userLoginDTO) {
        OAuth2AccessToken token =  userService.usernamePasswordLogin(userLoginDTO);
        return ResponseResult.success(token);
    }

    /**
     *  用户退出
     * @param principal 用户详情
     * @author YeMeng
     * @date 2019/12/24 18:09
     * @return boolean
     */
    @ApiOperation(value="用户退出",httpMethod="POST",notes="根据token用户退出")
    @PostMapping("/logout")
    public ResponseObject logout(@ApiIgnore Principal principal) {
        boolean res = userService.userLogout((OAuth2Authentication) principal);
        return res? ResponseResult.success("用户退出成功", true) : ResponseResult.error("用户退出失败", false);
    }

    /**
     *  请求authorization code校验码
     * @param oAuthCodeDTO oauth code请求参数
     * @param sessionStatus session状态
     * @author YeMeng
     * @date 2019/12/24 19:00
     * @return java.lang.String
     */
    @ApiOperation(value="请求authorization code校验码",httpMethod="GET",notes="根据参数请求authorization code校验码")
    @SuppressWarnings("unchecked")
    @GetMapping(value = "/authorize")
    public ResponseObject authorize(@ApiParam @Validated OAuthCodeDTO oAuthCodeDTO,
                                    @ApiIgnore SessionStatus sessionStatus) {
        String url = authorizeService.authorize(oAuthCodeDTO, sessionStatus);
        return url == null? ResponseResult.error("请求authorization code校验码失败") : ResponseResult.success("请求authorization code校验码成功",url);
    }

    /**
     *  通过校验码code获取token
     * @param oAuthCodeTokenDTO oauth token 参数
     * @author YeMeng
     * @date 2019/12/24 19:10
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="校验码code获取token",httpMethod="GET",notes="通过校验码code获取token")
    @GetMapping("/code/token")
    public ResponseObject getTokenByCode(@ApiParam @Validated OAuthCodeTokenDTO oAuthCodeTokenDTO) {
        OAuth2AccessToken token = userService.userCodeLogin(oAuthCodeTokenDTO);
        return ResponseResult.success(token);
    }

    /**
     *  刷新token
     * @param oAuthRefreshParamDTO refresh_token值
     * @author YeMeng
     * @date 2019/12/25 20:30
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="刷新token",httpMethod="POST",notes="通过refresh_token值刷新token")
    @PostMapping("/refresh/token")
    public ResponseObject refreshToken(@ApiParam @Validated @RequestBody OAuthRefreshParamDTO oAuthRefreshParamDTO) {
        OAuth2AccessToken token = userService.userRefreshLogin(oAuthRefreshParamDTO);
        return ResponseResult.success(token);
    }

}
