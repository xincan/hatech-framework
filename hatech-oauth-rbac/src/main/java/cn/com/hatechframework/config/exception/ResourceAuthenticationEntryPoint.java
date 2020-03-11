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
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.exception
 * @className ResourceAuthenticationEntryPoint
 * @description 资源认证异常
 * @author YeMeng
 * @create 2019/12/25 18:09
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/25 18:09             1.0                         资源认证异常
 */
@Slf4j
public class ResourceAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final String ACCESS_TOKEN_EXPIRED = "Access token expired";
    private static final String CANNOT_CONVERT_JSON = "Cannot convert access token to JSON";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    /**
     * 异常处理
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
        if (e != null) {
            log.error(e.getMessage());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            // token 超时
            if (e.getMessage().contains(ACCESS_TOKEN_EXPIRED)) {
                OBJECT_MAPPER.writeValue(response.getOutputStream(),
                        ResponseResult.error(ResponseCode.UNAUTHORIZED_TOKEN, ResponseCode.UNAUTHORIZED_TOKEN.message()));
            }
            // token 转换JSON失败
            else if (e.getMessage().contains(CANNOT_CONVERT_JSON)) {
                OBJECT_MAPPER.writeValue(response.getOutputStream(),
                        ResponseResult.error(ResponseCode.INCORRECT_TOKEN_JSON, ResponseCode.INCORRECT_TOKEN_JSON.message()));
            }
            else {
                OBJECT_MAPPER.writeValue(response.getOutputStream(),
                        ResponseResult.error(ResponseCode.UNAUTHORIZED, ResponseCode.UNAUTHORIZED.message()));
            }
        }
    }
}
