package cn.com.hatechframework.config.seata;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.seata
 * @className SeataGlobalTransactionalFilter
 * @description 绑定seata通过feign传来的全局事务xid,feign 端可以不用写@GlobalTransactional 注解
 * @author WangMingShuai
 * @create 2020/1/4 12:58
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/4 12:58             1.0                         绑定seata通过feign传来的全局事务xid,feign 端可以不用写@GlobalTransactional 注解
 */
@Component
@Slf4j
public class SeataGlobalTransactionalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String xid = req.getHeader(RootContext.KEY_XID.toLowerCase());
        boolean isBind = false;
        if (!StringUtils.isEmpty(xid)) {
            log.info("{} : {}","绑定seata事务id",xid);
            RootContext.bind(xid);
            isBind = true;
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            if (isBind) {
                RootContext.unbind();
            }
        }
    }
}
