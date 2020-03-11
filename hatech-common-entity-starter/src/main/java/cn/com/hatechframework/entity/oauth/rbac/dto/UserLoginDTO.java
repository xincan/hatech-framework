package cn.com.hatechframework.entity.oauth.rbac.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.dto
 * @className UserLoginDTO
 * @description 用户登陆DTO
 * @author WangMingShuai
 * @create 2019/12/30 9:32
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/30 9:32             1.0                         用户登陆DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.user.dto.UserLoginDTO", description = "用户登录传参实体（输入）")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDTO {

    @ApiModelProperty(value="用户名,在grant_type为password时使用", dataType = "String", required = true, example = "11@qq.com")
    @NotBlank(message = "用户名不能为空")
    @Length(message = "当前用户名长度应该在{min}~{max}之间", min=1, max = 100)
    private String username;

    @ApiModelProperty(value="密码,在grant_type为password时使用", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "密码不能为空")
    @Length(message = "当前密码长度应该在{min}~{max}之间", min=1, max = 100)
    private String password;
}
