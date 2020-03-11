package cn.com.hatechframework.config.filter;

import cn.com.hatechframework.data.config.redis.RedisTemplateOperator;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseResult;
import cn.com.hatechframework.utils.statics.DataKeyPrefix;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.filter
 * @className TokenFilterConfig
 * @description token过滤配置
 * @author YeMeng
 * @create 2019/12/30 14:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/30 14:59             1.0                         token过滤配置
 */
@Component
@Slf4j
public class TokenFilterConfig implements WebFilter {

    private final RedisTemplateOperator redisTemplateOperator;

    /**
     * 匹配请求路径
     */
    private ServerWebExchangeMatcher requiresAuthenticationMatcher = ServerWebExchangeMatchers.anyExchange();

    public TokenFilterConfig(RedisTemplateOperator redisTemplateOperator) {
        this.redisTemplateOperator = redisTemplateOperator;
    }


    /**
     * token 过滤设置
     * @param serverWebExchange  web请求
     * @param webFilterChain  过滤链
     * @author YeMeng
     * @date 2020/2/10 15:14
     * @return reactor.core.publisher.Mono<java.lang.Void>
     */
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        return this.requiresAuthenticationMatcher.matches(serverWebExchange)
                .filter(ServerWebExchangeMatcher.MatchResult::isMatch)
                .switchIfEmpty(webFilterChain.filter(serverWebExchange).then(Mono.empty()))
                .flatMap(matchResult ->
                    // 校验请求中header中参数值
                    verifyRequestHeaderValue(serverWebExchange, webFilterChain)
                );
    }

    /**
     * 校验请求中传入的header中参数值
     * @param serverWebExchange  web请求
     * @param webFilterChain  过滤链
     * @author YeMeng
     * @date 2020/2/10 15:14
     * @return reactor.core.publisher.Mono<java.lang.Void>
     */
    private Mono<Void> verifyRequestHeaderValue(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        final ServerHttpRequest request = serverWebExchange.getRequest();
        final HttpHeaders headers = request.getHeaders();
        // 含有token的请求
        if (!ObjectUtils.isEmpty(headers.get(HttpHeaders.AUTHORIZATION))) {
            List<String> tokenList = headers.get(HttpHeaders.AUTHORIZATION);
            // 校验header中的参数值
            if (!ObjectUtils.isEmpty(tokenList) && !verify(request, HttpHeaders.AUTHORIZATION, tokenList.get(0))) {
                // 校验失败
                return writeError(serverWebExchange);
            }
        }
        return webFilterChain.filter(serverWebExchange);
    }

    /**
     * 校验
     * @param request  请求
     * @param key  请求中的key
     * @param value  请求中key对应的value
     * @author YeMeng
     * @date 2019/12/30 16:45
     * @return boolean
     */
    public boolean verify(ServerHttpRequest request, String key, String value) {
        // 过滤无效的token
        return StringUtils.isEmpty(value) || !value.contains(DataKeyPrefix.TOKEN_TYPE_PREFIX) ||
                redisTemplateOperator.hasKey(
                        DataKeyPrefix.LOGIN_USER_TOKEN_PREFIX
                                + value.replace(DataKeyPrefix.TOKEN_TYPE_PREFIX, ""));
    }

    /**
     * 返回自定义错误结果
     * @param serverWebExchange  错误信息
     * @author YeMeng
     * @date 2019/12/30 16:45
     * @return reactor.core.publisher.Mono<java.lang.Void>
     */
    private Mono<Void> writeError(ServerWebExchange serverWebExchange) {
        ServerHttpResponse response = serverWebExchange.getResponse();
        response.setStatusCode(HttpStatus.FORBIDDEN);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeWith(
                Mono.just(response.bufferFactory().wrap(
                        JSON.toJSONBytes(ResponseResult.error(ResponseCode.INVALID_TOKEN))
                        )
                )
        );
    }

}
