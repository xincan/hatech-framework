package cn.com.hatechframework.utils.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.context
 * @className BaseContextHandler
 * @description 用户信息localthread存储类
 * @author YeMeng
 * @create 2019/12/26 15:25
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/26 15:25             1.0                         用户信息localthread存储类
 */
public class BaseContextHandler {

    private BaseContextHandler(){}

    /**
     * 当前用户
     */
    public static final String CONTEXT_KEY_USER = "currentUser";

    /**
     * 当前用户id
     */
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";

    /**
     * 当前用户名
     */
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";

    /**
     * 当前租户名
     */
    public static final String CONTEXT_KEY_TENANT_NAME = "currentTenantName";

    /**
     * 当前租户token
     */
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";

    /**
     * 线程存储对象
     */
    public static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * @description 设置键值对
     * @param key  键
     * @param value  值
     * @author YeMeng
     * @date 2020/1/8 17:29
     * @return void
     */
    public static void set(String key, Object value) {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(8);
            THREAD_LOCAL.set(map);
        }
        map.put(key, value);
    }

    /**
     * @description 获取值
     * @param key  键
     * @author YeMeng
     * @date 2020/1/8 17:31
     * @return java.lang.Object
     */
    public static Object get(String key){
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(8);
            THREAD_LOCAL.set(map);
        }
        return map.get(key);
    }

    /**
     * @description 获取用户id
     * @author YeMeng
     * @date 2020/1/8 17:31
     * @return java.lang.String
     */
    public static String getUserId(){
        Object value = get(CONTEXT_KEY_USER_ID);
        return getObjectValue(value);
    }

    /**
     * @description 获取用户名
     * @author YeMeng
     * @date 2020/1/8 17:31
     * @return java.lang.String
     */
    public static String getUserName(){
        Object value = get(CONTEXT_KEY_USERNAME);
        return getObjectValue(value);
    }

    /**
     * @description 获取租户名
     * @author YeMeng
     * @date 2020/1/8 17:32
     * @return java.lang.String
     */
    public static String getTenantName(){
        Object value = get(CONTEXT_KEY_TENANT_NAME);
        return getObjectValue(value);
    }

    /**
     * @description 获取token
     * @author YeMeng
     * @date 2020/1/8 17:32
     * @return java.lang.String
     */
    public static String getToken(){
        Object value = get(CONTEXT_KEY_USER_TOKEN);
        return getObjectValue(value);
    }

    /**
     * @description 获取登录用户
     * @author YeMeng
     * @date 2020/1/8 17:32
     * @return java.lang.Object
     */
    public static Object getUser(){
        return get(CONTEXT_KEY_USER);
    }

    /**
     * @description 获取string类型object
     * @param obj
     * @author YeMeng
     * @date 2020/1/8 17:33
     * @return java.lang.String
     */
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }

    /**
     * @description 设置token
     * @param token  token值
     * @author YeMeng
     * @date 2020/1/8 17:36
     * @return void
     */
    public static void setToken(String token){
        set(CONTEXT_KEY_USER_TOKEN,token);
    }

    /**
     * @description 设置用户id
     * @param userId  用户id
     * @author YeMeng
     * @date 2020/1/8 17:39
     * @return void
     */
    public static void setUserId(String userId){
        set(CONTEXT_KEY_USER_ID,userId);
    }

    /**
     * @description 设置用户详情
     * @param user  用户详情
     * @author YeMeng
     * @date 2020/1/8 17:41
     * @return void
     */
    public static void setUser(Object user){
        set(CONTEXT_KEY_USER,user);
    }

    /**
     * @description 设置用户名
     * @param userName  用户名
     * @author YeMeng
     * @date 2020/1/8 17:42
     * @return void
     */
    public static void setUserName(String userName){
        set(CONTEXT_KEY_USERNAME,userName);
    }

    /**
     * @description 设置租户名
     * @param tenantName 租户名
     * @author YeMeng
     * @date 2020/1/8 17:46
     * @return void
     */
    public static void setTenantName(String tenantName){
        set(CONTEXT_KEY_TENANT_NAME,tenantName);
    }

    /**
     * @description 删除线程保存内容
     * @author YeMeng
     * @date 2020/1/8 17:52
     * @return void
     */
    public static void remove(){
        THREAD_LOCAL.remove();
    }

}
