package cn.com.hatechframework.server.user.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.user.dto.UserPageDTO;
import cn.com.hatechframework.server.user.po.UserPO;
import cn.com.hatechframework.server.user.vo.UserRoleVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.mapper
 * @className IUserMapper
 * @description 用户信息数据访问层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         用户信息数据访问层
 */
@Mapper
public interface IUserMapper extends IBaseMapper<UserPO> {

    /**
     * 根据账号查询用户信息
     * @param username  账号
     * @author WangMingShuai
     * @date 2020/1/7 10:59
     * @return cn.com.hatechframework.entity.oauth.rbac.vo.UserVO
     */
    UserVO findUserByUsername(String username);

    /**
     * 用户分页查询
     * @param page
     * @param userPageDTO  分页参数
     * @author WangMingShuai
     * @date 2020/1/7 11:00
     * @return java.util.List<cn.com.hatechframework.entity.oauth.rbac.vo.UserVO>
     */
    List<UserRoleVO> findAll(Page<UserRoleVO> page, @Param("params") UserPageDTO userPageDTO);


    /**
     * 查询用户角色
     * @param userIds 用户id
     * @author YeMeng
     * @date 2020/1/18 15:15
     * @return java.util.List<cn.com.hatechframework.server.user.vo.UserRoleVO>
     */
    List<UserRoleVO> findUserRole(@Param("list") List<String> userIds);

    /**
     * 查询用户角色组
     * @param userIds 用户id
     * @author YeMeng
     * @date 2020/1/18 15:18
     * @return java.util.List<cn.com.hatechframework.server.user.vo.UserRoleVO>
     */
    List<UserRoleVO> findUserRoleGroup(@Param("list") List<String> userIds);


    /**
     * 启用/停用 用户
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/20 13:44
     * @return int
     */
    int enableUser(@Param("userId") String userId);

    /**
     * 重置用户密码
     * @param password  加密密码
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/20 13:44
     * @return int
     */
    int resetPassword(@Param("password") String password, @Param("userId") String userId);


    /**
     * 查询用户密码
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/20 16:24
     * @return java.lang.String
     */
    String findUserPassword(@Param("userId") String userId);

    /**
     * 更改用户密码
     * @param password  密码
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/20 16:25
     * @return int
     */
    int changePassword(@Param("password") String password, @Param("userId") String userId);
}
