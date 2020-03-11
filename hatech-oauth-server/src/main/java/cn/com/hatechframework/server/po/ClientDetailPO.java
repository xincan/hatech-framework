package cn.com.hatechframework.server.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.po
 * @className ClientDetails
 * @description 客户端详情ClientDetails
 * @author YeMeng
 * @create 2019/12/18 18:42
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 18:42             1.0                         客户端详情ClientDetails
 */
@Slf4j
@Data
@TableName("oauth_client_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDetailPO {

    @TableId("client_id")
    private String clientId;

    @TableField("resource_ids")
    private String resourceIds;

    @TableField("client_secret")
    private String clientSecret;

    @TableField("scope")
    private String scope;

    @TableField("authorized_grant_types")
    private String authorizedGrantTypes;

    @TableField("web_server_redirect_uri")
    private String webServerRedirectUri;

    @TableField("authorities")
    private String authorities;

    @TableField("access_token_validity")
    private Integer accessTokenValidity;

    @TableField("refresh_token_validity")
    private Integer refreshTokenValidity;

    @TableField("additional_information")
    private String additionalInformation;

    @TableField("autoapprove")
    private String autoApprove;

}
