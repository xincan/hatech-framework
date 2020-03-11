package cn.com.hatechframework.server.menu.controller;

import cn.com.hatechframework.config.shardingjdbc.SwitchDataSource;
import cn.com.hatechframework.server.menu.dto.MenuInsertDTO;
import cn.com.hatechframework.server.menu.dto.MenuOperationInsertDTO;
import cn.com.hatechframework.server.menu.dto.MenuPageDTO;
import cn.com.hatechframework.server.menu.dto.MenuUpdateDTO;
import cn.com.hatechframework.server.menu.po.MenuPO;
import cn.com.hatechframework.server.menu.service.IMenuOperationService;
import cn.com.hatechframework.server.menu.service.IMenuService;
import cn.com.hatechframework.server.menu.vo.MenuOperationTreeVo;
import cn.com.hatechframework.server.menu.vo.MenuVO;
import cn.com.hatechframework.server.operation.vo.OperationVO;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.controller
 * @className MenuController
 * @description 菜单管理控制层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         菜单管理控制层
 */
@Slf4j
@Api(value = "cn.com.hatechframework.server.menu.controller.MenuController", tags = {"菜单管理"})
@RestController
@RequestMapping("/menu")
public class MenuController {

    private IMenuService menuService;
    private IMenuOperationService menuOperationService;

    @Autowired
    public MenuController(IMenuService menuService,IMenuOperationService menuOperationService) {
        this.menuService = menuService;
        this.menuOperationService = menuOperationService;
    }

    /**
     * 菜单分页查询
     * @param menuPageDTO  菜单分页条件
     * @author WangMingShuai
     * @date 2019/12/24 17:43
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="菜单分页查询",httpMethod="GET",notes="根据参数分页查询菜单")
    @GetMapping("/page")
    @SwitchDataSource
    public ResponseObject page(@ApiParam @Validated MenuPageDTO menuPageDTO) {
        Page<MenuVO> page = menuService.findPage(menuPageDTO);
        return ResponseResult.success("菜单分页查询成功！",page.getTotal(),page.getRecords());
    }

    /**
     * 新增菜单
     * @param menuInsertDTO  菜单信息
     * @author WangMingShuai
     * @date 2019/12/24 17:43
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="新增菜单",httpMethod="POST",notes="根据参数新增菜单")
    @PostMapping("/insert")
    @SwitchDataSource
    public ResponseObject insert(@ApiParam @RequestBody @Validated MenuInsertDTO menuInsertDTO) {
        MenuPO menu = OrikaUtils.map(menuInsertDTO, MenuPO.class);
        int num = menuService.insertMenu(menu);
        if (num > 0) {
            return ResponseResult.success("新增菜单成功！",num);
        }
        return ResponseResult.error("新增菜单失败！");
    }

    /**
     * 修改菜单
     * @param menuUpdateDTO  菜单信息
     * @author WangMingShuai
     * @date 2019/12/24 17:44
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="修改菜单",httpMethod="POST",notes="根据参数修改菜单")
    @PostMapping("/update")
    @SwitchDataSource
    public ResponseObject update(@ApiParam @RequestBody @Validated MenuUpdateDTO menuUpdateDTO) {
        MenuPO menu = OrikaUtils.map(menuUpdateDTO, MenuPO.class);
        int num = menuService.updateMenu(menu);
        if (num > 0) {
            return ResponseResult.success("修改菜单成功！",num);
        }
        return ResponseResult.error("修改菜单失败！");
    }

    /**
     * 删除菜单
     * @param ids  菜单ids
     * @author WangMingShuai
     * @date 2019/12/24 17:44
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="删除菜单",httpMethod="DELETE",notes="根据id删除菜单信息，多个id逗号分隔，例如 123,456")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "菜单ids", dataType = "String", required = true, paramType = "query",example = "123,456")
    })
    @DeleteMapping("/delete")
    @SwitchDataSource
    public ResponseObject delete(@RequestParam(value = "ids") String ids) {
        int num = menuService.deleteByIds(ids);
        if (num > 0) {
            return ResponseResult.success("删除菜单成功！",num);
        }
        return ResponseResult.error("删除菜单失败！");
    }

    /**
     * 查询菜单树
     * @param
     * @author WangMingShuai
     * @date 2019/12/24 17:45
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="查询菜单树",httpMethod="GET",notes="根据参数查询菜单树")
    @GetMapping("/tree")
    @SwitchDataSource
    public ResponseObject tree () {
        List<MenuVO> list = this.menuService.findMenuTree();
        return ResponseResult.success("查询菜单树成功！",list);
    }

    /**
     * 新增菜单操作关联关系
     * @param menuOperationInsertDTO  菜单权限关联关系参数
     * @author WangMingShuai
     * @date 2020/1/15 16:50
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="新增菜单按钮关联关系",httpMethod="POST",notes="根据参数新增菜单按钮关联关系")
    @PostMapping("/insert/operation/relation")
    @SwitchDataSource
    public ResponseObject insertOperationRelation (@ApiParam @RequestBody @Validated MenuOperationInsertDTO menuOperationInsertDTO) {
        boolean result = menuOperationService.insertMenuOperation(menuOperationInsertDTO);
        if (result) {
            return ResponseResult.success("新增菜单操作关系表成功！",result);
        }
        return ResponseResult.error("新增菜单操作关系表失败！");
    }

    /**
     * 根据菜单id获取，菜单下的按钮信息
     * @param menuId  菜单ID
     * @author WangMingShuai
     * @date 2020/1/15 16:52
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="获取菜单下的按钮信息",httpMethod="GET",notes="根据菜单id获取，菜单下的按钮信息")
    @GetMapping("/find/relation/operation")
    @SwitchDataSource
    public ResponseObject findRelationOperation (@RequestParam(name = "menuId") String menuId) {
        List<String> operationIds = menuOperationService.findRelationOperationIds(menuId);
        return ResponseResult.success("获取菜单下的按钮信息成功",operationIds);
    }

    @ApiOperation(value="获取权限树",httpMethod="GET",notes="获取权限树")
    @GetMapping("find/permission/tree")
    @SwitchDataSource
    public ResponseObject findPermissionTree() {
        List<MenuOperationTreeVo> list = this.menuService.findPermissionTree();
        return ResponseResult.success("获取权限树成功！",list);
    }

    /**
     * 查询用户菜单权限
     * @author WangMingShuai
     * @date 2020/1/13 9:27
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="查询用户菜单权限",httpMethod="GET",notes="根据按钮父级id查询用户菜单权限")
    @GetMapping("/user/menu")
    @SwitchDataSource
    public ResponseObject userMenu () {
        List<MenuVO> list = this.menuService.findUserMenu();
        return ResponseResult.success("查询用户菜单权限成功！",list);
    }


    /**
     * 查询用户按钮权限
     * @param parentId  父级菜单id
     * @author WangMingShuai
     * @date 2020/1/13 9:27
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="查询用户按钮权限",httpMethod="GET",notes="根据按钮父级id查询用户按钮权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "菜单id", dataType = "String", required = true, paramType = "query",example = "UUID")
    })
    @GetMapping("/user/button")
    @SwitchDataSource
    public ResponseObject userButton (@RequestParam(name = "parentId") String parentId) {
        List<OperationVO> list = this.menuService.findUserButtonByParentId(parentId);
        return ResponseResult.success("查询用户按钮权限成功！",list);
    }

}
