package cn.com.hatechframework.server.role.service;

import cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO;
import cn.com.hatechframework.server.role.dto.RolePageDTO;
import cn.com.hatechframework.server.role.po.RolePO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.service
 * @className IRoleService
 * @description 角色信息接口层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         角色信息接口层
 */
public interface IRoleService extends IService<RolePO> {

    /**
     * 角色分页查询
     * @param rolePageDTO  分页查询参数
     * @author WangMingShuai
     * @date 2019/12/24 19:50
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.role.vo.RoleVo>
     */
    Page<RoleVO> findPage(RolePageDTO rolePageDTO);

    /**
     * 查询启用的角色个数
     * @param ids 角色ids
     * @author YeMeng
     * @date 2020/2/21 20:34
     * @return int
     */
    int findRoleEnabledCount(String ids);

    /**
     * 新增角色
     * @param role  角色信息
     * @author WangMingShuai
     * @date 2019/12/27 14:36
     * @return java.lang.Integer
     */
    int insertRole(RolePO role);

    /**
     * 修改角色
     * @param role  角色信息
     * @author WangMingShuai
     * @date 2019/12/27 14:36
     * @return java.lang.Integer
     */
    int updateRole(RolePO role);

    /**
     * 根据角色ids删除角色
     * @param ids  角色ids
     * @author WangMingShuai
     * @date 2020/1/20 9:04
     * @return void
     */
    boolean deleteRoleByIds(String ids);

    /**
     * 根据角色id启用停用角色
     * @param id  角色id
     * @author WangMingShuai
     * @date 2020/2/6 14:17
     * @return int
     */
    int updateStatusById(String id);
}
