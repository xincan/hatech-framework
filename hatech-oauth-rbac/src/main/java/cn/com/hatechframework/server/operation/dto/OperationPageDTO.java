package cn.com.hatechframework.server.operation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cn.com.hatechframework.data.page.OrderType;
import cn.com.hatechframework.data.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.operation.dto
 * @className OperationPageDTO
 * @description 操作按钮分页查询DTO
 * @author WangMingShuai
 * @create 2020/01/15 17:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 17:36             1.0                         操作按钮分页查询DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.operation.dto.OperationPageDTO", description = "操作按钮分页查询DTO")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class OperationPageDTO extends PaginationQuery {

	@ApiModelProperty(value="按钮名称", dataType = "String", required = true, example = "测试按钮名称")
	private String operationName;

	@ApiModelProperty(value="按钮编码（用于前端触发按钮调用函数名称）", dataType = "String", required = true, example = "测试按钮编码（用于前端触发按钮调用函数名称）")
	private String code;

	@ApiModelProperty(value="按钮图标", dataType = "String", required = true, example = "测试按钮图标")
	private String icon;

	@ApiModelProperty(value="按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)", dataType = "String", required = true, example = "测试按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)")
	private String type;

	@ApiModelProperty(value="按钮顺序", dataType = "Integer", example = "1")
	private Integer orderInfo;

	@ApiModelProperty(value="创建时间", dataType = "String", example = "2020-01-01 12:12:12")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date editTime;

	@Builder
	public OperationPageDTO(String operationName, String code, String icon, String type, Integer orderInfo, Date editTime,
			Integer page, Integer limit, String sortName, OrderType sortOrder, Date startTime, Date endTime) {
		super(page, limit, sortName, sortOrder, startTime, endTime);

		this.operationName = operationName;
		this.code = code;
		this.icon = icon;
		this.type = type;
		this.orderInfo = orderInfo;
		this.editTime = editTime;

	}

}
