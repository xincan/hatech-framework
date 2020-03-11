package cn.com.hatechframework.config.shardingjdbc;

import cn.com.hatechframework.config.exception.BusinessException;
import cn.com.hatechframework.data.config.redis.RedisTemplateOperator;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.server.tenant.service.ITenantDataSourceService;
import cn.com.hatechframework.utils.response.ResponseCode;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.core.rule.ShardingRule;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Map;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.shardingjdbc
 * @className ShardingCreateDataSource
 * @description 动态创建sharding jdbc 数据源
 * @author WangMingShuai
 * @create 2020/1/4 12:58
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/4 12:58             1.0                         动态创建sharding jdbc 数据源
 */
@Component
@Slf4j
public class ShardingCreateDataSource {

    private final DataSource dataSource;
    private final RedisTemplateOperator redisTemplateOperator;
    private final ITenantDataSourceService tenantDataSourceService;
    private final HikariDataSource hikariDataSource;

    public ShardingCreateDataSource(DataSource dataSource, RedisTemplateOperator redisTemplateOperator,
                                    ITenantDataSourceService tenantDataSourceService,HikariDataSource hikariDataSource) {
        this.dataSource = dataSource;
        this.redisTemplateOperator = redisTemplateOperator;
        this.tenantDataSourceService = tenantDataSourceService;
        this.hikariDataSource = hikariDataSource;
    }

    /**
     * 根据租户数据源信息 动态创建创建Sharding数据源
     * @param tenantDataSourceVO  租户数据源信息
     * @author WangMingShuai
     * @date 2020/1/7 10:35
     * @return void
     */
    public void dynamicCreateShardingDataSource(TenantDataSourceVO tenantDataSourceVO) {
        ShardingDataSource shardingDataSource = (ShardingDataSource)dataSource;
        Map<String, DataSource> dataSourceMap = shardingDataSource.getDataSourceMap();
        ShardingRule shardingRule = shardingDataSource.getRuntimeContext().getRule();
        log.info("创建数据源：{}",tenantDataSourceVO);
        HikariDataSource ds = createHikariDataSource(tenantDataSourceVO);
        log.info("{}","将数据源托管给 sharding jdbc");
        dataSourceMap.put(tenantDataSourceVO.getTenantName(),new DataSourceProxy(ds));
        shardingRule.getShardingDataSourceNames().getDataSourceNames().add(tenantDataSourceVO.getTenantName());
        log.info("将数据源信息存储到redis key:{} value:{}",tenantDataSourceVO.getTenantName(),tenantDataSourceVO);
        this.redisTemplateOperator.set(tenantDataSourceVO.getTenantName(),tenantDataSourceVO);
    }

    /**
     * 检查和动态创建数据源
     * @param tenantName  数据源名称
     * @author WangMingShuai
     * @date 2020/1/8 13:56
     * @return void
     */
    public void checkAndDynamicCreateShardingDataSource (String tenantName) {
        if (StringUtils.isEmpty(tenantName)) {
            log.error("数据源为空");
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(),"数据源为空");
        }

        ShardingDataSource shardingDataSource = (ShardingDataSource)dataSource;
        Map<String, DataSource> dataSourceMap = shardingDataSource.getDataSourceMap();

        if (!dataSourceMap.containsKey(tenantName)){
            TenantDataSourceVO tenantDataSourceVO = (TenantDataSourceVO) redisTemplateOperator.get(tenantName);
            if (ObjectUtils.isEmpty(tenantDataSourceVO)) {
                tenantDataSourceVO = tenantDataSourceService.findOneUsedDataSource(tenantName);
            }
            if (!ObjectUtils.isEmpty(tenantDataSourceVO)) {
                dynamicCreateShardingDataSource(tenantDataSourceVO);
            } else {
                log.error("非法的数据源连接：{}",tenantName);
                throw new BusinessException(ResponseCode.PARAM_ERROR.code(),"非法的数据源连接");
            }
        }
    }

    /**
     * 根据租户数据源信息 创建Hikari数据源
     * @param tenantDataSourceVO  租户数据源信息
     * @author WangMingShuai
     * @date 2020/1/7 10:36
     * @return com.zaxxer.hikari.HikariDataSource
     */
    private HikariDataSource createHikariDataSource (TenantDataSourceVO tenantDataSourceVO) {
        HikariDataSource newHikariDataSource = new HikariDataSource();
        newHikariDataSource.setDriverClassName(tenantDataSourceVO.getDataSourceDriver());
        newHikariDataSource.setJdbcUrl(tenantDataSourceVO.getDataSourceUrl());
        newHikariDataSource.setUsername(tenantDataSourceVO.getDataSourceUsername());
        newHikariDataSource.setPassword(tenantDataSourceVO.getDataSourcePassword());

        newHikariDataSource.setConnectionTimeout(hikariDataSource.getConnectionTimeout());
        newHikariDataSource.setMinimumIdle(hikariDataSource.getMinimumIdle());
        newHikariDataSource.setMaximumPoolSize(hikariDataSource.getMaximumPoolSize());
        newHikariDataSource.setIdleTimeout(hikariDataSource.getIdleTimeout());
        newHikariDataSource.setMaxLifetime(hikariDataSource.getMaxLifetime());
        newHikariDataSource.setAutoCommit(true);
        newHikariDataSource.setConnectionTestQuery(hikariDataSource.getConnectionTestQuery());
        return newHikariDataSource;
    }

}
