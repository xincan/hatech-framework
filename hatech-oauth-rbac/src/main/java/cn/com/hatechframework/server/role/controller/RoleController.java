package cn.com.hatechframework.server.role.controller;

import cn.com.hatechframework.config.shardingjdbc.SwitchDataSource;
import cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO;
import cn.com.hatechframework.server.role.dto.RoleInsertDTO;
import cn.com.hatechframework.server.role.dto.RolePageDTO;
import cn.com.hatechframework.server.role.dto.RoleUpdateDTO;
import cn.com.hatechframework.server.role.po.RolePO;
import cn.com.hatechframework.server.role.service.IRoleService;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.controller
 * @className RoleController
 * @description 角色管理控制层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         角色管理控制层
 */
@Slf4j
@Api(value = "cn.com.hatechframework.server.role.controller.RoleController", tags = {"角色管理"})
@RestController
@RequestMapping("/role")
public class RoleController {

    private IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 角色分页查询
     * @param rolePageDTO  分页查询参数
     * @author WangMingShuai
     * @date 2019/12/24 19:47
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="角色分页查询",httpMethod="GET",notes="根据参数分页查询角色")
    @GetMapping("/page")
    @SwitchDataSource
    public ResponseObject page(@ApiParam @Validated RolePageDTO rolePageDTO) {
        Page<RoleVO> page = roleService.findPage(rolePageDTO);
        if (page != null) {
            return ResponseResult.success("角色分页查询成功！",page.getTotal(),page.getRecords());
        }
        return ResponseResult.error("角色分页查询失败！");
    }

    /**
     * 全部角色
     * @author WangMingShuai
     * @date 2019/12/24 19:47
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="全部角色",httpMethod="GET",notes="查询所有角色")
    @GetMapping("")
    @SwitchDataSource
    public ResponseObject all() {
        List<RolePO> list = roleService.list();
        if (list != null) {
            return ResponseResult.success("全部角色查询成功！",list.size(),list);
        }
        return ResponseResult.error("全部角色查询失败！");
    }

    /**
     * 新增角色
     * @param roleInsertDTO  角色信息
     * @author WangMingShuai
     * @date 2019/12/24 19:48
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="新增角色",httpMethod="POST",notes="根据参数新增角色")
    @PostMapping("/insert")
    @SwitchDataSource
    public ResponseObject insert(@ApiParam @RequestBody @Validated RoleInsertDTO roleInsertDTO) {
        RolePO role = OrikaUtils.map(roleInsertDTO, RolePO.class);
        int num = roleService.insertRole(role);
        if (num > 0) {
            return ResponseResult.success("新增角色成功！",num);
        }
        return ResponseResult.error("新增角色失败！");
    }

    /**
     * 修改角色
     * @param roleUpdateDTO  角色信息
     * @author WangMingShuai
     * @date 2019/12/24 19:49
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="修改角色",httpMethod="POST",notes="根据参数修改角色")
    @PostMapping("/update")
    @SwitchDataSource
    public ResponseObject update(@ApiParam @RequestBody @Validated RoleUpdateDTO roleUpdateDTO) {
        RolePO role = OrikaUtils.map(roleUpdateDTO, RolePO.class);
        int num = roleService.updateRole(role);
        if (num > 0) {
            return ResponseResult.success("修改角色成功！",num);
        }
        return ResponseResult.error("修改角色失败！");
    }

    /**
     * 删除角色
     * @param ids  角色ids
     * @author WangMingShuai
     * @date 2019/12/24 19:49
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="删除角色",httpMethod="DELETE",notes="根据id删除角色，多个逗号分隔，例如 123,456")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "角色ids", dataType = "String", required = true, paramType = "query",example = "123,456")
    })
    @DeleteMapping("/delete")
    @SwitchDataSource
    public ResponseObject delete(@RequestParam(value = "ids") String ids) {
        if (StringUtils.isEmpty(ids)) {
            return ResponseResult.error("请选择需要删除的角色！");
        }
        if (roleService.findRoleEnabledCount(ids) > 0) {
            return ResponseResult.error("删除的角色中含有已启用的角色, 请先停用角色后删除！");
        }
        roleService.deleteRoleByIds(ids);
        return ResponseResult.success("删除角色成功！");
    }

    /**
     * 根据角色id，启用/停用角色
     * @param id  角色id
     * @author WangMingShuai
     * @date 2020/2/6 14:16
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="角色启用/停用",httpMethod="PUT",notes="根据数据库中角色状态, 启用/停用角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", dataType = "String", required = true, paramType = "query",example = "123")
    })
    @PutMapping("/update/status")
    @SwitchDataSource
    public ResponseObject updateStatus (@ApiParam @RequestParam("id") String id) {
        int num = roleService.updateStatusById(id);
        if (num > 0) {
            return ResponseResult.success("角色状态修改成功！",num);
        }
        return ResponseResult.error("角色状态修改失败！");
    }

}
