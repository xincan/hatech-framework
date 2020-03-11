package cn.com.hatechframework.validator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @ProjectName: xincan-transaction
 * @package cn.com.hatechframework.validator
 * @className ValidatorUtils
 * @author wangmingshuai
 * @description description
 * @date 2019/12/17 18:25
 * @version 1.0
 */
public class ValidatorUtils {

    private ValidatorUtils() {}

    /**
     * 正则表达式:验证用户名(不包含中文和特殊字符)如果用户名使用手机号码或邮箱 则结合手机号验证和邮箱验证
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 正则表达式:验证密码(不包含特殊字符)
     */
    public static final String REGEX_SECRET_CODE  = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式:验证手机号
     */
    public static final String REGEX_MOBILE = "^1[345789]\\d{9}$";

    /**
     * 正则表达式:验证邮箱
     */
    public static final String REGEX_EMAIL = "^(\\w-*\\.*)+@(\\w-?)+(\\.\\w{2,})+$";

    /**
     * 正则表达式:验证汉字(1-9个汉字)  {1,9} 自定义区间
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5]{1,9}$";

    /**
     * 正则表达式:验证身份证
     */
    public static final String REGEX_ID_CARD = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";

    /**
     * 正则表达式:验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式:验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";

    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUserName(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_SECRET_CODE, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIdCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddress
     * @return
     */
    public static boolean isIpAddress(String ipAddress) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddress);
    }

    /**
     * 校验Json字符串
     * @param json
     * @return
     */
    public static boolean isJsonString(String json) {
        if (StringUtils.isEmpty(json)) {
            return false;
        }
        try {
            JSON.parseObject(json);
        } catch (JSONException ex) {
            try {
                JSON.parseArray(json);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}
