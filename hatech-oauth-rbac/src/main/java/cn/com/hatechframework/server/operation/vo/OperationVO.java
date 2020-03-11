package cn.com.hatechframework.server.operation.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.operation.vo
 * @className OperationVO
 * @description 操作按钮VO
 * @author WangMingShuai
 * @create 2020/01/15 17:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 17:36             1.0                         操作按钮VO
 */
@ApiModel(value = "cn.com.hatechframework.server.operation.vo.OperationVO", description = "操作按钮VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="操作ID", dataType = "String", required = true, example = "测试操作ID")
	private String id;

	@ApiModelProperty(value="按钮名称", dataType = "String", required = true, example = "测试按钮名称")
	private String operationName;

	@ApiModelProperty(value = "按钮描述", dataType = "String", required = true, example = "添加【表格头部】")
	private String description;

	@ApiModelProperty(value="按钮编码（用于前端触发按钮调用函数名称）", dataType = "String", required = true, example = "测试按钮编码（用于前端触发按钮调用函数名称）")
	private String code;

	@ApiModelProperty(value="按钮图标", dataType = "String", required = true, example = "测试按钮图标")
	private String icon;

	@ApiModelProperty(value="按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)", dataType = "String", required = true, example = "测试按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)")
	private String type;

	@ApiModelProperty(value="按钮顺序", dataType = "Integer", example = "1")
	private Integer orderInfo;

	@ApiModelProperty(value="编辑人员ID", dataType = "String", example = "UUID")
	private String editUserId;

	@ApiModelProperty(value="创建时间", dataType = "String", example = "2020-01-01 12:12:12")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date editTime;


}
