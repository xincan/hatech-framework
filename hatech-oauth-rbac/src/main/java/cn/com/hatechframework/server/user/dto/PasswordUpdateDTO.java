package cn.com.hatechframework.server.user.dto;

import cn.com.hatechframework.validator.ValidatorUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.dto
 * @className PasswordUpdateDTO
 * @description 修改密码实体类
 * @author YeMeng
 * @create 2020/1/20 16:09
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2020/1/20 16:09             1.0                         修改密码实体类
 */
@ApiModel(value = "cn.com.hatechframework.server.user.dto.PasswordUpdateDTO", description = "修改密码实体类")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordUpdateDTO {

    @ApiModelProperty(value="用户登录旧密码", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "用户登录密码不能为空")
    @Length(message = "用户登录名称长度应该在{min}~{max}之间", min = 1, max = 100)
    @Pattern(regexp = ValidatorUtils.REGEX_SECRET_CODE, message = "当前旧密码格式错误")
    private String oldPwd;

    @ApiModelProperty(value="用户登录新密码", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "用户登录密码不能为空")
    @Length(message = "用户登录名称长度应该在{min}~{max}之间", min = 1, max = 100)
    @Pattern(regexp = ValidatorUtils.REGEX_SECRET_CODE, message = "当前新密码格式错误")
    private String newPwd;

}
