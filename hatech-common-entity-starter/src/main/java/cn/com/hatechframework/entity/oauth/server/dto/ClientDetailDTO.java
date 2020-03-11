package cn.com.hatechframework.entity.oauth.server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.entity.oauth.server.dto
 * @className ClientDetailDTO
 * @description MybatisClientDetails视图层对象
 * @author YeMeng
 * @create 2019/12/18 17:07
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 17:07             1.0                         MybatisClientDetails视图层对象
 */
@ApiModel(value = "cn.com.hatechframework.entity.oauth.server.dto.ClientDetailDTO", description = "客户端详情实体类（输入）")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDetailDTO {

    @ApiModelProperty(value="客户端id", dataType = "String", required = true, example = "hatech-oauth-rbac")
    @NotBlank(message = "客户端id不能为空")
    @Length(message = "当前客户端id长度应该在{min}~{max}之间", min = 1, max = 128)
    private String clientId;

    @ApiModelProperty(value="客户端所能访问的资源id集合,多个资源时用逗号,分隔", dataType = "String", example = "hatech-oauth-server,hatech-oauth-rbac")
    @Length(message = "当前系统操作用户ID长度应该在{min}~{max}之间", min = 0, max = 128)
    private String resourceIds;

    @ApiModelProperty(value="客户端密钥", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "客户端密钥不能为空")
    @Length(message = "客户端密钥长度应该在{min}~{max}之间", max = 128)
    private String clientSecret;

    @ApiModelProperty(value="客户端申请的权限范围,用逗号,分隔,可选值包括read,write等", dataType = "String", required = true, example = "server")
    @NotBlank(message = "当前权限范围不能为空")
    @Length(message = "当前权限范围长度应该在{min}~{max}之间", min = 1, max = 128)
    private String scope;

    @ApiModelProperty(value="客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials, 若支持多个grant_type用逗号,分隔", dataType = "String", required = true, example = "password")
    @NotBlank(message = "当前客户端支持的grant_type不能为空")
    @Length(message = "当前客户端支持的grant_type长度应该在{min}~{max}之间", min = 1, max = 128)
    private String authorizedGrantTypes;

    @ApiModelProperty(value="客户端的重定向URI", dataType = "String", example = "")
    @Length(message = "客户端的重定向URI长度应该在{max}之内", max = 128)
    private String webServerRedirectUri;

    @ApiModelProperty(value="指定客户端所拥有的Spring Security的权限值,逗号分隔", dataType = "String", required = true, example = "")
    @Length(message = "当前系统操作用户ID长度应该在{max}之内", max = 128)
    private String authorities;

    @ApiModelProperty(value="设定客户端的access_token的有效时间值(单位:秒)", dataType = "Integer", required = true, example = "6000")
    @DecimalMin(message = "当前客户端的access_token有效时间,应当大于等于{value}", value = "1")
    @DecimalMax(message = "当前客户端的access_token有效时间,应当小于等于{value}", value = "999999")
    private Integer accessTokenValidity;

    @ApiModelProperty(value="设定客户端的refresh_token的有效时间值(单位:秒)", dataType = "Integer", required = true, example = "6000")
    @DecimalMin(message = "当前客户端的refresh_token有效时间,应当大于等于{value}", value = "1")
    @DecimalMax(message = "当前客户端的refresh_token有效时间,应当小于等于{value}", value = "999999")
    private Integer refreshTokenValidity;

    @ApiModelProperty(value="其他信息, JSON格式", dataType = "String", required = true, example = "")
    @Length(message = "当前其他信息长度应该在{max}之内", max = 2048)
    private String additionalInformation;

    @ApiModelProperty(value="是否自动Approval操作", dataType = "String", required = true, example = "")
    @Length(message = "当前autoApprove长度应该在{max}之内", max = 128)
    private String autoApprove;

}
