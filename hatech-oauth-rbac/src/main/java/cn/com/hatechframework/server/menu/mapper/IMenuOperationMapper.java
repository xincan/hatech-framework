package cn.com.hatechframework.server.menu.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.menu.po.MenuOperationPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.mapper
 * @className IMenuOperationMapper
 * @description 菜单操作关系管理数据层
 * @author WangMingShuai
 * @create 2020/01/15 16:20
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 16:20             1.0                         菜单操作关系管理数据层
 */
@Mapper
public interface IMenuOperationMapper extends IBaseMapper<MenuOperationPO> {

    /**
     * 根据菜单id获取，菜单下的按钮信息
     * @param menuId  菜单ID
     * @author WangMingShuai
     * @date 2020/1/15 16:54
     * @return java.util.List<java.lang.String>
     */
    List<String> findRelationOperationIds(String menuId);

    /**
     * 根据菜单ID、操作id删除菜单按钮关系
     * @param menuId  菜单ID
     * @param operationIdList  操作ID集合
     * @author WangMingShuai
     * @date 2020/1/18 16:03
     * @return void
     */
    boolean deleteMenuOperation(@Param("menuId") String menuId,@Param("operationIdList") List<String> operationIdList);

    /**
     * 根据角色查询菜单操作关系
     * @param roleIdList  多个角色
     * @author WangMingShuai
     * @date 2020/2/3 16:13
     * @return java.util.List<cn.com.hatechframework.server.menu.po.MenuOperationPO>
     */
    List<MenuOperationPO> findMenuOperationByRoles(List<String> roleIdList);

    /**
     * 批量插入菜单操作关系
     * @param menuOperationList  菜单操作关系集合
     * @author WangMingShuai
     * @date 2020/2/3 16:13
     * @return void
     */
    void batchInsert(List<MenuOperationPO> menuOperationList);
}
