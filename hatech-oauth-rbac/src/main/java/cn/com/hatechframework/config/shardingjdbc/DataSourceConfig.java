package cn.com.hatechframework.config.shardingjdbc;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.HintShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.shardingjdbc
 * @className DataSourceConfig
 * @description 配置数据源
 * @author WangMingShuai
 * @create 2020/1/4 12:58
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/4 12:58             1.0                         配置数据源
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    /**主数据源名称*/
    @Value("${spring.datasource.name}")
    private String dataSourceName;

    /**配置hikari数据源*/
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariDataSource hikariDataSource() {
        return new HikariDataSource();
    }

    /**
     * 定义shardingDataSource
     * @param hikariDataSource  数据源
     * @author WangMingShuai
     * @date 2020/1/7 10:34
     * @return javax.sql.DataSource
     */
    @Bean("shardingDataSource")
    public DataSource shardingDataSource(HikariDataSource hikariDataSource) throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>(16);
        dataSourceMap.put(dataSourceName, new DataSourceProxy(hikariDataSource));
        log.info("{}","定义sharding jdbc 分库策略");
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        HintShardingStrategyConfiguration hintShardingStrategyConfiguration
                = new HintShardingStrategyConfiguration(new DataSourceTypeHintShardingAlgorithm());

        log.info("{}","设置默认分库策略，设置默认主数据源");
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(hintShardingStrategyConfiguration);
        shardingRuleConfig.setDefaultDataSourceName(dataSourceName);
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new Properties());
    }

    /**
     * 定义全局的dataSource使用shardingDataSource
     * @param shardingDataSource  数据源
     * @author WangMingShuai
     * @date 2020/1/7 10:33
     * @return javax.sql.DataSource
     */
    @Primary
    @Bean("dataSource")
    public DataSource dataSource(@Qualifier("shardingDataSource") DataSource shardingDataSource) {
        return shardingDataSource;
    }

}
