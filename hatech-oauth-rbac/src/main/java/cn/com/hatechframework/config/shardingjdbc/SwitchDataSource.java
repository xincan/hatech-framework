package cn.com.hatechframework.config.shardingjdbc;

import java.lang.annotation.*;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.shardingjdbc
 * @className SwitchDataSource
 * @description 切换数据源注解
 * @author YeMeng
 * @create 2019/12/27 10:43
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/27 10:43             1.0                         切换数据源注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SwitchDataSource {

    /**
     * 描述
     */
    String description() default "";
}
