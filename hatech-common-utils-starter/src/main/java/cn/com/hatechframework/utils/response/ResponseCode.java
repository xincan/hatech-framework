package cn.com.hatechframework.utils.response;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.response
 * @className ResponseCode
 * @description 响应状态枚举类
 * @author JiangXincan
 * @create 2019/12/18 9:43
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 9:43             1.0                         响应状态枚举类
 * YeMeng              2019/12/20 9:38             1.0                         Http状态码
 */
public enum ResponseCode {

    /**
     * 请求成功
     */
    REQUEST_SUCCESS(200, "请求成功"),

    /**
     * 请求失败
     */
    REQUEST_ERROR(201, "请求失败"),

    /**
     * 请求失败
     */
    REQUEST_FORBIDDEN(202, "请求拒绝"),

    /**
     * 请求失败
     */
    REQUEST_NOT_FOUND(203, "请求未找到"),

    /**
     * 请求失败
     */
    REQUEST_BAD(204, "错误的请求"),

    /**
     * 请求失败
     */
    REQUEST_TIMEOUT(205, "请求超时"),


    /**
     * 请求失败
     */
    UNAUTHORIZED(401, "未授权"),

    /**
     * 请求失败
     */
    UNAUTHORIZED_TOKEN(402, "TOKEN超时"),

    /**
     * 请求失败
     */
    FORBIDDEN(403, "拒绝访问"),

    /**
     * 请求失败
     */
    NOT_FOUND(404, "无法找到这个资源"),

    /**
     * 请求失败
     */
    METHOD_NOT_ALLOWED(405, "请换个姿势操作试试"),

    /**
     * 请求失败
     */
    UNSUPPORTED_MEDIA_TYPE(415, "请求不支持该媒体类型"),


    /**
     * 请求失败
     */
    EXCEPTION(500, "服务器内部错误"),

    /**
     * 请求失败
     */
    PARAM_ERROR(502, "参数错误"),

    /**
     * 请求失败
     */
    BUSINESS_ERROR(503, "业务异常"),

    /**
     * 请求失败
     */
    RPC_ERROR(504, "网络出问题"),


    /**
     * 请求失败
     */
    INVALID_REQUEST(600, "无效的请求"),

    /**
     * 请求失败
     */
    UNAUTHORIZED_CLIENT(601, "客户端未认证"),

    /**
     * 请求失败
     */
    INVALID_CLIENT(602, "无效的客户端"),

    /**
     * 请求失败
     */
    INVALID_GRANT(603, "无效的授权"),

    /**
     * 请求失败
     */
    UNSUPPORTED_GRANT_TYPE(604, "不支持的授权类型"),

    /**
     * 请求失败
     */
    USER_NOT_EXIST(605, "用户不存在"),

    /**
     * 请求失败
     */
    INCORRECT_CLIENT_PASSWORD(606, "客户端密码错误"),

    /**
     * 请求失败
     */
    INCORRECT_USER_PASSWORD(607, "用户密码错误"),

    /**
     * 请求失败
     */
    INVALID_SCOPE(608, "scope范围错误"),

    /**
     * 请求失败
     */
    INVALID_TOKEN(609, "无效的token"),

    /**
     * 请求失败
     */
    INVALID_AUTHORIZATION_CODE(610, "无效的校验码"),

    /**
     * 请求失败
     */
    REDIRECT_MISMATCH(611, "跳转链接不匹配"),

    /**
     * 请求失败
     */
    INCORRECT_TOKEN_JSON(612, "token不是JSON格式"),

    /**
     * 请求失败
     */
    INVALID_CLIENT_TOKEN(613, "客户端client和refresh_token不匹配"),

    /**
     * 请求失败
     */
    INVALID_REFRESH_TOKEN(614, "无效的refresh token"),

    /**
     * 用户被停用
     */
    USER_UNUSED(615, "用户被停用"),

    /**
     * 文件不存在
     */
    FILE_NOT_EXIST(701, "文件不存在"),

    /**
     * 文件类型错误
     */
    FILE_TYPE_INVALID(702, "文件类型错误");

    /**
     * 状态码
      */
    private final Integer code;

    /**
     * 状态解释
     */
    private final String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @description 返回状态码的数值
     * @author YeMeng
     * @date 2020/1/8 19:45
     * @return int类型状态码
     */
    public int code() {
        return this.code;
    }

    /**
     * @description 返回状态码的解释
     * @author YeMeng
     * @date 2020/1/8 19:45
     * @return java.lang.String 状态解释
     */
    public String message() {
        return this.message;
    }

}
