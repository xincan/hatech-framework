package cn.com.hatechframework.server.tenant.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.tenant.po.UserTenantPO;
import org.apache.ibatis.annotations.Mapper;


/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.tenant.mapper
 * @className IUserTenantMapper
 * @description 用户租户对应mapper
 * @author YeMeng
 * @create 2019/12/28 14:15
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/28 14:15             1.0                         用户租户对应mapper
 */
@Mapper
public interface IUserTenantMapper extends IBaseMapper<UserTenantPO> {

    /**
     * 根据账号获取用户和租户的关系
     * @param username  账号
     * @author WangMingShuai
     * @date 2020/1/7 11:04
     * @return cn.com.hatechframework.server.tenant.po.UserTenantPO
     */
    UserTenantPO findByUsername(String username);
}
