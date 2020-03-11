package cn.com.hatechframework.config.oauth;

import cn.com.hatechframework.utils.context.BaseContextHandler;
import cn.com.hatechframework.utils.statics.DataKeyPrefix;
import cn.com.hatechframework.utils.token.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.oauth
 * @className UserAuthTenantRestInterceptor
 * @description 用户信息拦截器,设置到全局
 * @author YeMeng
 * @create 2019/12/23 16:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:59             1.0                        用户信息拦截器,设置到全局
 */
@Slf4j
public class UserAuthTenantRestInterceptor extends HandlerInterceptorAdapter {

    /**
     *  拦截前操作
     * @param request  请求
     * @param response  请求返回
     * @param handler controller处理器
     * @author YeMeng
     * @date 2020/1/6 20:55
     * @return boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(authorization) && authorization.startsWith(DataKeyPrefix.TOKEN_TYPE_PREFIX)){
            String jwt = authorization.substring(7);
            BaseContextHandler.setUserName(TokenUtils.getUserName(jwt));
            BaseContextHandler.setUserId(TokenUtils.getUserId(jwt));
            BaseContextHandler.setTenantName(TokenUtils.getTenant(jwt));
            BaseContextHandler.setToken(jwt);
        }
        return super.preHandle(request, response, handler);
    }

    /**
     *  拦截后操作
     * @param request  请求
     * @param response  请求返回
     * @param handler controller处理器
     * @param ex  错误信息
     * @author YeMeng
     * @date 2020/1/6 20:57
     * @return void
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }

}
