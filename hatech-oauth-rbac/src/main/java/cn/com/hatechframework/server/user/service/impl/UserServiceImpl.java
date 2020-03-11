package cn.com.hatechframework.server.user.service.impl;

import cn.com.hatechframework.config.shardingjdbc.ShardingCreateDataSource;
import cn.com.hatechframework.data.page.Pagination;
import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.entity.oauth.rbac.dto.UserRegisterDTO;
import cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO;
import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.role.po.RoleGroupUserPO;
import cn.com.hatechframework.server.role.service.IRoleGroupUserService;
import cn.com.hatechframework.server.role.vo.RoleGroupVO;
import cn.com.hatechframework.server.tenant.mapper.IUserTenantMapper;
import cn.com.hatechframework.server.tenant.po.UserTenantPO;
import cn.com.hatechframework.server.tenant.service.IUserTenantService;
import cn.com.hatechframework.server.user.dto.PasswordUpdateDTO;
import cn.com.hatechframework.server.user.dto.UserInsertDTO;
import cn.com.hatechframework.server.user.dto.UserPageDTO;
import cn.com.hatechframework.server.user.mapper.IUserMapper;
import cn.com.hatechframework.server.user.po.UserPO;
import cn.com.hatechframework.server.user.po.UserRolePO;
import cn.com.hatechframework.server.user.service.IUserRoleService;
import cn.com.hatechframework.server.user.service.IUserService;
import cn.com.hatechframework.server.user.vo.UserRoleVO;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.context.BaseContextHandler;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.service.impl
 * @className UserServiceImpl
 * @description 用户信息接口层实现
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         用户信息接口层实现
 */
@Service("userService")
@Slf4j
public class UserServiceImpl extends AbstractService<UserPO> implements IUserService {

    /**
     * 新建用户时默认的用户登录密码
     */
    private static final String DEFAULT_USER_SECRET_CODE = "123456";

    /**
     * 逗号分隔符
     */
    private static final String SPLIT_COMMA = ",";

    /**
     * 用户启用
     */
    private static final int USER_ENABLED = 1;

    /**
     * 用户为租户
     */
    private static final int IS_TENANT = 1;

    /**
     * 主数据源名称
     */
    @Value("${spring.datasource.name}")
    private String dataSourceName;

    /**
     * 鉴权中心配置信息
     */
    @Value("${security.oauth2.server.clientId}")
    private String oauthServerClientId;

    @Value("${security.oauth2.server.clientSecret}")
    private String oauthServerClientSecret;

    @Value("${security.oauth2.server.grant-type}")
    private String oauthServerGrantType;

    @Value("${security.oauth2.server.scope}")
    private String oauthServerScope;

    @Resource
    private IUserMapper userMapper;

    /**
     * 租户用户对应关系mapper
     */
    @Resource
    private IUserTenantMapper userTenantMapper;

    /**
     * 密码加密解密工具类
     */
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 租户服务接口
     */
    private IUserTenantService userTenantService;

    /**
     * 创建数据源
     */
    private final ShardingCreateDataSource shardingCreateDataSource;

    /**
     * 用户-角色service
     */
    private final IUserRoleService userRoleService;

    /**
     * 用户-角色组service
     */
    private final IRoleGroupUserService roleGroupUserService;

    @Autowired
    public UserServiceImpl(IUserTenantService userTenantService,
                           BCryptPasswordEncoder passwordEncoder,ShardingCreateDataSource shardingCreateDataSource,
                           IUserRoleService userRoleService, IRoleGroupUserService roleGroupUserService) {
         this.userTenantService = userTenantService;
         this.passwordEncoder = passwordEncoder;
         this.shardingCreateDataSource = shardingCreateDataSource;
         this.userRoleService = userRoleService;
         this.roleGroupUserService = roleGroupUserService;
    }


    /**
     * 查询用户数量
     * @param queryWrapper 查询条件
     * @author YeMeng
     * @date 2020/2/19 20:06
     * @return int
     */
    private int findUserCount(QueryWrapper<UserPO> queryWrapper) {
        try {
            HintManager.getInstance().setDatabaseShardingValue(BaseContextHandler.getTenantName());
            return userMapper.selectCount(queryWrapper);
        } finally {
            HintManager.clear();
        }
    }

    /**
     * 查询租户的个数
     * @param ids 用户ids
     * @author YeMeng
     * @date 2020/2/19 18:40
     * @return int
     */
    @Override
    public int findTenant(String ids) {
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserPO::getIsTenant, IS_TENANT)
                .in(UserPO::getId, Arrays.asList(ids.split(SPLIT_COMMA)));
        return findUserCount(queryWrapper);
    }

    /**
     * 查询启用的用户个数
     * @param ids  用户ids
     * @author YeMeng
     * @date 2020/2/19 17:55
     * @return int
     */
    @Override
    public int findEnabledUser(String ids) {
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserPO::getStatus, USER_ENABLED)
                .in(UserPO::getId, Arrays.asList(ids.split(SPLIT_COMMA)));
        return findUserCount(queryWrapper);
    }

    /**
     * 删除主库用户
     * @param usernameList  用户名列表
     * @author YeMeng
     * @date 2020/2/19 19:47
     * @return int
     */
    private int deleteMainDbUser(List<String> usernameList) {
        try {
            HintManager.getInstance().setDatabaseShardingValue(dataSourceName);
            QueryWrapper<UserTenantPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().in(UserTenantPO::getUsername, usernameList);
            return userTenantMapper.delete(queryWrapper);
        } finally {
            HintManager.clear();
        }
    }

    /**
     * 删除子库用户
     * @param ids 用户ids
     * @author YeMeng
     * @date 2020/2/19 19:46
     * @return int
     */
    private int deleteSubDbUser(String ids) {
        try {
            HintManager.getInstance().setDatabaseShardingValue(BaseContextHandler.getTenantName());
            return userMapper.deleteBatchIds(Arrays.asList(ids.split(SPLIT_COMMA)));
        } finally {
            HintManager.clear();
        }
    }

    /**
     * 删除用户
     * @param ids 用户ids
     * @author YeMeng
     * @date 2020/2/19 19:49
     * @return boolean
     */
    @GlobalTransactional
    @Override
    public boolean deleteUser(String ids) {
        List<UserPO> userList = userMapper.selectBatchIds(Arrays.asList(ids.split(SPLIT_COMMA)));
        List<String> usernameList = userList.stream().map(UserPO::getUsername).collect(Collectors.toList());
        return deleteMainDbUser(usernameList) > 0 && deleteSubDbUser(ids) > 0;
    }


    /**
     * 根据登陆账号查询用户信息
     * @param username  登陆账号
     * @param tenantName  租户数据源名称
     * @author WangMingShuai
     * @date 2019/12/24 19:52
     * @return cn.com.hatechframework.server.user.vo.UserVo
     */
    @Override
    public UserVO findUserByUsername(String username, String tenantName) {
        try {
            shardingCreateDataSource.checkAndDynamicCreateShardingDataSource(tenantName);
            HintManager.getInstance().setDatabaseShardingValue(tenantName);
            return this.userMapper.findUserByUsername(username);
        } finally {
            HintManager.clear();
        }
    }

    /**
     * 用户分页查询
     * @param userPageDTO  分页查询参数
     * @author WangMingShuai
     * @date 2019/12/24 19:53
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.user.vo.UserVo>
     */
    @Override
    public Page<UserRoleVO> findPage(UserPageDTO userPageDTO) {
        Page<UserRoleVO> page = Pagination.page(userPageDTO);
        List<UserRoleVO> list = userMapper.findAll(page,userPageDTO);
        if (Objects.isNull(list) || list.isEmpty()) {
            return page;
        }
        List<String> userIds = list.stream().map(UserRoleVO::getId).collect(Collectors.toList());
        log.info("查询用户角色");
        List<UserRoleVO> userRoleList = userMapper.findUserRole(userIds);
        Map<String, UserRoleVO> userRoleMap = userRoleList.stream()
                .collect(Collectors.toMap(UserRoleVO::getId, Function.identity()));
        log.info("查询用户角色组");
        List<UserRoleVO> userRoleGroupList = userMapper.findUserRoleGroup(userIds);
        Map<String, UserRoleVO> userRoleGroupMap = userRoleGroupList.stream()
                .collect(Collectors.toMap(UserRoleVO::getId, Function.identity()));

        list.forEach(t->{
            UserRoleVO role = userRoleMap.get(t.getId());
            if (!Objects.isNull(role)) {
                String roleName = role.getRoleList().stream()
                        .filter(s-> s!=null && !StringUtils.isEmpty(s.getRoleName()))
                        .map(RoleVO::getRoleName)
                        .collect(Collectors.joining(SPLIT_COMMA));
                t.setRoleList(role.getRoleList());
                t.setRoleName(roleName);
            }
            UserRoleVO roleGroup = userRoleGroupMap.get(t.getId());
            if (!Objects.isNull(roleGroup)) {
                String roleGroupName = roleGroup.getRoleGroupList().stream()
                        .filter(s-> s!=null && !StringUtils.isEmpty(s.getRoleGroupName()))
                        .map(RoleGroupVO::getRoleGroupName)
                        .collect(Collectors.joining(SPLIT_COMMA));
                t.setRoleGroupList(roleGroup.getRoleGroupList());
                t.setRoleGroupName(roleGroupName);
            }
        });
        page.setRecords(list);
        return page;
    }

    /**
     * 新增用户
     * @param userInsertDTO  新增用户信息参数
     * @author WangMingShuai
     * @date 2019/12/24 19:55
     * @return java.lang.Integer
     */
    @Override
    @GlobalTransactional
    public UserPO insertUser(UserInsertDTO userInsertDTO) {
        UserRegisterDTO userRegisterDTO = OrikaUtils.map(userInsertDTO,UserRegisterDTO.class);
        userRegisterDTO.setTenantId(BaseContextHandler.getTenantName());
        log.info("{}","查询用户是否注册过");
        userTenantService.checkAndSaveUser(userRegisterDTO);
        try {
            HintManager.getInstance().setDatabaseShardingValue(BaseContextHandler.getTenantName());
            UserPO user = OrikaUtils.map(userInsertDTO, UserPO.class);
            user.setIsTenant(false);
            //启用
            user.setStatus(1);
            //不是管理员
            user.setIsAdmin(false);
            //设置密码
            user.setPassword(passwordEncoder.encode(DEFAULT_USER_SECRET_CODE));
            user.setEditUserId(BaseContextHandler.getUserId());
            user.setEditTime(new Date());
            userMapper.insert(user);
            saveUserRole(user);
            return user;
        } finally {
            HintManager.clear();
        }

    }

    /**
     * 修改用户
     * @param user  用户信息
     * @author WangMingShuai
     * @date 2019/12/24 19:55
     * @return java.lang.Integer
     */
    @Override
    @GlobalTransactional
    public boolean updateUser(UserPO user) {
        user.setEditUserId(BaseContextHandler.getUserId());
        int num = userMapper.updateById(user);
        if (num == 0) {
            return false;
        }
        return saveUserRole(user);
    }

    /**
     * 启用/停用 用户
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/20 13:44
     * @return int
     */
    @Override
    public int enableUser(String userId) {
        return userMapper.enableUser(userId);
    }

    /**
     * 重置用户密码
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/20 13:44
     * @return int
     */
    @Override
    public int resetPassword(String userId) {
        String password = passwordEncoder.encode(DEFAULT_USER_SECRET_CODE);
        return userMapper.resetPassword(password, userId);
    }

    /**
     * 校验用户密码是否和数据库中一致
     * @param password  用户密码
     * @author YeMeng
     * @date 2020/1/20 16:28
     * @return boolean
     */
    @Override
    public boolean validPassword(String password) {
        String userId = BaseContextHandler.getUserId();
        String dbPassword = userMapper.findUserPassword(userId);
        return passwordEncoder.matches(password, dbPassword);
    }

    /**
     * 修改用户密码
     * @param passwordUpdateDTO 用户密码修改实体类
     * @author YeMeng
     * @date 2020/1/20 16:29
     * @return int
     */
    @Override
    public int changePassword(PasswordUpdateDTO passwordUpdateDTO) {
        String userId = BaseContextHandler.getUserId();
        return userMapper.changePassword(passwordEncoder.encode(passwordUpdateDTO.getNewPwd()), userId);
    }

    /**
     * 批量保存用户角色对应关系
     * @param user  用户详情
     * @author YeMeng
     * @date 2020/2/14 20:14
     * @return
     */
    private boolean saveUserRoleBatch(UserPO user) {
        UpdateWrapper<UserRolePO> updateUserRoleWrapper = new UpdateWrapper<>();
        updateUserRoleWrapper.lambda().eq(UserRolePO::getUserId, user.getId());
        userRoleService.remove(updateUserRoleWrapper);
        if (!CollectionUtils.isEmpty(user.getRoleIds())) {
            List<UserRolePO> userRoles = user.getRoleIds()
                    .stream()
                    .map(t->UserRolePO.builder().userId(user.getId()).roleId(t).build())
                    .collect(Collectors.toList());
            return userRoleService.saveBatch(userRoles);
        }
        return true;
    }

    /**
     * 批量保存用户角色组对应关系
     * @param user  用户详情
     * @author YeMeng
     * @date 2020/2/14 20:14
     * @return
     */
    private boolean saveUserRoleGroupBatch(UserPO user) {
        UpdateWrapper<RoleGroupUserPO> updateRoleGroupUserWrapper = new UpdateWrapper<>();
        updateRoleGroupUserWrapper.lambda().eq(RoleGroupUserPO::getUserId, user.getId());
        roleGroupUserService.remove(updateRoleGroupUserWrapper);
        if (!CollectionUtils.isEmpty(user.getRoleGroupIds())) {
            List<RoleGroupUserPO> userRoleGroups = user.getRoleGroupIds()
                    .stream()
                    .map(t->RoleGroupUserPO.builder().userId(user.getId()).roleGroupId(t).build())
                    .collect(Collectors.toList());
            return roleGroupUserService.saveBatch(userRoleGroups);
        }
        return true;
    }

    /**
     * 保存用户角色/角色组
     * 此处不需要使用事务注解,insertUser和updateUser在调用此方法前已经加上了事务注解
     * @param user  用户
     * @author YeMeng
     * @date 2020/1/17 18:39
     * @return void
     */
    private boolean saveUserRole(UserPO user) {
        return saveUserRoleBatch(user) && saveUserRoleGroupBatch(user);
    }

}
