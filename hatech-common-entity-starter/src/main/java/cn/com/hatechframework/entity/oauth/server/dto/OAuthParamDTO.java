package cn.com.hatechframework.entity.oauth.server.dto;

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
 * @package cn.com.hatechframework.entity.oauth.server.dto
 * @className OAuthParamDTO
 * @description 用户登录传参实体
 * @author YeMeng
 * @create 2019/12/25 20:05
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 20:05             1.0                         用户登录传参实体
 */
@ApiModel(value = "cn.com.hatechframework.entity.oauth.server.dto.OAuthParamDTO", description = "用户登录传参实体（输入）")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OAuthParamDTO {

    @ApiModelProperty(value="客户端clientId", dataType = "String", required = true, example = "hatech-oauth-server")
    @NotBlank(message = "客户端clientId不能为空")
    @Length(message = "当前客户端clientId长度应该在{min}~{max}之间", min = 1, max = 128)
    private String clientId;

    @ApiModelProperty(value="客户端密钥clientSecret", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "客户端密钥clientSecret不能为空")
    @Length(message = "客户端密钥clientSecret长度应该在{min}~{max}之间", max = 128)
    private String clientSecret;

    @ApiModelProperty(value="授权类型", dataType = "String", required = true, example = "password")
    @NotBlank(message = "授权类型不能为空")
    @Length(message = "当前授权类型长度应该在{min}~{max}之间", max = 20)
    private String grantType;

    @ApiModelProperty(value="授权范围", dataType = "String", required = true, example = "server")
    @NotBlank(message = "授权范围不能为空")
    @Length(message = "当前授权范围长度应该在{min}~{max}之间", min = 1, max = 128)
    private String scope;

    @ApiModelProperty(value="用户名,在grant_type为password时使用", dataType = "String", required = true, example = "11@qq.com")
    @NotBlank(message = "用户名不能为空")
    @Length(message = "当前用户名长度应该在{min}~{max}之间", min=1, max = 20)
    private String username;

    @ApiModelProperty(value="密码,在grant_type为password时使用", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "密码不能为空")
    @Length(message = "当前密码长度应该在{min}~{max}之间", min=1, max = 100)
    private String password;

}
