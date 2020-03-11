package cn.com.hatechframework.server.tenant.po;

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
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.tenant.po
 * @className TenantPO
 * @description 租户实体类
 * @author YeMeng
 * @create 2019/12/18 18:42
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/18 18:42             1.0                        租户实体类
 */
@Data
@TableName("tenant")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantPO implements Serializable {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("tenant_name")
    private String tenantName;

}
