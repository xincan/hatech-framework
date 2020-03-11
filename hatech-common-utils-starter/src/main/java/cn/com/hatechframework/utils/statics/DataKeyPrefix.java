package cn.com.hatechframework.utils.statics;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.statics
 * @className DataKeyPrefix
 * @description 数据键前缀
 * @author WangMingShuai
 * @create 2019/12/28 14:49
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/28 14:49             1.0                         数据键前缀
 */
public class DataKeyPrefix {

    /**
     * 租户数据源前缀
     */
    public static final String TENANT_DATASOURCE_PREFIX = "tenant_";

    /**
     * 登录用户前缀
     */
    public static final String LOGIN_USER_TOKEN_PREFIX = "login_user_";

    /**
     * token类型前缀
     */
    public static final String TOKEN_TYPE_PREFIX = "Bearer ";

    /**
     * 启用该用户
     */
    public static final int USER_ENABLED = 1;


    private DataKeyPrefix(){}

}
