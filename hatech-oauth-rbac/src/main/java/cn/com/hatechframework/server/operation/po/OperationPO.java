package cn.com.hatechframework.server.operation.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;


/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.operation.po
 * @className OperationPO
 * @description 操作按钮PO
 * @author WangMingShuai
 * @create 2020/01/15 17:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 17:36             1.0                         操作按钮PO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "operation")
public class OperationPO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 操作ID
	 */
	@TableId(type = IdType.UUID)
	@TableField("id")
	private String id;

	/**
	 * 按钮名称
	 */
	@TableField("operation_name")
	private String operationName;

	/**
	 * 按钮描述
	 */
	@TableField("description")
	private String description;

	/**
	 * 按钮编码（用于前端触发按钮调用函数名称）
	 */
	@TableField("code")
	private String code;

	/**
	 * 按钮图标
	 */
	@TableField("icon")
	private String icon;

	/**
	 * 按钮类型
	 */
	@TableField("type")
	private String type;

	/**
	 * 按钮顺序
	 */
	@TableField("order_info")
	private Integer orderInfo;

	@TableField("edit_user_id")
	private String editUserId;

	@TableField(value = "edit_time", fill = FieldFill.UPDATE)
	private Date editTime;


}
