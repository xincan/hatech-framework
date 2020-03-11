package cn.com.hatechframework.server.user.mapper;

import cn.com.hatechframework.server.user.po.UserRolePO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.mapper
 * @className IUserRoleMapper
 * @description 用户-角色mapper
 * @author YeMeng
 * @create 2020/1/17 17:49
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2020/1/17 17:49             1.0                         用户-角色mapper
 */
@Mapper
public interface IUserRoleMapper extends BaseMapper<UserRolePO> {
}
