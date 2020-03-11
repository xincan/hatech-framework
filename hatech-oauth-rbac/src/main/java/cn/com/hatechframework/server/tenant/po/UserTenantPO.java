package cn.com.hatechframework.server.tenant.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.tenant.po
 * @className UserTenantPO
 * @description 用户与租户关系表
 * @author YeMeng
 * @create 2019/12/28 14:07
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/28 14:07             1.0                         用户与租户关系表
 */
@Data
@TableName("tenant_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTenantPO {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "tenant_id")
    private String tenantId;

}
