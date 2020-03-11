package cn.com.hatechframework.server.menu.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.menu.dto.MenuPageDTO;
import cn.com.hatechframework.server.menu.po.MenuPO;
import cn.com.hatechframework.server.menu.vo.MenuOperationTreeVo;
import cn.com.hatechframework.server.menu.vo.MenuVO;
import cn.com.hatechframework.server.operation.vo.OperationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.mapper
 * @className IMenuMapper
 * @description 菜单信息数据访问层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         菜单信息数据访问层
 */
@Mapper
public interface IMenuMapper extends IBaseMapper<MenuPO> {

    /**
     * 菜单分页查询
     * @param page
     * @param menuPageDTO  分页查询条件
     * @author WangMingShuai
     * @date 2020/1/7 11:37
     * @return java.util.List<cn.com.hatechframework.server.menu.vo.MenuVO>
     */
    List<MenuVO> findPage(Page<MenuVO> page, @Param("params") MenuPageDTO menuPageDTO);

    /**
     * 根据条件查询菜单
     * @param menuVo  查询条件
     * @author WangMingShuai
     * @date 2020/1/7 11:38
     * @return java.util.List<cn.com.hatechframework.server.menu.vo.MenuVO>
     */
    List<MenuVO> findAll(@Param("params") MenuVO menuVo);

    /**
     * 查询用户按钮权限
     * @param roleIdList  用户ID
     * @param parentId  菜单ID
     * @author WangMingShuai
     * @date 2020/1/13 9:31
     * @return java.util.List<cn.com.hatechframework.server.operation.vo.OperationVO>
     */
    List<OperationVO> findUserButtonByParentId(@Param("roleIdList") List<String> roleIdList, @Param("parentId") String parentId);

    /**
     * 查询用户菜单权限
     * @param roleIdList  用户ID
     * @author WangMingShuai
     * @date 2020/1/13 9:31
     * @return java.util.List<cn.com.hatechframework.server.menu.vo.MenuVO>
     */
    List<MenuVO> findUserMenu(@Param("roleIdList") List<String> roleIdList);

    /**
     * 获取权限树
     * @author WangMingShuai
     * @date 2020/1/15 17:19
     * @return java.util.List<cn.com.hatechframework.server.menu.vo.MenuVO>
     */
    List<MenuOperationTreeVo> findPermissionTree();

    /**
     * 根据角色获取菜单信息
     * @param roleIdList  多个角色
     * @author WangMingShuai
     * @date 2020/2/3 15:49
     * @return java.util.List<cn.com.hatechframework.server.menu.po.MenuPO>
     */
    List<MenuPO> findMenuByRoles(List<String> roleIdList);

    /**
     * 批量保存角色
     * @param menuList  角色集合
     * @author WangMingShuai
     * @date 2020/2/3 15:50
     * @return void
     */
    void batchInsert(List<MenuPO> menuList);
}
