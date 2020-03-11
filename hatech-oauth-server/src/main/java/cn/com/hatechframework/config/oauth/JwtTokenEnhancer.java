package cn.com.hatechframework.config.oauth;

import cn.com.hatechframework.server.po.UserPO;
import cn.com.hatechframework.utils.statics.DataKeyPrefix;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.oauth
 * @className JwtTokenEnhancer
 * @description jwt token增强器 (token中加入租户信息)
 * @author YeMeng
 * @create 2019/12/20 18:33
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/20 18:33             1.0                        jwt token增强器 (token中加入租户信息)
 */
@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    /**
     *  自定义的 jwt token
     * @param accessToken oauth token
     * @param authentication oauth认证信息
     * @author YeMeng
     * @date 2019/12/24 17:18
     * @return org.springframework.security.oauth2.common.OAuth2AccessToken
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserPO user = (UserPO) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>(2);
        // 用户对应租户名称
        List<String> tenantNames = user.getTenantList().stream()
                .map(t-> DataKeyPrefix.TENANT_DATASOURCE_PREFIX + t.getId())
                .collect(Collectors.toList());
        // 注意添加的额外信息，不能和已有的json对象中的key重名
        additionalInfo.put("tenant", tenantNames);
        additionalInfo.put("user_id", user.getId());
        additionalInfo.put("user_name", user.getUsername());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
