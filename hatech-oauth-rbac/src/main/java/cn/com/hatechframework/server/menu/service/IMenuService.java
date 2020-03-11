package cn.com.hatechframework.server.menu.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.server.menu.dto.MenuPageDTO;
import cn.com.hatechframework.server.menu.po.MenuPO;
import cn.com.hatechframework.server.menu.vo.MenuOperationTreeVo;
import cn.com.hatechframework.server.menu.vo.MenuVO;
import cn.com.hatechframework.server.operation.vo.OperationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.service
 * @className IMenuService
 * @description 菜单信息接口层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         菜单信息接口层
 */
public interface IMenuService extends IBaseService<MenuPO> {

    /**
     * 菜单分页查询
     * @param menuPageDTO  菜单分页条件
     * @author WangMingShuai
     * @date 2019/12/24 17:43
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.menu.vo.MenuVo>
     */
    Page<MenuVO> findPage(MenuPageDTO menuPageDTO);

    /**
     * 查询菜单树
     * @param
     * @author WangMingShuai
     * @date 2019/12/24 17:47
     * @return java.util.List<cn.com.hatechframework.server.menu.vo.MenuVo>
     */
    List<MenuVO> findMenuTree();

    /**
     * 添加菜单
     * @param menu  菜单信息
     * @author WangMingShuai
     * @date 2019/12/24 17:46
     * @return java.lang.Integer
     */
    int insertMenu(MenuPO menu);

    /**
     * 修改菜单
     * @param menu  菜单信息
     * @author WangMingShuai
     * @date 2019/12/24 17:46
     * @return java.lang.Integer
     */
    int updateMenu(MenuPO menu);

    /**
     * 查询用户按钮权限
     * @param parentId  父级菜单id
     * @author WangMingShuai
     * @date 2020/1/13 9:27
     * @return java.util.List<cn.com.hatechframework.server.operation.vo.OperationVO>
     */
    List<OperationVO> findUserButtonByParentId(String parentId);

    /**
     * 查询用户菜单权限
     * @author WangMingShuai
     * @date 2020/1/13 9:27
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    List<MenuVO> findUserMenu();

    /**
     * 获取权限树
     * @param
     * @author WangMingShuai
     * @date 2019/12/24 17:47
     * @return java.util.List<cn.com.hatechframework.server.menu.vo.MenuOperationTreeVo>
     */
    List<MenuOperationTreeVo> findPermissionTree();
}
