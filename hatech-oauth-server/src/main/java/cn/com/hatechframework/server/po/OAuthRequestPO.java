package cn.com.hatechframework.server.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.po
 * @className OauthRequest
 * @description oauth请求参数, 统一用户登录, 刷新token, 用户校验码三类接口传参
 * @author YeMeng
 * @create 2019/12/25 20:06
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 20:06             1.0                         oauth请求参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OAuthRequestPO {

    /**
     *  客户端id
     */
    private String clientId;

    /**
     *  客户端密码
     */
    private String clientSecret;

    /**
     *  认证方式
     */
    private String grantType;

    /**
     * scope范围
     */
    private String scope;

    /**
     *  用户名
     */
    private String username;

    /**
     *  密码
     */
    private String password;

    /**
     *  校验码
     */
    private String code;

    /**
     *  刷新token
     */
    private String refreshToken;

    /**
     * 重定向地址
     */
    private String redirectUri;

}
