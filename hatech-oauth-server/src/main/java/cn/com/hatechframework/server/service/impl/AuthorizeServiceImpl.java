package cn.com.hatechframework.server.service.impl;

import cn.com.hatechframework.config.oauth.UserAutoApprovalHandler;
import cn.com.hatechframework.server.dto.OAuthCodeDTO;
import cn.com.hatechframework.server.dto.UsernamePasswordPrincipalDTO;
import cn.com.hatechframework.server.service.IAuthorizeService;
import cn.com.hatechframework.utils.OauthUrlUtil;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.*;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.endpoint.DefaultRedirectResolver;
import org.springframework.security.oauth2.provider.endpoint.RedirectResolver;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.service.impl
 * @className AuthorizeServiceImpl
 * @description 授权service实现
 * @author YeMeng
 * @create 2020/1/2 14:51
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2020/1/2 14:51             1.0                         授权service实现
 */
@Slf4j
@Service
public class AuthorizeServiceImpl implements IAuthorizeService {

    private static final String AUTHORIZATION_CODE = "code";

    /**
     * authorize 对象转换成map, 以下属性驼峰类型变为下划线类型
     */
    private static final Map<String, String> CONFIG_MAP = new HashMap<>();

    static {
        // authorize 对象转换成map, 以下属性驼峰类型变为下划线类型
        CONFIG_MAP.put("clientId", OAuth2Utils.CLIENT_ID);
        CONFIG_MAP.put("responseType", OAuth2Utils.RESPONSE_TYPE);
        CONFIG_MAP.put("redirectUri", OAuth2Utils.REDIRECT_URI);
    }

    /**
     * 注入自定义的MybatisClientDetails
     */
    private ClientDetailsService clientDetails;

    /**
     * 注入根据上述自定义MybatisClientDetails生成的DefaultOAuth2RequestFactory
     */
    private OAuth2RequestFactory oAuth2RequestFactory;

    /**
     * 自动准许authorization code, 不跳转到 /oauth/confirm_access 准许页面
     */
    private UserAutoApprovalHandler userAutoApprovalHandler;

    /**
     * 跳转解析
     */
    private RedirectResolver redirectResolver;

    /**
     * oauth 请求校验
     */
    private OAuth2RequestValidator oauthRequestValidator;

    /**
     * 校验码服务
     */
    private AuthorizationCodeServices authorizationCodeServices;

    /**
     * 鉴权管理
     */
    private AuthenticationManager authenticationManager;


    public AuthorizeServiceImpl(ClientDetailsService clientDetails,
                           AuthorizationServerEndpointsConfiguration authorizationServerEndpointsConfiguration,
                           UserAutoApprovalHandler userAutoApprovalHandler, AuthenticationManager authenticationManager) {
        // 自定义的MybatisClientDetails
        this.clientDetails = clientDetails;
        // OAuth2Request工厂, 使用自定义的MybatisClientDetails
        this.oAuth2RequestFactory = new DefaultOAuth2RequestFactory(clientDetails);
        // 自动准许authorization code, 不跳转到 /oauth/confirm_access 准许页面
        this.userAutoApprovalHandler = userAutoApprovalHandler;
        // 跳转解析
        this.redirectResolver = new DefaultRedirectResolver();
        // oauth 请求校验
        this.oauthRequestValidator = authorizationServerEndpointsConfiguration.getEndpointsConfigurer().getOAuth2RequestValidator();
        // 校验码服务
        this.authorizationCodeServices = authorizationServerEndpointsConfiguration.getEndpointsConfigurer().getAuthorizationCodeServices();
        // 鉴权管理
        this.authenticationManager = authenticationManager;
    }


    /**
     *  获取用户principal
     * @param principalDTO 用户名,密码
     * @author YeMeng
     * @date 2019/12/24 19:37
     * @return org.springframework.security.core.Authentication
     */
    @Override
    public Authentication principal(UsernamePasswordPrincipalDTO principalDTO) {
        Authentication userAuth = new UsernamePasswordAuthenticationToken(principalDTO.getUsername(), principalDTO.getPassword());
        try {
            userAuth = authenticationManager.authenticate(userAuth);
        }
        catch (AccountStatusException | BadCredentialsException ase) {
            log.error("错误的grant type类型: {}", ase.getMessage());
            throw new InvalidGrantException(ase.getMessage());
        }
        if (userAuth == null || !userAuth.isAuthenticated()) {
            log.error("授权用户失败: {}", principalDTO.getUsername());
            throw new InvalidGrantException("授权用户失败: " + principalDTO.getUsername());
        }
        return userAuth;
    }

    /**
     *  校验码校验
     * @param oAuthCodeDTO 校验参数
     * @param sessionStatus session会话
     * @author YeMeng
     * @date 2019/12/24 19:38
     * @return java.lang.String 含有校验码code的url
     */
    @Override
    @SuppressWarnings("unchecked")
    public String authorize(OAuthCodeDTO oAuthCodeDTO, SessionStatus sessionStatus) {
        Authentication principal = principal(oAuthCodeDTO);
        Map<String, String> parameters = OrikaUtils.map(oAuthCodeDTO, CONFIG_MAP, Map.class);
        log.info("{}", "根据参数创建授权请求");
        AuthorizationRequest authorizationRequest = oAuth2RequestFactory.createAuthorizationRequest(parameters);
        Set<String> responseTypes = authorizationRequest.getResponseTypes();
        // 只允许类型为code
        if (!responseTypes.contains(AUTHORIZATION_CODE)) {
            log.error("{}: {}", "不支持的 response types: ", responseTypes);
            throw new UnsupportedResponseTypeException("不支持的 response types: " + responseTypes);
        }
        if (authorizationRequest.getClientId() == null) {
            log.error("client id不能为空");
            throw new InvalidClientException("client id不能为空");
        }
        try {
            if (!principal.isAuthenticated()) {
                log.error("用户未被认证");
                throw new InsufficientAuthenticationException("用户未被认证");
            }
            ClientDetails client = clientDetails.loadClientByClientId(authorizationRequest.getClientId());
            log.info("判断数据库中的跳转url和参数中的url是否一致: {}", OAuth2Utils.REDIRECT_URI);
            String redirectUriParameter = authorizationRequest.getRequestParameters().get(OAuth2Utils.REDIRECT_URI);
            String resolvedRedirect = redirectResolver.resolveRedirect(redirectUriParameter, client);
            if (!StringUtils.hasText(resolvedRedirect)) {
                log.error("{}", "客户端详情ClientDetails中需要含有redirect url");
                throw new RedirectMismatchException("客户端详情ClientDetails中需要含有redirect url");
            }
            authorizationRequest.setRedirectUri(resolvedRedirect);
            log.info("校验scope范围");
            oauthRequestValidator.validateScope(authorizationRequest, client);
            log.info("判断是否自动准许获取校验码");
            authorizationRequest = userAutoApprovalHandler.checkForPreApproval(authorizationRequest, principal);
            boolean approved = userAutoApprovalHandler.isApproved(authorizationRequest, principal);
            authorizationRequest.setApproved(approved);
            if (responseTypes.contains(AUTHORIZATION_CODE)) {
                return getAuthorizationCodeResponse(authorizationRequest, principal);
            }
            return null;
        } catch (RuntimeException e) {
            sessionStatus.setComplete();
            throw e;
        }
    }

    /**
     *  生成校验码url
     * @param authorizationRequest 认证请求
     * @param authUser 认证用户
     * @author YeMeng
     * @date 2019/12/24 19:39
     * @return java.lang.String
     */
    private String getAuthorizationCodeResponse(AuthorizationRequest authorizationRequest, Authentication authUser) {
        try {
            log.info("{}", "校验码成功url");
            return getSuccessfulRedirect(authorizationRequest, generateCode(authorizationRequest, authUser));
        }
        catch (OAuth2Exception e) {
            log.info("{}", "校验码失败url");
            return getUnsuccessfulRedirect(authorizationRequest, e);
        }
    }

    /**
     *  生成校验码
     * @param authorizationRequest 认证请求
     * @param authentication 用户认证信息
     * @author YeMeng
     * @date 2019/12/24 19:40
     * @return java.lang.String
     */
    private String generateCode(AuthorizationRequest authorizationRequest, Authentication authentication) {
        try {
            OAuth2Request request = oAuth2RequestFactory.createOAuth2Request(authorizationRequest);
            OAuth2Authentication combinedAuth = new OAuth2Authentication(request, authentication);
            return authorizationCodeServices.createAuthorizationCode(combinedAuth);
        }
        catch (OAuth2Exception e) {
            log.error("{}", "错误信息填入到url的state状态中");
            if (authorizationRequest.getState() != null) {
                e.addAdditionalInformation(OAuth2Utils.STATE, authorizationRequest.getState());
            }
            throw e;
        }
    }

    /**
     *  校验码生成成功跳转链接
     * @param authorizationRequest 认证请求
     * @param authorizationCode 校验码
     * @author YeMeng
     * @date 2019/12/24 19:40
     * @return java.lang.String
     */
    private String getSuccessfulRedirect(AuthorizationRequest authorizationRequest, String authorizationCode) {
        if (authorizationCode == null) {
            log.error("{}", "当前请求范围中不存在校验码");
            throw new IllegalStateException("当前请求范围中不存在校验码");
        }
        Map<String, String> query = new LinkedHashMap<>();
        query.put("code", authorizationCode);
        String state = authorizationRequest.getState();
        if (state != null) {
            query.put(OAuth2Utils.STATE, state);
        }
        return OauthUrlUtil.append(authorizationRequest.getRedirectUri(), query, false);
    }

    /**
     *  校验码生成失败跳转链接
     * @param authorizationRequest 认证请求
     * @param failure 认证异常
     * @author YeMeng
     * @date 2019/12/24 19:40
     * @return java.lang.String
     */
    private String getUnsuccessfulRedirect(AuthorizationRequest authorizationRequest, OAuth2Exception failure) {
        if (authorizationRequest == null || authorizationRequest.getRedirectUri() == null) {
            throw new UnapprovedClientAuthenticationException("认证失败", failure);
        }
        Map<String, String> query = new LinkedHashMap<>();
        log.error("失败信息: {}", failure.getOAuth2ErrorCode());
        query.put("error", failure.getOAuth2ErrorCode());
        log.error("失败详情: {}", failure.getMessage());
        query.put("error_description", failure.getMessage());
        if (authorizationRequest.getState() != null) {
            query.put(OAuth2Utils.STATE, authorizationRequest.getState());
        }
        if (failure.getAdditionalInformation() != null) {
            for (Map.Entry<String, String> additionalInfo : failure.getAdditionalInformation().entrySet()) {
                query.put(additionalInfo.getKey(), additionalInfo.getValue());
            }
        }
        return OauthUrlUtil.append(authorizationRequest.getRedirectUri(), query, false);
    }


}
