package cn.com.hatechframework.server.role.service.impl;

import cn.com.hatechframework.server.role.mapper.IRoleMenuOperationMapper;
import cn.com.hatechframework.server.role.po.RoleMenuOperationPO;
import cn.com.hatechframework.server.role.service.IRoleMenuOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author WangMingShuai
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/2/13 21:04             1.0                         角色菜单操作业务实现层
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.service.impl
 * @className RoleMenuOperationServiceImpl
 * @description 角色菜单操作业务实现层
 * @create 2020/2/13 21:04
 */
@Service("roleMenuOperationService")
public class RoleMenuOperationServiceImpl extends ServiceImpl<IRoleMenuOperationMapper,RoleMenuOperationPO> implements IRoleMenuOperationService {
}
