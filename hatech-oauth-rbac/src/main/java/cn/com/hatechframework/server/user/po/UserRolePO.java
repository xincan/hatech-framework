package cn.com.hatechframework.server.user.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.po
 * @className UserRolePO
 * @description 用户-角色关系表
 * @author YeMeng
 * @create 2020/1/17 17:47
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2020/1/17 17:47             1.0                         用户-角色关系表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user_role")
public class UserRolePO {

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @TableField("user_id")
    private String userId;

    @TableField("role_id")
    private String roleId;
}
