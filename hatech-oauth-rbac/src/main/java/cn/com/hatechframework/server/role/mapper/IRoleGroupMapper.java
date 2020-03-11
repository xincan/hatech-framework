package cn.com.hatechframework.server.role.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.role.dto.RoleGroupPageDTO;
import cn.com.hatechframework.server.role.po.RoleGroupPO;
import cn.com.hatechframework.server.role.vo.RoleGroupVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.mapper
 * @className IRoleGroupMapper
 * @description 角色组数据访问层
 * @author WangMingShuai
 * @create 2019/12/27 15:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 15:03             1.0                         角色组数据访问层
 */
@Mapper
public interface IRoleGroupMapper extends IBaseMapper<RoleGroupPO> {


    /**
     * 分页查询用户组
     * @param page
     * @param roleGroupPageDTO  分页参数
     * @author WangMingShuai
     * @date 2020/1/7 11:17
     * @return java.util.List<cn.com.hatechframework.server.role.vo.RoleGroupVO>
     */
    List<RoleGroupVO> findAll(Page<RoleGroupVO> page, @Param("params") RoleGroupPageDTO roleGroupPageDTO);

    /**
     * 根据角色组id删除角色组与角色关联关系
     * @param roleGroupId  角色组id
     * @author WangMingShuai
     * @date 2020/1/7 11:18
     * @return boolean
     */
    boolean deleteRoleGroupRoleByRoleGroupId(String roleGroupId);

    /**
     * 根据角色组id删除角色组与角色关联关系
     * @param roleGroupIdList  角色组id集合
     * @author WangMingShuai
     * @date 2020/1/7 11:18
     * @return boolean
     */
    boolean deleteRoleGroupRoleByRoleGroupIds(@Param("roleGroupIdList") List<String> roleGroupIdList);

    /**
     * 根据角色组id删除角色组与用户关联关系
     * @param roleGroupId  角色组id
     * @author WangMingShuai
     * @date 2020/1/7 11:18
     * @return boolean
     */
    boolean deleteRoleGroupUserByRoleGroupId(String roleGroupId);

    /**
     * 根据角色组id删除角色组与用户关联关系
     * @param roleGroupIdList  角色组id集合
     * @author WangMingShuai
     * @date 2020/1/7 11:18
     * @return boolean
     */
    boolean deleteRoleGroupUserByRoleGroupIds(@Param("roleGroupIdList") List<String> roleGroupIdList);

    /**
     * 根据条件查询所有的租户信息
     * @param roleGroupVO  查询条件
     * @author WangMingShuai
     * @date 2020/1/18 14:37
     * @return java.util.List<cn.com.hatechframework.server.role.po.RoleGroupPO>
     */
    List<RoleGroupPO> findAll(@Param("params") RoleGroupVO roleGroupVO);
}
