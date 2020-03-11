package cn.com.hatechframework.config.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.DefaultUserApprovalHandler;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.oauth
 * @className UserAutoApprovalHandler
 * @description 设置为自动准许authorization code
 * @author YeMeng
 * @create 2019/12/23 16:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:09             1.0                         设置为自动准许authorization code
 */
@Configuration
public class UserAutoApprovalHandler extends DefaultUserApprovalHandler {

    public UserAutoApprovalHandler(AuthorizationServerEndpointsConfiguration authorizationServerEndpointsConfiguration) throws Exception {
        // 用户授权端口配置
        authorizationServerEndpointsConfiguration.authorizationEndpoint().setUserApprovalHandler(this);
    }


    /**
     *  是否准许authorization code认证
     * @param authorizationRequest  认证请求
     * @param userAuthentication  用户认证信息
     * @author YeMeng
     * @date 2019/12/24 17:35
     * @return boolean
     */
    @Override
    public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
        return true;
    }

}
