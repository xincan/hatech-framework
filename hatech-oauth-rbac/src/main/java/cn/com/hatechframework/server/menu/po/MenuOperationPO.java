package cn.com.hatechframework.server.menu.po;

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
 * @package cn.com.hatechframework.server.menu.po
 * @className MenuOperationPO
 * @description 菜单操作关系表PO
 * @author WangMingShuai
 * @create 2020/01/15 16:20
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 16:20             1.0                         菜单操作关系表PO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "menu_operation")
public class MenuOperationPO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 资源ID
	 */
	@TableId(type = IdType.UUID)
	@TableField("id")
	private String id;

	/**
	 * 菜单ID
	 */
	@TableField("menu_id")
	private String menuId;

	/**
	 * 操作ID
	 */
	@TableField("operation_id")
	private String operationId;
}
