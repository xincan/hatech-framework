package cn.com.hatechframework.server.tenant.service.impl;

import cn.com.hatechframework.config.exception.BusinessException;
import cn.com.hatechframework.config.shardingjdbc.ShardingCreateDataSource;
import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.entity.oauth.rbac.dto.UserRegisterDTO;
import cn.com.hatechframework.entity.oauth.rbac.dto.UserTenantRegisterDTO;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.entity.oauth.server.vo.UserTenantVO;
import cn.com.hatechframework.server.menu.mapper.IMenuMapper;
import cn.com.hatechframework.server.menu.mapper.IMenuOperationMapper;
import cn.com.hatechframework.server.menu.po.MenuOperationPO;
import cn.com.hatechframework.server.menu.po.MenuPO;
import cn.com.hatechframework.server.operation.mapper.IOperationMapper;
import cn.com.hatechframework.server.operation.po.OperationPO;
import cn.com.hatechframework.server.organization.po.OrganizationPO;
import cn.com.hatechframework.server.organization.service.IOrganizationService;
import cn.com.hatechframework.server.role.mapper.IRoleMapper;
import cn.com.hatechframework.server.role.po.RoleMenuOperationPO;
import cn.com.hatechframework.server.role.po.RolePO;
import cn.com.hatechframework.server.role.service.IRoleMenuOperationService;
import cn.com.hatechframework.server.role.service.IRoleService;
import cn.com.hatechframework.server.tenant.mapper.ITenantMapper;
import cn.com.hatechframework.server.tenant.mapper.IUserTenantMapper;
import cn.com.hatechframework.server.tenant.po.TenantPO;
import cn.com.hatechframework.server.tenant.po.UserTenantPO;
import cn.com.hatechframework.server.tenant.service.ITenantDataSourceService;
import cn.com.hatechframework.server.tenant.service.IUserTenantService;
import cn.com.hatechframework.server.user.mapper.IUserMapper;
import cn.com.hatechframework.server.user.po.UserPO;
import cn.com.hatechframework.server.user.po.UserRolePO;
import cn.com.hatechframework.server.user.service.IUserRoleService;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.statics.DataKeyPrefix;
import com.google.common.collect.Lists;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.shardingsphere.api.hint.HintManager;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @author YeMeng
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/28 14:16             1.0                         用户租户对应service实现
 * @program hatech-framework
 * @package cn.com.hatechframework.server.tenant.service.impl
 * @className UserTenantServiceImpl
 * @description 用户租户对应service实现
 * @create 2019/12/28 14:16
 */
@Slf4j
@Service("userTenantService")
public class UserTenantServiceImpl extends AbstractService<UserTenantPO> implements IUserTenantService {

    /**
     * 数据源字符串分隔符
     */
    private static final String URL_SPLIT = "/";

    /**
     * 主数据源连接地址
     */
    @Value("${spring.datasource.hikari.jdbc-url}")
    private String dataSourceUrl;

    /**
     * 主数据源用户名
     */
    @Value("${spring.datasource.hikari.username}")
    private String dataSourceUsername;

    /**
     * 主数据源密码
     */
    @Value("${spring.datasource.hikari.password}")
    private String dataSourcePassword;

    /**
     * 租户mapper
     */
    @Resource
    private ITenantMapper tenantMapper;

    /**
     * 租户用户对应关系mapper
     */
    @Resource
    private IUserTenantMapper userTenantMapper;

    /**
     * 用户mapper
     */
    @Resource
    private IUserMapper userMapper;

    /**
     * 角色mapper
     */
    @Resource
    private IRoleMapper roleMapper;

    /**
     * 菜单mapper
     */
    @Resource
    private IMenuMapper menuMapper;

    /**
     * 权限mapper
     */
    @Resource
    private IMenuOperationMapper menuOperationMapper;

    /**
     * 操作mapper
     */
    @Resource
    private IOperationMapper operationMapper;

    /**
     * 机构信息业务接口
     */
    private final IOrganizationService organizationService;

    /**
     * 角色菜单操作业务接口
     */
    private IRoleMenuOperationService roleMenuOperationService;

    /**
     * 角色信息接口
     */
    private final IRoleService roleService;

    /**
     * 用户角色业务接口
     */
    private final IUserRoleService userRoleService;

    /**
     * 密码加密解密工具类
     */
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 注入sharding datasource
     */
    private DataSource dataSource;

    /**
     * 注入hikari datasource
     */
    private HikariDataSource hikariDataSource;

    /**
     * 注入租户数据源service
     */
    private ITenantDataSourceService tenantDataSourceService;

    /**
     * 动态创建数据源
     */
    private ShardingCreateDataSource shardingCreateDataSource;

    public UserTenantServiceImpl(BCryptPasswordEncoder passwordEncoder, DataSource dataSource, HikariDataSource hikariDataSource,
                                 ShardingCreateDataSource shardingCreateDataSource, ITenantDataSourceService tenantDataSourceService,
                                 IUserRoleService userRoleService, IOrganizationService organizationService, IRoleService roleService, IRoleMenuOperationService roleMenuOperationService) {
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
        this.hikariDataSource = hikariDataSource;
        this.shardingCreateDataSource = shardingCreateDataSource;
        this.tenantDataSourceService = tenantDataSourceService;
        this.userRoleService = userRoleService;
        this.organizationService = organizationService;
        this.roleService = roleService;
        this.roleMenuOperationService = roleMenuOperationService;
    }

    /**
     * 租户注册
     *
     * @param userTenantRegisterDTO 租户注册参数
     * @return cn.com.hatechframework.utils.response.ResponseObject
     * @author WangMingShuai
     * @date 2020/1/7 11:07
     */
    @Override
    @GlobalTransactional
    public boolean registerUser(UserTenantRegisterDTO userTenantRegisterDTO) {
        UserPO user = OrikaUtils.map(userTenantRegisterDTO, UserPO.class);
        log.info("{}", "查询租户是否已经注册过");
        UserTenantVO userTenantVO = checkAndSaveTenant(userTenantRegisterDTO);

        // TODO :租户注册后初始化的数据待商榷，根据实际的需求而定
        List<String> roleNames = Lists.newArrayList();
        roleNames.add("TENANT_INIT");

        List<RolePO> roleList = this.roleMapper.findRoleByNames(roleNames);
        List<String> roleIdList = roleList.stream().map(RolePO::getId).collect(Collectors.toList());
        List<MenuPO> menuList = this.menuMapper.findMenuByRoles(roleIdList);
        List<OperationPO> operationList = this.operationMapper.findOperationByRoles(roleIdList);
        List<MenuOperationPO> menuOperationList = this.menuOperationMapper.findMenuOperationByRoles(roleIdList);
        List<RoleMenuOperationPO> roleMenuOperationList = this.roleMapper.findRoleMenuOperationByRoles(roleIdList);

        String databaseName = DataKeyPrefix.TENANT_DATASOURCE_PREFIX + userTenantVO.getTenantId();
        log.info("{}", "创建租户数据库");
        createDatabase(databaseName);
        log.info("{}", "创建租户数据源");
        TenantDataSourceVO tenantDataSourceVO = tenantDataSourceService.findOneUsedDataSource(databaseName);
        shardingCreateDataSource.checkAndDynamicCreateShardingDataSource(tenantDataSourceVO.getTenantName());
        log.info("{}", "切换至新创建的租户数据源");
        HintManager.getInstance().setDatabaseShardingValue(databaseName);

        DataSourceProxy dataSourceProxy = (DataSourceProxy) ((ShardingDataSource) dataSource).getDataSourceMap().get(databaseName);
        try (
                Connection connection = dataSourceProxy.getPlainConnection();
                Statement statement = connection.createStatement();
        ) {
            log.info("{}", "执行sql脚本,创建基础表");
            InputStream sqlInit = new ClassPathResource("db/init-tables.sql").getInputStream();
            String sqlText = IOUtils.toString(sqlInit, StandardCharsets.UTF_8.name());
            statement.executeUpdate(sqlText);
            user.setIsTenant(true);
            //启用
            user.setStatus(1);
            //不是管理员
            user.setIsAdmin(true);
            //设置密码
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            log.info("在租户数据库用户表中添加该租户信息：{}", user);

            OrganizationPO organization = this.organizationService.insertPlatformOrganization(user.getId());
            user.setOrganizationId(organization.getId());
            this.userMapper.insert(user);
            this.roleService.saveBatch(roleList);
            List<UserRolePO> userRoles = roleIdList
                    .stream()
                    .map(t -> UserRolePO.builder().userId(user.getId()).roleId(t).build())
                    .collect(Collectors.toList());
            userRoleService.saveBatch(userRoles);
            this.menuMapper.batchInsert(menuList);
            this.operationMapper.batchInsert(operationList);
            this.menuOperationMapper.batchInsert(menuOperationList);
            //角色菜单操作关系
            this.roleMenuOperationService.saveBatch(roleMenuOperationList);
            return true;
        } catch (Exception e) {
            // 错误时删除该租户库
            log.error("注册租户失败：", e);
            throw new BusinessException(ResponseCode.EXCEPTION);
        } finally {
            HintManager.clear();
        }
    }

    /**
     * 检查和添加用户信息
     *
     * @param userRegisterDTO 用户注册信息参数
     * @return cn.com.hatechframework.utils.response.ResponseObject
     * @author WangMingShuai
     * @date 2020/1/7 11:07
     */
    @Override
    @GlobalTransactional
    public int checkAndSaveUser(UserRegisterDTO userRegisterDTO) {
        UserTenantPO hasUserTenant = userTenantMapper.findByUsername(userRegisterDTO.getUsername());
        if (!ObjectUtils.isEmpty(hasUserTenant)) {
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(), "该邮箱在平台已存在");
        }
        String tenantId = userRegisterDTO.getTenantId().replace(DataKeyPrefix.TENANT_DATASOURCE_PREFIX, "");
        TenantPO tenant = tenantMapper.selectById(tenantId);
        if (ObjectUtils.isEmpty(tenant)) {
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(), "无效的租户");
        }
        log.info("{}", "添加用户租户关系信息");
        UserTenantPO userTenant = UserTenantPO
                .builder()
                .username(userRegisterDTO.getUsername())
                .phone(userRegisterDTO.getPhone())
                .tenantId(tenantId)
                .build();
        return userTenantMapper.insert(userTenant);
    }

    /**
     * 检查和添加租户信息（租户表，租户用户表，租户数据源表）
     *
     * @param userTenantRegisterDTO 租户信息
     * @return cn.com.hatechframework.utils.response.ResponseObject
     * @author YeMeng
     * @date 2019/12/28 15:28
     */
    private UserTenantVO checkAndSaveTenant(UserTenantRegisterDTO userTenantRegisterDTO) {
        UserTenantPO hasUserTenant = userTenantMapper.findByUsername(userTenantRegisterDTO.getUsername());
        if (!ObjectUtils.isEmpty(hasUserTenant)) {
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(), "该邮箱在平台已存在");
        }
        log.info("{}", "添加租户信息");
        TenantPO tenant = TenantPO
                .builder()
                .tenantName(userTenantRegisterDTO.getUsername())
                .build();
        tenantMapper.insert(tenant);

        log.info("{}", "添加用户租户关系信息");
        UserTenantPO userTenant = UserTenantPO
                .builder()
                .username(userTenantRegisterDTO.getUsername())
                .phone(userTenantRegisterDTO.getPhone())
                .tenantId(tenant.getId())
                .build();
        userTenantMapper.insert(userTenant);

        log.info("{}", "添加租户数据源信息");
        String databaseName = DataKeyPrefix.TENANT_DATASOURCE_PREFIX + tenant.getId();
        String[] urlPart = dataSourceUrl.split("\\?");
        String dbUrl =
                // 地址, 端口
                urlPart[0].substring(0, urlPart[0].lastIndexOf(URL_SPLIT) + 1)
                        // 数据库名称
                        + databaseName
                        // 数据库配置
                        + "?" + urlPart[1];
        tenantDataSourceService.createTenantDatasource(databaseName, dbUrl, dataSourceUsername, dataSourcePassword);
        return OrikaUtils.map(userTenant, UserTenantVO.class);
    }

    /**
     * 创建租户数据库, sharding jdbc不支持建表语句，需要使用datasource创建
     *
     * @param databaseName 租户数据库的名称
     * @return void
     * @author WangMingShuai
     * @date 2019/12/28 15:46
     */
    private void createDatabase(String databaseName) {
        try (Connection connection = hikariDataSource.getConnection();
             Statement statement = connection.createStatement()) {
            String dbSql = "CREATE DATABASE IF NOT EXISTS " + databaseName + " DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;";
            statement.executeUpdate(dbSql);
        } catch (Exception e) {
            log.error("创建或删除数据库错误：{}", databaseName, e);
            throw new BusinessException(ResponseCode.EXCEPTION);
        }
    }

}
