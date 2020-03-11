package cn.com.hatechframework.server.role.service.impl;

import cn.com.hatechframework.server.role.mapper.IRoleGroupUserMapper;
import cn.com.hatechframework.server.role.po.RoleGroupUserPO;
import cn.com.hatechframework.server.role.service.IRoleGroupUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author WangMingShuai
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/2/13 20:33             1.0                         角色组用户业务实现层
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.service.impl
 * @className RoleGroupUserServiceImpl
 * @description 角色组用户业务实现层
 * @create 2020/2/13 20:33
 */
@Service("roleGroupUserService")
public class RoleGroupUserServiceImpl extends ServiceImpl<IRoleGroupUserMapper, RoleGroupUserPO> implements IRoleGroupUserService {
}
