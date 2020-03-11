package cn.com.hatechframework.server.operation.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;



/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.operation.dto
 * @className OperationInsertDTO
 * @description 新增操作按钮DTO
 * @author WangMingShuai
 * @create 2020/01/15 17:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 17:36             1.0                         新增操作按钮DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.operation.dto.OperationInsertDTO", description = "新增操作按钮DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationInsertDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="按钮名称", dataType = "String", required = true, example = "测试按钮名称")
	@NotBlank(message = "按钮名称不能为空")
	@Size(message = "按钮名称长度应小于{max}", max = 50)
	private String operationName;

	@ApiModelProperty(value="按钮描述", dataType = "String", required = true, example = "添加【表格头部】")
	@NotBlank(message = "按钮描述不能为空")
	@Size(message = "按钮描述长度应小于{max}", max = 50)
	private String description;

	@ApiModelProperty(value="按钮编码（用于前端触发按钮调用函数名称）", dataType = "String", required = true, example = "测试按钮编码（用于前端触发按钮调用函数名称）")
	@NotBlank(message = "按钮编码（用于前端触发按钮调用函数名称）不能为空")
	@Size(message = "按钮编码（用于前端触发按钮调用函数名称）长度应小于{max}", max = 50)
	private String code;

	@ApiModelProperty(value="按钮图标", dataType = "String", required = true, example = "测试按钮图标")
	@NotBlank(message = "按钮图标不能为空")
	@Size(message = "按钮图标长度应小于{max}", max = 50)
	private String icon;

	@ApiModelProperty(value="按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)", dataType = "String", required = true, example = "测试按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)")
	@NotBlank(message = "按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)不能为空")
	@Size(message = "按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)长度应小于{max}", max = 50)
	private String type;

	@ApiModelProperty(value="按钮顺序", dataType = "Integer", example = "1")
	@NotNull(message = "按钮顺序不能为空")
	@DecimalMin(message = "按钮顺序错误,应当大于等于于{value}", value = "0")
	@DecimalMax(message = "按钮顺序错误,应当小于等于{value}", value = "1000")
	private Integer orderInfo;
}
