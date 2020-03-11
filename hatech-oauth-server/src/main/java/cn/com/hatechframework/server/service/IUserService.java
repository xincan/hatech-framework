package cn.com.hatechframework.server.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.entity.oauth.rbac.dto.UserLoginDTO;
import cn.com.hatechframework.entity.oauth.server.dto.OAuthParamDTO;
import cn.com.hatechframework.entity.oauth.server.dto.OAuthRefreshParamDTO;
import cn.com.hatechframework.server.dto.OAuthCodeTokenDTO;
import cn.com.hatechframework.server.po.OAuthRequestPO;
import cn.com.hatechframework.server.po.UserPO;
import cn.com.hatechframework.utils.response.ResponseObject;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.Map;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.service
 * @className IUserService
 * @description 用户接口
 * @author YeMeng
 * @create 2019/12/18 17:02
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 17:02             1.0                        用户接口
 */
public interface IUserService extends IBaseService<UserPO> {

    /**
     *  用户oauth登录
     * @param oAuthParamDTO  oauth登陆参数
     * @author YeMeng
     * @date 2020/1/6 14:27
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    OAuth2AccessToken userOAuthLogin(OAuthParamDTO oAuthParamDTO);

    /**
     *  用户登录(用户名密码)
     * @param userLoginDTO  用户名密码
     * @author YeMeng
     * @date 2020/1/6 14:07
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    OAuth2AccessToken usernamePasswordLogin(UserLoginDTO userLoginDTO);

    /**
     *  用户校验码获取token
     * @param oAuthCodeTokenDTO  校验码登录参数
     * @author YeMeng
     * @date 2020/1/6 14:34
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    OAuth2AccessToken userCodeLogin(OAuthCodeTokenDTO oAuthCodeTokenDTO);

    /**
     *  用户刷新token
     * @param oAuthRefreshParamDTO  刷新token参数
     * @author YeMeng
     * @date 2020/1/6 14:41
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    OAuth2AccessToken userRefreshLogin(OAuthRefreshParamDTO oAuthRefreshParamDTO);

    /**
     *  用户token接口(重写spring /oauth/token 接口)
     * @param request  oAuthParam 登陆参数
     * @author YeMeng
     * @date 2019/12/24 19:36
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    OAuth2AccessToken userOAuthToken(OAuthRequestPO request);

    /**
     *  用户退出登录
     * @param oAuth2Authentication 删除redis中储存的access token
     * @author YeMeng
     * @date 2019/12/24 19:37
     * @return boolean
     */
    boolean userLogout(OAuth2Authentication oAuth2Authentication);

    /**
     *  校验token
     * @param value token 校验结果
     * @author YeMeng
     * @date 2019/12/24 19:37
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String, Object> checkToken(String value);

    /**
     * 用户详情
     * @param principal  用户登录信息
     * @author YeMeng
     * @date 2020/2/10 16:37
     * @return
     */
    Principal principal(Principal principal);
}
