package cn.com.hatechframework.server.organization.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.organization.po
 * @className OrganizationPO
 * @description 机构信息PO
 * @author WangMingShuai
 * @create 2019/12/27 19:15
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 19:15             1.0                         机构信息PO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "organization")
public class OrganizationPO {

    @TableId(type = IdType.UUID)
    @TableField("id")
    private String id;

    @TableField("name")
    private String name;

    @TableField("parent_id")
    private String parentId;

    @TableField("status")
    private Integer status;

    @TableField("order_info")
    private Integer orderInfo;

    @TableField("description")
    private String description;

    @TableField("edit_user_id")
    private String editUserId;

    @TableField(value = "edit_time", fill = FieldFill.UPDATE)
    private Date editTime;
}
