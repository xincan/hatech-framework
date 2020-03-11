package cn.com.hatechframework.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.dto
 * @className UsernamePasswordPrincipalDTO
 * @description 用户名密码principal
 * @author YeMeng
 * @create 2019/12/23 19:54
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 19:54             1.0                         用户名密码principal
 */
@ApiModel(value = "cn.com.hatechframework.dto.UsernamePasswordPrincipalDTO", description = "用户名密码principal（输入）")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsernamePasswordPrincipalDTO {

    @ApiModelProperty(value="用户名", dataType = "String", required = true, example = "user1")
    @NotBlank(message = "当前用户名不能为空")
    @Length(message = "当前用户名长度应该在{min}~{max}之间", min=1, max = 100)
    private String username;

    @ApiModelProperty(value="密码", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "当前密码不能为空")
    @Length(message = "当前密码长度应该在{min}~{max}之间", min=1, max = 100)
    private String password;

}
