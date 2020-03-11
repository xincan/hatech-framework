package cn.com.hatechframework.server.service;

import cn.com.hatechframework.server.dto.OAuthCodeDTO;
import cn.com.hatechframework.server.dto.UsernamePasswordPrincipalDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.service
 * @className AuthorizeService
 * @description 授权service接口
 * @author YeMeng
 * @create 2020/1/2 14:52
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2020/1/2 14:52             1.0                         授权service接口
 */
public interface IAuthorizeService {
    /**
     *  获取用户principal
     * @param principalDTO 用户名,密码
     * @author YeMeng
     * @date 2019/12/24 19:37
     * @return org.springframework.security.core.Authentication
     */
    Authentication principal(UsernamePasswordPrincipalDTO principalDTO);

    /**
     *  校验码校验
     * @param oAuthCodeDTO 校验参数
     * @param sessionStatus session会话
     * @author YeMeng
     * @date 2019/12/24 19:38
     * @return java.lang.String 含有校验码code的url
     */
    String authorize(OAuthCodeDTO oAuthCodeDTO, SessionStatus sessionStatus);
}
