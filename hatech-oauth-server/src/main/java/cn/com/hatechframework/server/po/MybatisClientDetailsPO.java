package cn.com.hatechframework.server.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.po
 * @className MybatisClientDetailsPO
 * @description 使用mybatis plus查询ClientDetails
 * @author YeMeng
 * @create 2019/12/18 18:42
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 18:42             1.0                         使用mybatis plus查询ClientDetails
 */
@Slf4j
@Data
@TableName("oauth_client_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MybatisClientDetailsPO implements ClientDetails {

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

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        if (StringUtils.isEmpty(webServerRedirectUri)) {
            return new HashSet<>();
        }
        return new HashSet<>(Arrays.asList(webServerRedirectUri.split(",")));
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return !StringUtils.isEmpty(scope) && Boolean.parseBoolean(scope);
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        if (StringUtils.isEmpty(additionalInformation)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                MapType type = objectMapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
                return objectMapper.readValue(additionalInformation, type);
            } catch (IOException e) {
                log.error("转换json字符失败: "+additionalInformation, e);
            }
        }
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if (!StringUtils.isEmpty(authorities)) {
            Collection<GrantedAuthority> collection = new HashSet<>();
            Arrays.stream(authorities.split(",")).forEach(t-> collection.add(new SimpleGrantedAuthority(t)));
            return collection;
        }
        return new ArrayList<>();
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return StringUtils.isEmpty(authorizedGrantTypes)?null:StringUtils.commaDelimitedListToSet(authorizedGrantTypes);
    }

    @Override
    public Set<String> getScope() {
        return StringUtils.isEmpty(scope)?null:StringUtils.commaDelimitedListToSet(scope);
    }

    @Override
    public Set<String> getResourceIds() {
        return StringUtils.isEmpty(resourceIds)?null:StringUtils.commaDelimitedListToSet(resourceIds);
    }

    @Override
    public String toString() {
        return clientId;
    }

}
