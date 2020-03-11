package cn.com.hatechframework.server.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.po
 * @className TenantPO
 * @description 租户实体类
 * @author YeMeng
 * @create 2019/12/18 18:42
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 18:42             1.0                        租户实体类
 */
@Data
@TableName("tenant")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantPO implements Serializable {

    /**
     * 此处使用snowflake分布式主键算法
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("tenant_name")
    private String tenantName;

}
