package cn.com.hatechframework.server.tenant.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.entity.oauth.rbac.dto.UserRegisterDTO;
import cn.com.hatechframework.entity.oauth.rbac.dto.UserTenantRegisterDTO;
import cn.com.hatechframework.server.tenant.po.UserTenantPO;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.tenant.service
 * @className IUserTennatService
 * @description 用户租户对应表
 * @author YeMeng
 * @create 2019/12/28 14:14
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/28 14:14             1.0                         用户租户对应表
 */
public interface IUserTenantService extends IBaseService<UserTenantPO> {

    /**
     * 检查和添加用户信息
     * @param userRegisterDTO  用户注册信息参数
     * @author WangMingShuai
     * @date 2020/1/7 11:07
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    int checkAndSaveUser(UserRegisterDTO userRegisterDTO);

    /**
     * 租户注册
     * @param userTenantRegisterDTO  租户注册参数
     * @author WangMingShuai
     * @date 2020/1/7 11:07
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    boolean registerUser(UserTenantRegisterDTO userTenantRegisterDTO);
}
