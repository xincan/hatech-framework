package cn.com.hatechframework.entity.oauth.rbac.dto;

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
import javax.validation.constraints.Size;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.dto
 * @className UserRegisterDTO
 * @description 用户注册DTO
 * @author WangMingShuai
 * @create 2019/12/28 13:43
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/28 13:43             1.0                         用户注册DTO
 */
@ApiModel(value = "cn.com.hatechframework.entity.oauth.rbac.dto.UserRegisterDTO", description = "用户注册DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    @ApiModelProperty(value="用户账号", dataType = "String", required = true, example = "admin@qq.com")
    @NotBlank(message = "用户账号不能为空")
    @Pattern(regexp = ValidatorUtils.REGEX_EMAIL, message = "用户账号必须为邮箱")
    private String username;

    @ApiModelProperty(value="手机号", dataType = "String", required = true, example = "17099999999")
    @Pattern(regexp = ValidatorUtils.REGEX_MOBILE,message = "手机号不正确")
    private String phone;

    @ApiModelProperty(value="用户登录密码", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "用户登录密码不能为空")
    @Length(message = "用户登录名称长度应该在{min}~{max}之间", min = 1, max = 100)
    private String password;

    @ApiModelProperty(value="用户名", dataType = "String", required = true, example = "张三")
    @NotBlank(message = "用户名不能为空")
    @Size(message = "用户名不能超过{max}个字符",max = 100)
    private String name;

    @ApiModelProperty(value="租户ID", dataType = "String", required = true, example = "UUID")
    @NotBlank(message = "租户ID不能为空")
    @Size(message = "租户ID不能超过{max}个字符",max = 100)
    private String tenantId;

}
