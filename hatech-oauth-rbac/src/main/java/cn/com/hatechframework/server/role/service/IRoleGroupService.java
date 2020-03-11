package cn.com.hatechframework.server.role.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.server.role.dto.RoleGroupPageDTO;
import cn.com.hatechframework.server.role.po.RoleGroupPO;
import cn.com.hatechframework.server.role.vo.RoleGroupVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.service
 * @className IRoleGroupService
 * @description 角色组业务接口层
 * @author WangMingShuai
 * @create 2019/12/27 15:05
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 15:05             1.0                         角色组业务接口层
 */
public interface IRoleGroupService extends IBaseService<RoleGroupPO> {

    /**
     * 角色组分页
     * @param roleGroupPageDTO  分页参数
     * @author WangMingShuai
     * @date 2019/12/27 15:19
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.role.vo.RoleGroupVO>
     */
    Page<RoleGroupVO> findPage(RoleGroupPageDTO roleGroupPageDTO);

    /**
     * 添加角色组
     * @param roleGroup  角色组信息
     * @author WangMingShuai
     * @date 2019/12/27 15:59
     * @return java.lang.Integer
     */
    int updateRoleGroup(RoleGroupPO roleGroup);

    /**
     * 修改角色组
     * @param roleGroup  角色组信息
     * @author WangMingShuai
     * @date 2019/12/27 15:59
     * @return java.lang.Integer
     */
    int insertRoleGroup(RoleGroupPO roleGroup);

    /**
     * 查询所有的角色组信息
     * @author WangMingShuai
     * @date 2020/1/18 14:35
     * @return java.util.List<cn.com.hatechframework.server.role.po.RoleGroupPO>
     */
    List<RoleGroupPO> findAll();

    /**
     * 根据角色组ids删除角色组
     * @param ids  角色组Ids
     * @author WangMingShuai
     * @date 2020/1/18 14:45
     * @return void
     */
    boolean deleteRoleGroupByIds(String ids);
}
