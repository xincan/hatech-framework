package cn.com.hatechframework.server.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.po
 * @className TenantDatasourcePO
 * @description 租户数据源实体类
 * @author YeMeng
 * @create 2019/12/27 13:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/27 13:09             1.0                         租户数据源实体类
 */
@Slf4j
@Data
@TableName("tenant_datasource")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantDataSourcePO {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("tenant_name")
    private String tenantName;

    @TableField("datasource_url")
    private String dataSourceUrl;

    @TableField("datasource_username")
    private String dataSourceUsername;

    @TableField("datasource_password")
    private String dataSourcePassword;

    @TableField("datasource_driver")
    private String dataSourceDriver;

    @TableField("datasource_type")
    private String dataSourceType;

    @TableField("enabled")
    private String enabled;

    /**
     * 提取TenantDatasource实体属性, 转变为datasource属性
     * @return
     */
    public Map<String, Object> toDataSourceProp() {
        Map<String, Object> map = new HashMap<>(5);
        map.put("type", dataSourceType);
        map.put("driver-class-name", dataSourceDriver);
        map.put("url", dataSourceUrl);
        map.put("username", dataSourceUsername);
        map.put("password", dataSourcePassword);
        return map;
    }
}
