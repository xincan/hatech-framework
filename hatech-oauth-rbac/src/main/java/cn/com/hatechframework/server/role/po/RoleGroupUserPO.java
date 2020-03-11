package cn.com.hatechframework.server.role.po;

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
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.po
 * @className RoleGroupUserPO
 * @description 角色组-用户关系表PO
 * @author WangMingShuai
 * @create 2020/01/18 14:16
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/18 14:16             1.0                         角色组-用户关系表PO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "role_group_user")
public class RoleGroupUserPO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(type = IdType.UUID)
	@TableField("id")
	private String id;

	/**
	 * 角色组ID
	 */
	@TableField("role_group_id")
	private String roleGroupId;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private String userId;


}
