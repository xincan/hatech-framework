package cn.com.hatechframework.server.user.controller;

import cn.com.hatechframework.config.log.OptionLog;
import cn.com.hatechframework.config.shardingjdbc.SwitchDataSource;
import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.user.dto.PasswordUpdateDTO;
import cn.com.hatechframework.server.user.dto.UserInsertDTO;
import cn.com.hatechframework.server.user.dto.UserPageDTO;
import cn.com.hatechframework.server.user.dto.UserUpdateDTO;
import cn.com.hatechframework.server.user.po.UserPO;
import cn.com.hatechframework.server.user.service.IUserService;
import cn.com.hatechframework.server.user.vo.UserRoleVO;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.context.BaseContextHandler;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.controller
 * @className UserController
 * @description 用户管理控制层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         用户管理控制层
 */
@Slf4j
@Api(value = "cn.com.hatechframework.server.user.controller.UserController", tags = {"用户管理"})
@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController (IUserService userService) {
        this.userService = userService;
    }

    /**
     * 根据账号和租户数据源名称查询用户信息
     * @param username  账号
     * @param tenantName  租户数据源名称
     * @author WangMingShuai
     * @date 2019/12/24 19:52
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="查询用户信息",httpMethod="GET",notes="根据账号查询用户信息")
    @GetMapping("/findUserByUsername")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "tenantName", value = "租户名称", dataType = "String", required = true, paramType = "query")
    })
    public ResponseObject findUserByUsername(@RequestParam("username") String username, @RequestParam("tenantName") String tenantName) {
        UserVO userVo = userService.findUserByUsername(username, tenantName);
        if (!ObjectUtils.isEmpty(userVo)) {
            return ResponseResult.success("根据账号查询用户信息成功！",userVo);
        }
        return ResponseResult.error("根据账号查询用户信息失败！");
    }

    /**
     * 获取用户详情
     * @author WangMingShuai
     * @date 2020/1/10 15:57
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @OptionLog()
    @ApiOperation(value="获取用户详情",httpMethod="GET",notes="根据TOKEN获取用户详情")
    @GetMapping(value = "/detail")
    public ResponseObject detail () {
        UserVO userVO = (UserVO) BaseContextHandler.getUser();
        userVO.setPassword(null);
        return ResponseResult.success(userVO);
    }

    /**
     * 用户分页查询
     * @param userPageDTO  分页查询参数
     * @author WangMingShuai
     * @date 2019/12/24 19:53
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="用户分页查询",httpMethod="GET",notes="根据参数分页查询用户信息")
    @GetMapping("/page")
    @SwitchDataSource
    public ResponseObject page(@ApiParam @Validated UserPageDTO userPageDTO) {
        Page<UserRoleVO> page = userService.findPage(userPageDTO);
        return ResponseResult.success("用户分页查询成功！",page.getTotal(),page.getRecords());
    }

    /**
     * 添加用户
     * @param userInsertDTO  用户信息
     * @author WangMingShuai
     * @date 2019/12/24 19:54
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="添加用户",httpMethod="POST",notes="根据参数添加用户")
    @PostMapping("/insert")
    public ResponseObject insert(@ApiParam @RequestBody @Validated UserInsertDTO userInsertDTO) {
        UserPO user = userService.insertUser(userInsertDTO);
        return ResponseResult.success("用户添加成功", user.getId());
    }

    /**
     * 修改用户
     * @param userUpdateDTO  用户信息
     * @author WangMingShuai
     * @date 2019/12/24 19:54
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="修改用户",httpMethod="POST",notes="根据参数修改用户")
    @PostMapping("/update")
    @SwitchDataSource
    public ResponseObject update(@ApiParam @RequestBody @Validated UserUpdateDTO userUpdateDTO) {
        UserPO user = OrikaUtils.map(userUpdateDTO, UserPO.class);
        return userService.updateUser(user) ? ResponseResult.success("修改用户成功",user.getId())
                : ResponseResult.success("修改用户失败",user.getId());
    }

    /**
     * 删除用户
     * @param ids  用户ids
     * @author WangMingShuai
     * @date 2019/12/24 19:54
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="删除用户",httpMethod="DELETE",notes="根据id删除用户，多个id都和分隔，例如 123,456")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "用户ids", dataType = "String", required = true, paramType = "query",example = "123,456")
    })
    @DeleteMapping("/delete")
    public ResponseObject delete(@RequestParam("ids") String ids) {
        if (!StringUtils.isEmpty(ids)) {
            if (userService.findEnabledUser(ids) > 0) {
                return ResponseResult.error("删除用户中含有已启用的用户,请停用后再删除! ");
            }
            if (userService.findTenant(ids) > 0) {
                return ResponseResult.error("删除用户中含有租户,不能删除租户! ");
            }
            boolean flag = userService.deleteUser(ids);
            if (flag) {
                return ResponseResult.success("删除用户成功！");
            }
            ResponseResult.error("删除用户失败！");
        }
        return ResponseResult.error("请选择需要删除的用户！");
    }

    /**
     * 用户状态启用停用
     * @param id 用户id
     * @author YeMeng
     * @date 2020/1/20 13:52
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="用户状态启用停用, 状态值自动取反",httpMethod="PUT",notes="根据数据库中用户状态, 启用/停用该用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "String", required = true, paramType = "query",example = "123")
    })
    @PutMapping("/enable")
    @SwitchDataSource
    public ResponseObject enable(@ApiParam @RequestParam("id") String id) {
        int num = userService.enableUser(id);
        if (num > 0) {
            return ResponseResult.success("用户状态修改成功！",num);
        }
        return ResponseResult.error("用户状态修改失败！");
    }

    /**
     * 重置用户密码
     * @param id  用户id
     * @author WangMingShuai
     * @date 2019/12/24 19:54
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="重置用户密码",httpMethod="PUT",notes="根据用户id重置用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "String", required = true, paramType = "query",example = "123")
    })
    @PutMapping("/password/reset")
    @SwitchDataSource
    public ResponseObject resetPassword(@ApiParam @RequestParam("id") String id) {
        int num = userService.resetPassword(id);
        if (num > 0) {
            return ResponseResult.success("重置用户密码成功！",num);
        }
        return ResponseResult.error("重置用户密码失败！");
    }

    /**
     * 修改用户密码
     * @param passwordUpdateDTO  修改密码参数
     * @author WangMingShuai
     * @date 2019/12/24 19:54
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="更改用户密码",httpMethod="PUT",notes="根据用户旧密码,更改用户密码为新密码")
    @PostMapping("/password/change")
    @SwitchDataSource
    public ResponseObject changePassword(@Validated @RequestBody PasswordUpdateDTO passwordUpdateDTO) {
        if (!userService.validPassword(passwordUpdateDTO.getOldPwd())) {
            return ResponseResult.error("用户旧密码不匹配");
        }
        int num = userService.changePassword(passwordUpdateDTO);
        if (num > 0) {
            return ResponseResult.success("修改用户密码成功！",num);
        }
        return ResponseResult.error("修改用户密码失败！");
    }
}
