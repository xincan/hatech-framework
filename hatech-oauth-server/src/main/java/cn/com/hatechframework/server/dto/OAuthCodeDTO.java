package cn.com.hatechframework.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.dto
 * @className AuthCodeDTO
 * @description authorization code 校验码实体类
 * @author YeMeng
 * @create 2019/12/23 17:12
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 17:12             1.0                         authorization code 校验码实体类
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "cn.com.hatechframework.dto.OAuthCodeDTO", description = "校验码实体类（输入）")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OAuthCodeDTO extends UsernamePasswordPrincipalDTO {

    @ApiModelProperty(value="客户端支持的responseType,只支持code验证码类型", dataType = "String", required = true, example = "code")
    @NotBlank(message = "当前客户端支持的responseType不能为空")
    @Length(message = "当前客户端支持的responseType长度应该在{min}~{max}之间", min = 1, max = 20)
    private String responseType;

    @ApiModelProperty(value="客户端clientId", dataType = "String", required = true, example = "swagger")
    @NotBlank(message = "客户端clientId不能为空")
    @Length(message = "当前客户端clientId长度应该在{min}~{max}之间", min = 1, max = 128)
    private String clientId;

    @ApiModelProperty(value="跳转链接redirectUri,跳转url需要与数据库存储的url一致", dataType = "String", required = true, example = "http://127.0.0.1:8070/doc.html")
    @NotBlank(message = "跳转链接redirectUri不能为空")
    @Length(message = "当前跳转链接redirectUri长度应该在{min}-{max}之内", min=1, max = 128)
    private String redirectUri;

    @ApiModelProperty(value="授权范围", dataType = "String", required = true, example = "server")
    @NotBlank(message = "授权范围不能为空")
    @Length(message = "当前授权范围长度应该在{min}~{max}之间", min = 1, max = 128)
    private String scope;

    @Builder
    public OAuthCodeDTO(String responseType, String clientId, String redirectUri, String scope, String username, String password) {
        super(username, password);
        this.responseType = responseType;
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.scope = scope;
    }
}
