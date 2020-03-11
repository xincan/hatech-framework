package cn.com.hatechframework.server.service.impl;

import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.server.mapper.tenant.ITenantDatasourceMapper;
import cn.com.hatechframework.server.po.TenantDataSourcePO;
import cn.com.hatechframework.server.service.ITenantDataSourceService;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.statics.DataSourceEnableType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.service.impl
 * @className TenantDataSourceImpl
 * @description 租户数据源service实现类
 * @author YeMeng
 * @create 2019/12/27 13:27
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/27 13:27             1.0                         租户数据源service实现类
 */
@Slf4j
@Service
public class TenantDataSourceServiceImpl extends AbstractService<TenantDataSourcePO> implements ITenantDataSourceService {
    /**
     * 数据源类型
     */
    private static final String HIKARI_DATASOURCE = "com.zaxxer.hikari.HikariDataSource";

    /**
     * 数据源驱动
     */
    private static final String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * 注入租户数据源mapper
     */
    @Resource
    private ITenantDatasourceMapper tenantDatasourceMapper;


    /**
     *  查询所有数据源
     * @author YeMeng
     * @date 2019/12/27 13:32
     * @return java.util.List<cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO>
     */
    @Override
    public List<TenantDataSourceVO> findAll() {
        QueryWrapper<TenantDataSourcePO> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(TenantDataSourcePO::getEnabled, DataSourceEnableType.ENABLED.getValue());
        List<TenantDataSourcePO> list = tenantDatasourceMapper.selectList(queryWrapper);
        return OrikaUtils.mapAsList(list, TenantDataSourceVO.class);
    }

    /**
     *  创建租户数据源
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
                .dataSourceType(HIKARI_DATASOURCE)
                .dataSourceDriver(DATASOURCE_DRIVER)
                // 配置数据库 IP, 端口, 数据库名称
                .dataSourceUrl(dbUrl)
                // 配置数据库用户名
                .dataSourceUsername(dataSourceUsername)
                // 配置数据库密码
                .dataSourcePassword(dataSourcePassword)
                // 设置在用状态
                .enabled(DataSourceEnableType.ENABLED.getValue())
                .build();
        return tenantDatasourceMapper.insert(tenantDatasource);
    }

}
