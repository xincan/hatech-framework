package cn.com.hatechframework.server.mapper.user;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.po.TenantPO;
import cn.com.hatechframework.server.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Copyright (C), 2018,北京同创永益科技发展有限公司
 * @package cn.com.hatechframework.oauth.server.mapper
 * @className IUserMapper
 * @author Xincan
 * @description 用户mapper接口
 * @date 2019/4/16 16:59
 * @version 1.0
 */
@Mapper
public interface IUserMapper extends IBaseMapper<UserPO> {

    /**
     *  按用户查询所属租户信息
     * @param username  用户名称
     * @author YeMeng
     * @date 2019/12/24 19:28
     * @return java.util.List<cn.com.hatechframework.po.TenantPO>
     */
    List<TenantPO> findTenantByUsername(@Param("username") String username);

}
