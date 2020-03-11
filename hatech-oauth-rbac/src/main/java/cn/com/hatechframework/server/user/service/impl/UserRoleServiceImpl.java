package cn.com.hatechframework.server.user.service.impl;

import cn.com.hatechframework.server.user.mapper.IUserRoleMapper;
import cn.com.hatechframework.server.user.po.UserRolePO;
import cn.com.hatechframework.server.user.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.service.impl
 * @className UserRoleServiceImpl
 * @description 用户-角色 service 层
 * @author YeMeng
 * @create 2020/1/17 17:57
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2020/1/17 17:57             1.0                         用户-角色 service 层
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<IUserRoleMapper, UserRolePO> implements IUserRoleService {
}
