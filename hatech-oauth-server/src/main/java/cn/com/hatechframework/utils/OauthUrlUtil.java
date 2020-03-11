package cn.com.hatechframework.utils;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils
 * @className UrlUtils
 * @description 处理url工具类
 * @author YeMeng
 * @create 2019/12/23 16:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:59             1.0                         处理url工具类
 */
public class OauthUrlUtil {

    private OauthUrlUtil(){}

    /**
     *  拼接url
     * @param base  url
     * @param query  param参数
     * @param fragment  是否是
     * @author YeMeng
     * @date 2019/12/24 19:53
     * @return java.lang.String
     */
    public static String append(String base, Map<String, ?> query, boolean fragment) {
        return append(base, query, null, fragment);
    }

    /**
     *  拼接url
     * @param base  url
     * @param query  param参数
     * @param keys  自定义需要转换的参数key
     * @param fragment 是否是&拼接的形式
     * @author YeMeng
     * @date 2019/12/24 19:56
     * @return java.lang.String
     */
    public static String append(String base, Map<String, ?> query, Map<String, String> keys, boolean fragment) {
        UriComponentsBuilder template = UriComponentsBuilder.newInstance();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(base);
        URI redirectUri;
        try {
            redirectUri = builder.build(true).toUri();
        }
        catch (Exception e) {
            redirectUri = builder.build().toUri();
            builder = UriComponentsBuilder.fromUri(redirectUri);
        }
        template.scheme(redirectUri.getScheme()).port(redirectUri.getPort()).host(redirectUri.getHost())
                .userInfo(redirectUri.getUserInfo()).path(redirectUri.getPath());
        if (fragment) {
            builder = getFragmentBuilder(builder, redirectUri, template, query, keys);
        }
        else {
            for (String key : query.keySet()) {
                String name = key;
                if (keys != null && keys.containsKey(key)) {
                    name = keys.get(key);
                }
                template.queryParam(name, "{" + key + "}");
            }
            template.fragment(redirectUri.getFragment());
            UriComponents encoded = template.build().expand(query).encode();
            builder.query(encoded.getQuery());
        }

        return builder.build().toUriString();
    }

    /**
     *  类型为fragment的uri builder
     * @param builder  uri builder
     * @param redirectUri  跳转地址
     * @param template  uri builder 模板
     * @param query  param参数
     * @param keys  自定义需要转换的参数key
     * @author YeMeng
     * @date 2020/1/2 14:43
     * @return org.springframework.web.util.UriComponentsBuilder
     */
    public static UriComponentsBuilder getFragmentBuilder(UriComponentsBuilder builder, URI redirectUri, UriComponentsBuilder template, Map<String, ?> query, Map<String, String> keys) {
        StringBuilder values = new StringBuilder();
        if (redirectUri.getFragment() != null) {
            String append = redirectUri.getFragment();
            values.append(append);
        }
        for (String key : query.keySet()) {
            if (values.length() > 0) {
                values.append("&");
            }
            String name = key;
            if (keys != null && keys.containsKey(key)) {
                name = keys.get(key);
            }
            values.append(name + "={" + key + "}");
        }
        if (values.length() > 0) {
            template.fragment(values.toString());
        }
        UriComponents encoded = template.build().expand(query).encode();
        return builder.fragment(encoded.getFragment());
    }
}
