package cn.com.hatechframework.server.role.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO;
import cn.com.hatechframework.server.role.dto.RolePageDTO;
import cn.com.hatechframework.server.role.po.RoleMenuOperationPO;
import cn.com.hatechframework.server.role.po.RolePO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.mapper
 * @className IRoleMapper
 * @description 角色信息数据访问层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         角色信息数据访问层
 */
@Mapper
public interface IRoleMapper extends IBaseMapper<RolePO> {

    /**
     * 角色分页查询
     * @param page
     * @param rolePageDTO  分页参数
     * @author WangMingShuai
     * @date 2020/1/7 11:23
     * @return java.util.List<cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO>
     */
    List<RoleVO> findAll(Page<RoleVO> page, @Param("params") RolePageDTO rolePageDTO);

    /**
     * 根据角色Id删除角色菜单关系
     * @param roleId  角色id
     * @author WangMingShuai
     * @date 2020/1/7 11:25
     * @return boolean
     */
    boolean deleteRoleMenuByRoleId(String roleId);

    /**
     * 根据角色Id删除角色菜单关系
     * @param roleIdList  角色id集合
     * @author WangMingShuai
     * @date 2020/1/7 11:25
     * @return boolean
     */
    boolean deleteRoleMenuByRoleIds(@Param("roleIdList") List<String> roleIdList);

    /**
     * 根据角色名称获取角色信息
     * @param roleNames  角色名称
     * @author WangMingShuai
     * @date 2020/2/3 16:58
     * @return java.util.List<cn.com.hatechframework.server.role.po.RolePO>
     */
    List<RolePO> findRoleByNames(List<String> roleNames);

    /**
     * 根据角色获取角色菜单操作关系
     * @param roleIdList  多个角色
     * @author WangMingShuai
     * @date 2020/2/3 17:00
     * @return java.util.List<cn.com.hatechframework.server.role.po.RoleMenuOperationPO>
     */
    List<RoleMenuOperationPO> findRoleMenuOperationByRoles(List<String> roleIdList);

    /**
     * 根据角色id启用停用角色
     * @param id  角色id
     * @author WangMingShuai
     * @date 2020/2/6 14:17
     * @return int
     */
    int updateStatusById(String id);

    /**
     * 根据角色名称查询角色信息
     * @param roleName  角色名称
     * @author WangMingShuai
     * @date 2020/2/6 14:17
     * @return int
     */
    RolePO findRoleByName(String roleName);
}
