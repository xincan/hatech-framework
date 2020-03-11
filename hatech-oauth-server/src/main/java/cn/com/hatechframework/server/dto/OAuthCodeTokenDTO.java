package cn.com.hatechframework.server.dto;

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
 * @package cn.com.hatechframework.entity.oauth.server
 * @className OAuthCodeTokenDTO
 * @description oauth通过authorization code获取token实体类(传参)
 * @author YeMeng
 * @create 2019/12/25 20:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 20:09             1.0                         oauth通过authorization code获取token实体类(传参)
 */
@ApiModel(value = "cn.com.hatechframework.dto.OAuthCodeTokenDTO", description = "通过authorization code获取token实体类(传参)")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OAuthCodeTokenDTO {

    @ApiModelProperty(value="客户端clientId", dataType = "String", required = true, example = "swagger")
    @NotBlank(message = "客户端clientId不能为空")
    @Length(message = "当前客户端clientId长度应该在{min}~{max}之间", min = 1, max = 128)
    private String clientId;

    @ApiModelProperty(value="客户端密钥clientSecret", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "客户端密钥clientSecret不能为空")
    @Length(message = "客户端密钥clientSecret长度应该在{min}~{max}之间", max = 128)
    private String clientSecret;

    @ApiModelProperty(value="授权类型", dataType = "String", required = true, example = "authorization_code")
    @NotBlank(message = "授权类型不能为空")
    @Length(message = "授权类型长度应该在{min}~{max}之间", max = 20)
    private String grantType;

    @ApiModelProperty(value="授权范围", dataType = "String", required = true, example = "server")
    @NotBlank(message = "授权范围不能为空")
    @Length(message = "当前授权范围长度应该在{min}~{max}之间", min = 1, max = 128)
    private String scope;

    @ApiModelProperty(value="校验码,在grant_type为authentication_code时使用", dataType = "String", required = true, example = "")
    @NotBlank(message = "校验码不能为空")
    @Length(message = "当前校验码长度应该在{min}~{max}之间", min = 1, max = 6)
    private String code;

    @ApiModelProperty(value="重定向url,在grant_type为authentication_code时使用", dataType = "String", required = true, example = "http://127.0.0.1:8070/doc.html")
    @NotBlank(message = "重定向url不能为空")
    @Length(message = "当前跳转链接redirectUri长度应该在{min}-{max}之内", min=1, max = 128)
    private String redirectUri;

}
