package cn.com.hatechframework.utils.statics;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.statics
 * @className DataSourceEnableType
 * @description 数据源在用状态
 * @author YeMeng
 * @create 2020/1/6 13:38
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2020/1/6 13:38             1.0                         数据源在用状态
 */
public enum DataSourceEnableType {
    /**
     * 启用
     */
    ENABLED("1"),

    /**
     * 禁用
     */
    DISABLED("0");

    private String value;

    DataSourceEnableType(String value) {
        this.value = value;
    }

    /**
     * @description 获取数据源类型值
     * @author YeMeng
     * @date 2020/1/8 19:47
     * @return java.lang.String
     */
    public String getValue() {
        return value;
    }
}
