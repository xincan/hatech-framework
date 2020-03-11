package cn.com.hatechframework.server.role.controller;

import cn.com.hatechframework.config.shardingjdbc.SwitchDataSource;
import cn.com.hatechframework.server.role.dto.RoleGroupInsertDTO;
import cn.com.hatechframework.server.role.dto.RoleGroupPageDTO;
import cn.com.hatechframework.server.role.dto.RoleGroupUpdateDTO;
import cn.com.hatechframework.server.role.po.RoleGroupPO;
import cn.com.hatechframework.server.role.service.IRoleGroupService;
import cn.com.hatechframework.server.role.vo.RoleGroupVO;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.controller
 * @className RoleGroupController
 * @description 角色组组管理控制层
 * @author WangMingShuai
 * @create 2019/12/27 15:08
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 15:08             1.0                         角色组组管理控制层
 */
@Slf4j
@Api(value = "cn.com.hatechframework.server.role.controller.RoleGroupController", tags = {"角色组管理"})
@RestController
@RequestMapping("/role/group")
public class RoleGroupController {

    private IRoleGroupService roleGroupService;

    @Autowired
    public RoleGroupController (IRoleGroupService roleGroupService) {
        this.roleGroupService = roleGroupService;
    }

    /**
     * 角色组分页查询
     * @param roleGroupPageDTO  分页查询参数
     * @author WangMingShuai
     * @date 2019/12/24 19:47
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="角色组分页查询",httpMethod="GET",notes="根据参数分页查询角色组")
    @GetMapping("/page")
    @SwitchDataSource
    public ResponseObject page(@ApiParam @Validated RoleGroupPageDTO roleGroupPageDTO) {
        Page<RoleGroupVO> page = roleGroupService.findPage(roleGroupPageDTO);
        if (page != null) {
            return ResponseResult.success("角色组分页查询成功！",page.getTotal(),page.getRecords());
        }
        return ResponseResult.error("角色组分页查询失败！");
    }

    /**
     * 全部角色组查询
     * @author WangMingShuai
     * @date 2019/12/24 19:47
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="全部角色组",httpMethod="GET",notes="查询全部角色组")
    @GetMapping("")
    @SwitchDataSource
    public ResponseObject all() {
        List<RoleGroupPO> list = roleGroupService.findAll();
        if (list != null) {
            return ResponseResult.success("全部角色组查询成功！",list.size(),list);
        }
        return ResponseResult.error("全部角色组查询失败！");
    }

    /**
     * 新增角色组
     * @param roleGroupInsertDTO  角色组信息
     * @author WangMingShuai
     * @date 2019/12/24 19:48
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="新增角色组",httpMethod="POST",notes="根据参数新增角色组")
    @PostMapping("/insert")
    @SwitchDataSource
    public ResponseObject insert(@ApiParam @RequestBody @Validated RoleGroupInsertDTO roleGroupInsertDTO) {
        RoleGroupPO roleGroup = OrikaUtils.map(roleGroupInsertDTO, RoleGroupPO.class);
        int num = roleGroupService.insertRoleGroup(roleGroup);
        if (num > 0) {
            return ResponseResult.success("新增角色组成功！",num);
        }
        return ResponseResult.error("新增角色组失败！");
    }

    /**
     * 修改角色组
     * @param roleGroupUpdateDTO  角色组信息
     * @author WangMingShuai
     * @date 2019/12/24 19:49
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="修改角色组",httpMethod="POST",notes="根据参数修改角色组")
    @PostMapping("/update")
    @SwitchDataSource
    public ResponseObject update(@ApiParam @RequestBody @Validated RoleGroupUpdateDTO roleGroupUpdateDTO) {
        RoleGroupPO roleGroup = OrikaUtils.map(roleGroupUpdateDTO, RoleGroupPO.class);
        int num = roleGroupService.updateRoleGroup(roleGroup);
        if (num > 0) {
            return ResponseResult.success("修改角色组成功！",num);
        }
        return ResponseResult.error("修改角色组失败！");
    }

    /**
     * 删除角色组
     * @param ids  角色组ids
     * @author WangMingShuai
     * @date 2019/12/24 19:49
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="删除角色组",httpMethod="DELETE",notes="根据id删除角色组，多个id逗号分隔，例如 123,456")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "角色组ids", dataType = "String", required = true, paramType = "query",example = "123,456")
    })
    @DeleteMapping("/delete")
    @SwitchDataSource
    public ResponseObject delete(@RequestParam(value = "ids") String ids) {
        roleGroupService.deleteRoleGroupByIds(ids);
        return ResponseResult.success("删除角色组成功！",1);
    }
}
