package cn.com.hatechframework.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.exception
 * @className OAuthResponseExceptionTranslator
 * @description 自定义oauth server异常返回
 * @author YeMeng
 * @create 2019/12/25 17:54
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/25 17:54             1.0                         自定义oauth server异常返回
 */
@Slf4j
public class OAuthResponseExceptionTranslator implements WebResponseExceptionTranslator {

    /**
     *  异常信息转换
     * @param e  异常
     * @author YeMeng
     * @date 2019/12/25 19:15
     * @return org.springframework.http.ResponseEntity<org.springframework.security.oauth2.common.exceptions.OAuth2Exception>
     */
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        log.error("oauth认证失败 {}", e.getMessage());
        throw e;
    }
}
