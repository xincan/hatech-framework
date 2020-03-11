package cn.com.hatechframework.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.validator
 * @className HatechJsonValidator
 * @description JSON字符串验证注解
 * @author WangMingShuai
 * @create 2019/12/25 19:01
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/25 19:01             1.0                         JSON字符串验证注解
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HatechJsonConstraintValidator.class)
public @interface HatechJsonValidator {

    String message() default "非法的json字符串";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
