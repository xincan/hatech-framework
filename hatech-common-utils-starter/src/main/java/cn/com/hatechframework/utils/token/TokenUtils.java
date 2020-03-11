package cn.com.hatechframework.utils.token;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultHeader;
import io.jsonwebtoken.impl.DefaultJwsHeader;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import io.jsonwebtoken.lang.Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils
 * @className TokenUtils
 * @description 处理token工具类
 * @author YeMeng
 * @create 2019/12/23 16:59
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/23 16:59             1.0                        处理token工具类
 */
public class TokenUtils {

    /**
     * token 分隔符
      */
    private static final char SEPARATOR_CHAR = '.';

    /**
     * 分隔符个数
     */
    private static final int DELIMITER_COUNT = 2;

    /**
     * jwt token header部分
     */
    private static final String BASE64_URL_ENCODED_HEADER = "base64UrlEncodedHeader";

    /**
     * jwt token 内容部分
     */
    private static final String BASE64_URL_ENCODED_PAYLOAD = "base64UrlEncodedPayload";

    /**
     * jwt token 加密部分
     */
    private static final String BASE64_URL_ENCODED_DIGEST = "base64UrlEncodedDigest";

    private TokenUtils(){}

    /**
     * @description 按分隔符分隔token
     * @param jwt  jwt token
     * @author YeMeng
     * @date 2020/1/8 20:31
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    private static Map<String, String> splitToken(String jwt) {
        Map<String, String> res = new HashMap<>(3);
        // token头部
        String base64UrlEncodedHeader = null;
        // token payload
        String base64UrlEncodedPayload = null;
        // token 加密部分
        String base64UrlEncodedDigest = null;

        int delimiterCount = 0;
        StringBuilder sb = new StringBuilder(128);
        // 按分隔符分隔token
        for (char c : jwt.toCharArray()) {
            if (c == SEPARATOR_CHAR) {
                CharSequence tokenSeq = Strings.clean(sb);
                String token = tokenSeq!=null?tokenSeq.toString():null;
                if (delimiterCount == 0) {
                    base64UrlEncodedHeader = token;
                } else if (delimiterCount == 1) {
                    base64UrlEncodedPayload = token;
                }
                delimiterCount++;
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        if (delimiterCount != DELIMITER_COUNT) {
            String msg = "JWT格式错误";
            throw new MalformedJwtException(msg);
        }
        if (sb.length() > 0) {
            base64UrlEncodedDigest = sb.toString();
        }
        if (base64UrlEncodedPayload == null) {
            throw new MalformedJwtException("JWT '" + jwt + "' 缺失body/payload部分");
        }
        res.put(BASE64_URL_ENCODED_HEADER, base64UrlEncodedHeader);
        res.put(BASE64_URL_ENCODED_PAYLOAD, base64UrlEncodedPayload);
        res.put(BASE64_URL_ENCODED_DIGEST, base64UrlEncodedDigest);
        return res;
    }

    /**
     * @description 根据签名解析token
     * @param jwt token
     * @author YeMeng
     * @date 2019/12/24 19:48
     * @return io.jsonwebtoken.Claims
     */
    @SuppressWarnings("unchecked")
    public static Claims decodeToken(String jwt) {
        Claims claims = new DefaultClaims();
        if (jwt == null || "".equals(jwt)) {
            return claims ;
        }
        Map<String, String> encodeToken = splitToken(jwt);
        // token头部
        String base64UrlEncodedHeader = encodeToken.get(BASE64_URL_ENCODED_HEADER);
        // token payload
        String base64UrlEncodedPayload = encodeToken.get(BASE64_URL_ENCODED_PAYLOAD);
        // token 加密部分
        String base64UrlEncodedDigest = encodeToken.get(BASE64_URL_ENCODED_DIGEST);

        // =============== 解析Header部分 =================
        Header header = null;
        CompressionCodec compressionCodec = null;

        if (base64UrlEncodedHeader != null) {
            String origValue = TextCodec.BASE64URL.decodeToString(base64UrlEncodedHeader);
            Map<String, Object> m = JSON.parseObject(origValue, Map.class);

            if (base64UrlEncodedDigest != null) {
                header = new DefaultJwsHeader(m);
            } else {
                header = new DefaultHeader(m);
            }
            compressionCodec = (new DefaultCompressionCodecResolver()).resolveCompressionCodec(header);
        }

        // =============== 解析Body部分 =================
        String payload;
        if (compressionCodec != null) {
            byte[] decompressed = compressionCodec.decompress(TextCodec.BASE64URL.decode(base64UrlEncodedPayload));
            payload = new String(decompressed, Strings.UTF_8);
        } else {
            payload = TextCodec.BASE64URL.decodeToString(base64UrlEncodedPayload);
        }
        if (payload.charAt(0) == '{' && payload.charAt(payload.length() - 1) == '}') {
            Map<String, Object> claimsMap = JSON.parseObject(payload, Map.class);
            claims = new DefaultClaims(claimsMap);
        }
        return claims;
    }

    /**
     * @description 获取client id
     * @param jwt token
     * @author YeMeng
     * @date 2019/12/26 15:58
     * @return java.lang.String
     */
    public static String getClientId(String jwt) {
        Claims claims = decodeToken(jwt);
        return claims.get("client_id", String.class);
    }

    /**
     * @description 获取username
     * @param jwt token
     * @author YeMeng
     * @date 2019/12/26 15:58
     * @return java.lang.String
     */
    public static String getUserName(String jwt) {
        Claims claims = decodeToken(jwt);
        return claims.get("user_name", String.class);
    }

    /**
     * @description 获取userid
     * @param jwt token
     * @author YeMeng
     * @date 2019/12/26 15:58
     * @return java.lang.String
     */
    public static String getUserId(String jwt) {
        Claims claims = decodeToken(jwt);
        return claims.get("user_id", String.class);
    }

    /**
     * @description 获取tenant id
     * @param jwt token
     * @author YeMeng
     * @date 2019/12/26 15:58
     * @return java.lang.String
     */
    @SuppressWarnings("unchecked")
    public static String getTenant(String jwt) {
        Claims claims = decodeToken(jwt);
        List<String> tenants = claims.get("tenant", List.class);
        return String.join(",", tenants);
    }

}
