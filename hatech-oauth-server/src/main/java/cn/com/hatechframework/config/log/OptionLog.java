package cn.com.hatechframework.config.log;

import java.lang.annotation.*;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.log
 * @className OptionLog
 * @description 日志注解
 * @author YeMeng
 * @create 2019/12/25 18:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 18:09             1.0                         日志注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptionLog {

    /**
     *  要执行的操作类型（比如：add操作）
     * @author YeMeng
     * @date 2020/1/6 20:41
     * @return
     */
    String type() default "";

    /**
     *  业务的日志分类（比如:登录日志，脚本日志，流程日志，操作日志）
     * @author YeMeng
     * @date 2020/1/6 20:41
     * @return
     */
    String businessType() default "";

    /**
     *  要执行的具体操作类型（比如：添加用户）
     * @author YeMeng
     * @date 2020/1/6 20:42
     * @return
     */
    String description() default "";

}
