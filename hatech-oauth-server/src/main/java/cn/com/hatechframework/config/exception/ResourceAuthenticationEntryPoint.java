package cn.com.hatechframework.config.exception;

import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.exception
 * @className ResourceAuthenticationEntryPoint
 * @description 资源认证异常
 * @author YeMeng
 * @create 2019/12/25 18:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 18:09             1.0                         资源认证异常
 */
@Slf4j
public class ResourceAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * jackson mapper
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * token 超时
     */
    private static final String ACCESS_TOKEN_EXPIRED = "Access token expired";

    /**
     * token 转换JSON失败
     */
    private static final String CONVERT_ACCESS_FAILED = "Cannot convert access token to JSON";

    /**
     *  异常处理
     * @param request  请求
     * @param response  回复
     * @param e  异常
     * @author YeMeng
     * @date 2019/12/25 19:26
     * @return void
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e)
            throws IOException, ServletException {
        log.error("认证失败 {}", e.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // token 超时
        if (e.getMessage().contains(ACCESS_TOKEN_EXPIRED)) {
            OBJECT_MAPPER.writeValue(response.getOutputStream(),
                    ResponseResult.error(ResponseCode.UNAUTHORIZED_TOKEN, ResponseCode.UNAUTHORIZED_TOKEN.message()));
        }
        // token 转换JSON失败
        else if (e.getMessage().contains(CONVERT_ACCESS_FAILED)) {
            OBJECT_MAPPER.writeValue(response.getOutputStream(),
                    ResponseResult.error(ResponseCode.INCORRECT_TOKEN_JSON, ResponseCode.INCORRECT_TOKEN_JSON.message()));
        }
        else {
            OBJECT_MAPPER.writeValue(response.getOutputStream(),
                    ResponseResult.error(ResponseCode.UNAUTHORIZED, ResponseCode.UNAUTHORIZED.message()));
        }
    }
}
