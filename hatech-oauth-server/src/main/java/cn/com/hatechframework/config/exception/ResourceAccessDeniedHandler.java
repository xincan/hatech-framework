package cn.com.hatechframework.config.exception;

import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.exception
 * @className ResourceAccessDeniedHandler
 * @description oauth资源访问请求未授权
 * @author YeMeng
 * @create 2019/12/25 18:12
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 18:12             1.0                         禁止资源访问
 */
@Slf4j
public class ResourceAccessDeniedHandler implements AccessDeniedHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     *  异常处理
     * @param request  请求
     * @param response  回复
     * @param e  异常
     * @author YeMeng
     * @date 2019/12/25 19:27
     * @return void
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        log.error("禁止访问 {}", e.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        OBJECT_MAPPER.writeValue(response.getOutputStream(),
                ResponseResult.error(ResponseCode.UNAUTHORIZED, ResponseCode.UNAUTHORIZED.message()));
    }

}
