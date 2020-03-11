package cn.com.hatechframework.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.validator
 * @className JsonValidator
 * @description JSON字符串验证实现类
 * @author WangMingShuai
 * @create 2019/12/25 19:04
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/25 19:04             1.0                         JSON字符串验证实现类
 */
public class HatechJsonConstraintValidator implements ConstraintValidator<HatechJsonValidator,String> {
    @Override
    public boolean isValid(String json, ConstraintValidatorContext constraintValidatorContext) {
        return ValidatorUtils.isJsonString(json);
    }
}
