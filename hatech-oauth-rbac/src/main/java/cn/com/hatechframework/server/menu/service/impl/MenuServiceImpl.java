package cn.com.hatechframework.server.menu.service.impl;

import cn.com.hatechframework.config.exception.BusinessException;
import cn.com.hatechframework.data.page.Pagination;
import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO;
import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.menu.dto.MenuPageDTO;
import cn.com.hatechframework.server.menu.enums.OperationTypeEnum;
import cn.com.hatechframework.server.menu.mapper.IMenuMapper;
import cn.com.hatechframework.server.menu.po.MenuPO;
import cn.com.hatechframework.server.menu.service.IMenuService;
import cn.com.hatechframework.server.menu.utils.TreeUtils;
import cn.com.hatechframework.server.menu.vo.MenuOperationTreeVo;
import cn.com.hatechframework.server.menu.vo.MenuVO;
import cn.com.hatechframework.server.operation.vo.OperationVO;
import cn.com.hatechframework.utils.context.BaseContextHandler;
import cn.com.hatechframework.utils.response.ResponseCode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.service.impl
 * @className MenuServiceImpl
 * @description 菜单信息接口层实现
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         菜单信息接口层实现
 */
@Service("menuService")
public class MenuServiceImpl extends AbstractService<MenuPO> implements IMenuService {

    private static final String DEFAULT_PARENT_ID = "0";

    @Resource
    private IMenuMapper menuMapper;

    /**
     * 菜单分页查询
     * @param menuPageDTO  菜单分页条件
     * @author WangMingShuai
     * @date 2019/12/24 17:43
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.menu.vo.MenuVo>
     */
    @Override
    public Page<MenuVO> findPage(MenuPageDTO menuPageDTO) {
        Page<MenuVO> page = Pagination.page(menuPageDTO);
        List<MenuVO> list = menuMapper.findPage(page,menuPageDTO);
        page.setRecords(list);
        return page;
    }

    /**
     * 查询菜单树
     * @param
     * @author WangMingShuai
     * @date 2019/12/24 17:47
     * @return java.util.List<cn.com.hatechframework.server.menu.vo.MenuVo>
     */
    @Override
    public List<MenuVO> findMenuTree() {
        List<MenuVO> list = this.menuMapper.findAll(new MenuVO());
        return TreeUtils.listToTree(list, DEFAULT_PARENT_ID);
    }

    /**
     * 添加菜单
     * @param menu  菜单信息
     * @author WangMingShuai
     * @date 2019/12/24 17:46
     * @return java.lang.Integer
     */
    @Override
    public int insertMenu(MenuPO menu) {
        return this.menuMapper.insert(initMenu(menu));
    }

    /**
     * 修改菜单
     * @param menu  菜单信息
     * @author WangMingShuai
     * @date 2019/12/24 17:46
     * @return java.lang.Integer
     */
    @Override
    public int updateMenu(MenuPO menu) {
        return this.menuMapper.updateById(initMenu(menu));
    }

    /**
     * 查询用户按钮权限
     * @param parentId  父级菜单id
     * @author WangMingShuai
     * @date 2020/1/13 9:27
     * @return java.util.List<cn.com.hatechframework.server.operation.vo.OperationVO>
     */
    @Override
    public List<OperationVO> findUserButtonByParentId(String parentId) {
        List<RoleVO> roleVOList = ((UserVO) BaseContextHandler.getUser()).getAuthorities();
        if (CollectionUtils.isEmpty(roleVOList)) {
            return Lists.newArrayList();
        }
        List<String> roleIdList = roleVOList.stream().map(RoleVO::getId).collect(Collectors.toList());
        return this.menuMapper.findUserButtonByParentId(roleIdList,parentId);
    }

    /**
     * 查询用户菜单权限
     * @author WangMingShuai
     * @date 2020/1/13 9:27
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @Override
    public List<MenuVO> findUserMenu() {
        List<RoleVO> roleVOList = ((UserVO) BaseContextHandler.getUser()).getAuthorities();
        if (CollectionUtils.isEmpty(roleVOList)) {
            return Lists.newArrayList();
        }
        List<String> roleIdList = roleVOList.stream().map(RoleVO::getId).collect(Collectors.toList());
        List<MenuVO> list = this.menuMapper.findUserMenu(roleIdList);
        return TreeUtils.listToTree(list, DEFAULT_PARENT_ID);
    }

    /**
     * 获取权限树
     * @param
     * @author WangMingShuai
     * @date 2019/12/24 17:47
     * @return java.util.List<cn.com.hatechframework.server.menu.vo.MenuVo>
     */
    @Override
    public List<MenuOperationTreeVo> findPermissionTree() {
        List<MenuOperationTreeVo> list = this.menuMapper.findPermissionTree();
        list.forEach(treeVo -> {
            if (StringUtils.isEmpty(treeVo.getId())) {
                treeVo.setId(treeVo.getMenuId() + "-" + treeVo.getOperationId());
                treeVo.setName(treeVo.getName()+ OperationTypeEnum.getNameByType(treeVo.getType()));
            }
        });
        return TreeUtils.listToTree(list, DEFAULT_PARENT_ID);
    }



    /**
     * 菜单添加修改前数据封装
     * @param menu  菜单
     * @author WangMingShuai
     * @date 2020/1/21 15:31
     * @return cn.com.hatechframework.server.menu.po.MenuPO
     */
    private MenuPO initMenu (MenuPO menu) {
        menu.setEditTime(new Date());
        if (StringUtils.isEmpty(menu.getParentId()) || DEFAULT_PARENT_ID.equals(menu.getParentId())) {
            menu.setParentId(DEFAULT_PARENT_ID);
            menu.setLevel(1);
        } else {
            MenuPO parentMenu = this.menuMapper.selectById(menu.getParentId());
            if (parentMenu == null) {
                throw new BusinessException(ResponseCode.PARAM_ERROR.code(),"参数错误：parentId 不存在");
            }
            menu.setLevel(parentMenu.getLevel()+1);
        }
        return menu;
    }

}
