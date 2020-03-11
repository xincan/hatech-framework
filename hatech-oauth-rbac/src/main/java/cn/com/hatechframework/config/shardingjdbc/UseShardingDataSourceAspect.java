package cn.com.hatechframework.config.shardingjdbc;

import cn.com.hatechframework.utils.context.BaseContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.shardingjdbc
 * @className UseShardingDataSourceAspect
 * @description Sharing 数据源aop
 * @author WangMingShuai
 * @create 2019/12/23 16:09
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/23 16:09             1.0                         Sharing 数据源aop
 */
@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE-1)
@Slf4j
public class UseShardingDataSourceAspect {

    private final ShardingCreateDataSource shardingCreateDataSource;

    public UseShardingDataSourceAspect(ShardingCreateDataSource shardingCreateDataSource) {
        this.shardingCreateDataSource = shardingCreateDataSource;
    }

    @Pointcut("@annotation(cn.com.hatechframework.config.shardingjdbc.SwitchDataSource)")
    public void useShardingDataSource() {
        //定义一个切面点，使用注解
    }

    @Around("useShardingDataSource()")
    public Object dataSourceSwitcher(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            String tenantName = BaseContextHandler.getTenantName();
            if (StringUtils.isEmpty(tenantName)) {
                return joinPoint.proceed();
            }
            shardingCreateDataSource.checkAndDynamicCreateShardingDataSource(tenantName);
            //切换数据源
            HintManager.getInstance().setDatabaseShardingValue(tenantName);
            //执行方法
            return joinPoint.proceed();
        } finally {
            //切换回原来的数据源（重要）
            HintManager.clear();
        }
    }
}
