package cn.com.hatechframework.server.user.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.vo
 * @className UserPO
 * @description 用户实体类PO
 * @author WangMingShuai
 * @create 2019/12/19 16:29
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/19 16:29             1.0                         用户实体类PO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class UserPO {

    @TableId(type = IdType.UUID)
    @TableField("id")
    private String id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("name")
    private String name;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("is_admin")
    private Boolean isAdmin;

    @TableField("status")
    private Integer status;

    @TableField("is_tenant")
    private Boolean isTenant;

    @TableField("company")
    private String company;

    @TableField("code")
    private String code;

    @TableField("area_id")
    private String areaId;

    @TableField("organization_id")
    private String organizationId;

    @TableField("edit_user_id")
    private String editUserId;

    @TableField(value = "edit_time")
    private Date editTime;

    @TableField(exist = false)
    private List<String> roleIds;

    @TableField(exist = false)
    private List<String> roleGroupIds;

}
