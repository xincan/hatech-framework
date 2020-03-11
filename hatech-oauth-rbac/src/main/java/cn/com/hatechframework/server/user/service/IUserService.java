package cn.com.hatechframework.server.user.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.user.dto.PasswordUpdateDTO;
import cn.com.hatechframework.server.user.dto.UserInsertDTO;
import cn.com.hatechframework.server.user.dto.UserPageDTO;
import cn.com.hatechframework.server.user.po.UserPO;
import cn.com.hatechframework.server.user.vo.UserRoleVO;
import cn.com.hatechframework.utils.response.ResponseObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.service
 * @className IUserService
 * @description 用户信息接口层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         用户信息接口层
 */
public interface IUserService extends IBaseService<UserPO> {

    /**
     * 查询租户的个数
     * @param ids 用户ids
     * @author YeMeng
     * @date 2020/2/19 18:40
     * @return int
     */
    int findTenant(String ids);

    /**
     * 查询启用的用户个数
     * @param ids  用户ids
     * @author YeMeng
     * @date 2020/2/19 17:55
     * @return int
     */
    int findEnabledUser(String ids);

    /**
     * 删除用户
     * @param ids 用户ids
     * @author YeMeng
     * @date 2020/2/19 19:49
     * @return boolean
     */
    boolean deleteUser(String ids);

    /**
     * 根据账号和租户数据源名称查询用户信息
     * @param username  账号
     * @param tenantName  租户数据源名称
     * @author WangMingShuai
     * @date 2019/12/24 19:52
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    UserVO findUserByUsername(String username, String tenantName);

    /**
     * 用户分页查询
     * @param userPageDTO  分页查询参数
     * @author WangMingShuai
     * @date 2019/12/24 19:53
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.entity.oauth.rbac.vo.UserVO>
     */
    Page<UserRoleVO> findPage(UserPageDTO userPageDTO);

    /**
     * 添加用户
     * @param userInsertDTO  用户信息
     * @author WangMingShuai
     * @date 2019/12/24 19:54
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    UserPO insertUser(UserInsertDTO userInsertDTO);

    /**
     * 修改用户
     * @param user  用户信息
     * @author WangMingShuai
     * @date 2019/12/24 19:54
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    boolean updateUser(UserPO user);

    /**
     * 启用/停用 用户
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/20 13:44
     * @return int
     */
    int enableUser(String userId);

    /**
     * 重置用户密码
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/20 13:44
     * @return int
     */
    int resetPassword(String userId);

    /**
     * 验证密码
     * @param password  密码
     * @author YeMeng
     * @date 2020/2/4 14:05
     * @return boolean
     */
    boolean validPassword(String password);

    /**
     * 更新密码
     * @param passwordUpdateDTO  更新密码参数
     * @author YeMeng
     * @date 2020/2/4 14:05
     * @return int
     */
    int changePassword(PasswordUpdateDTO passwordUpdateDTO);
}
