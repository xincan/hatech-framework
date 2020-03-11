package cn.com.hatechframework.server.tenant.controller;

import cn.com.hatechframework.entity.oauth.rbac.dto.UserTenantRegisterDTO;
import cn.com.hatechframework.server.tenant.service.IUserTenantService;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.tenant.controller
 * @className TenantController
 * @description 租户管理控制层
 * @author WangMingShuai
 * @create 2020/1/6 20:29
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/6 20:29             1.0                         租户管理控制层
 */
@Slf4j
@Api(value = "cn.com.hatechframework.server.tenant.controller.TenantController", tags = {"租户管理"})
@RestController
@RequestMapping("/tenant")
public class TenantController {

    private final IUserTenantService userTenantService;

    public TenantController(IUserTenantService userTenantService) {
        this.userTenantService = userTenantService;
    }

    /**
     * 租户注册
     * @param userTenantRegisterDTO  租户注册
     * @author WangMingShuai
     * @date 2019/12/28 14:20
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="租户注册",httpMethod="POST",notes="根据参数注册租户")
    @PostMapping(value = "/register")
    public ResponseObject register (@ApiParam @Validated @RequestBody UserTenantRegisterDTO userTenantRegisterDTO) {
        userTenantService.registerUser(userTenantRegisterDTO);
        return ResponseResult.success("租户注册成功",1);
    }
}
