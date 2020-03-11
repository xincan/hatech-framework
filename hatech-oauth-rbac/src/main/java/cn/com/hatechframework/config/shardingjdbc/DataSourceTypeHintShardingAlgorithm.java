package cn.com.hatechframework.config.shardingjdbc;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.shardingjdbc
 * @className DataSourceTypeHintShardingAlgorithm
 * @description 设置ShardingJdbc使用自定义的datasource选择逻辑
 * @author WangMingShuai
 * @create 2020/1/4 12:58
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/4 12:58             1.0                         设置ShardingJdbc使用自定义的datasource选择逻辑
 */
@Slf4j
public class DataSourceTypeHintShardingAlgorithm implements HintShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        if (!CollectionUtils.isEmpty(shardingValue.getValues())) {
            log.info("当前所选择的数据源是：{}",shardingValue.getValues());
            return availableTargetNames.stream().filter(availableTargetName ->
                    shardingValue.getValues().contains(availableTargetName)).collect(Collectors.toList());
        }
        return availableTargetNames;
    }
}
