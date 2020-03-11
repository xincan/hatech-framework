package cn.com.hatechframework.config.log;

import java.lang.annotation.*;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.log
 * @className OptionLog
 * @description 日志注解
 * @author WangMingShuai
 * @create 2019/12/20 15:27
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 15:27             1.0                         日志注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptionLog {

    /**
     * 要执行的操作类型（比如：add操作）
     */
    String type() default "";

    /**
     * 业务的日志分类（比如:登录日志，脚本日志，流程日志，操作日志）
     *
     * @return
     */
    String businessType() default "";

    /**
     * 要执行的具体操作类型（比如：添加用户）
     */
    String description() default "";

}