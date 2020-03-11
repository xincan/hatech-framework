package cn.com.hatechframework.config.oauth;

import cn.com.hatechframework.data.config.redis.RedisTemplateOperator;
import cn.com.hatechframework.utils.context.BaseContextHandler;
import cn.com.hatechframework.utils.statics.DataKeyPrefix;
import cn.com.hatechframework.utils.token.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.oauth
 * @className UserAuthTenantRestInterceptor
 * @description 租户header token 拦截器
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         租户header token 拦截器
 */
@Slf4j
@Component
public class UserAuthTenantRestInterceptor extends HandlerInterceptorAdapter {

    private static final String BEARER = "Bearer ";
    private final RedisTemplateOperator redisTemplateOperator;

    public UserAuthTenantRestInterceptor(RedisTemplateOperator redisTemplateOperator) {
        this.redisTemplateOperator = redisTemplateOperator;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(authorization) && authorization.startsWith(BEARER)){
            String jwt = authorization.substring(7);
            BaseContextHandler.setUserId(TokenUtils.getUserId(jwt));
            BaseContextHandler.setUserName(TokenUtils.getUserName(jwt));
            BaseContextHandler.setTenantName(TokenUtils.getTenant(jwt));
            BaseContextHandler.setToken(jwt);
            BaseContextHandler.setUser(redisTemplateOperator.get(DataKeyPrefix.LOGIN_USER_TOKEN_PREFIX+jwt));
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }

}
