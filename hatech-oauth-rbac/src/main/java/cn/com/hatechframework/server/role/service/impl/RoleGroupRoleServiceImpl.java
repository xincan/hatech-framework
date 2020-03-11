package cn.com.hatechframework.server.role.service.impl;

import cn.com.hatechframework.server.role.mapper.IRoleGroupRoleMapper;
import cn.com.hatechframework.server.role.po.RoleGroupRolePO;
import cn.com.hatechframework.server.role.service.IRoleGroupRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author WangMingShuai
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/2/13 20:38             1.0                         角色组角色业务实现层
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.service.impl
 * @className RoleGroupRoleServiceImpl
 * @description 角色组角色业务实现层
 * @create 2020/2/13 20:38
 */
@Service("roleGroupRoleService")
public class RoleGroupRoleServiceImpl extends ServiceImpl<IRoleGroupRoleMapper, RoleGroupRolePO> implements IRoleGroupRoleService {
}
