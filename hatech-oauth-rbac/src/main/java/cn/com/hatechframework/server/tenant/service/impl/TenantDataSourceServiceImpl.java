package cn.com.hatechframework.server.tenant.service.impl;

import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.server.tenant.mapper.ITenantDatasourceMapper;
import cn.com.hatechframework.server.tenant.po.TenantDataSourcePO;
import cn.com.hatechframework.server.tenant.service.ITenantDataSourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.tenant.service.impl
 * @className TenantDataSourceImpl
 * @description 租户数据源service实现类
 * @author YeMeng
 * @create 2019/12/27 13:27
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/27 13:27             1.0                         租户数据源service实现类
 */
@Service
public class TenantDataSourceServiceImpl extends AbstractService<TenantDataSourcePO> implements ITenantDataSourceService {

    private static final String HIKARI_DATA_SOURCE = "com.zaxxer.hikari.HikariDataSource";
    private static final String HIKARI_DATA_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * 注入租户数据源mapper
     */
    @Resource
    private ITenantDatasourceMapper tenantDatasourceMapper;

    /**
     * 创建租户数据源
     * @param databaseName  租户id
     * @param dbUrl 数据库url
     * @param dataSourceUsername  数据源用户名
     * @param dataSourcePassword  数据源密码
     * @author YeMeng
     * @date 2019/12/28 15:39
     * @return int
     */
    @Override
    public int createTenantDatasource(String databaseName, String dbUrl, String dataSourceUsername, String dataSourcePassword) {
        TenantDataSourcePO tenantDatasource = TenantDataSourcePO.builder()
                .tenantName(databaseName)
                .dataSourceType(HIKARI_DATA_SOURCE)
                .dataSourceDriver(HIKARI_DATA_DRIVER)
                // 配置数据库 IP, 端口, 数据库名称
                .dataSourceUrl(dbUrl)
                // 配置数据库用户名
                .dataSourceUsername(dataSourceUsername)
                // 配置数据库密码
                .dataSourcePassword(dataSourcePassword)
                .build();
        return tenantDatasourceMapper.insert(tenantDatasource);
    }

    /**
     * 查询所有可用的租户数据源
     * @author WangMingShuai
     * @date 2020/1/7 11:02
     * @return java.util.List<cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO>
     */
    @Override
    public List<TenantDataSourceVO> findAllUsedDataSource() {
        return this.tenantDatasourceMapper.findAllUsableDataSource();
    }

    /**
     * 根据数据源名称查询数据源信息
     * @param   tenantName 数据源名称
     * @author WangMingShuai
     * @date 2020/1/7 11:02
     * @return cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO
     */
    @Override
    public TenantDataSourceVO findOneUsedDataSource(String tenantName) {
        return this.tenantDatasourceMapper.findOneUsableDataSource(tenantName);
    }


}
