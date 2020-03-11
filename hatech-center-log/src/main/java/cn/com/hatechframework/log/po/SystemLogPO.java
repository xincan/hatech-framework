package cn.com.hatechframework.log.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.log.po
 * @className SystemLogPO
 * @description 系统日志视图实体类（数据库）
 * @author JiangXincan
 * @create 2019/12/18 13:35
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 13:35             1.0                         系统日志视图实体类(数据库)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "system_log")
public class SystemLogPO {

    @TableId(type = IdType.UUID)
    @TableField("id")
    private String id;

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "tenant_id")
    private String tenantId;

    @TableField(value = "company")
    private String company;

    @TableField(value = "department")
    private String department;

    @TableField(value = "ip")
    private String ip;

    @TableField(value = "port")
    private Integer port;

    @TableField(value = "micro_service")
    private String microService;

    @TableField(value = "class_url")
    private String classUrl;

    @TableField(value = "class_param")
    private String classParam;

    @TableField(value = "type")
    private String type;

    @TableField(value = "business_type")
    private String businessType;

    @TableField(value = "model")
    private String model;

    @TableField(value = "description")
    private String description;

    @TableField(value = "edit_time", fill = FieldFill.UPDATE)
    private Date editTime;
}
