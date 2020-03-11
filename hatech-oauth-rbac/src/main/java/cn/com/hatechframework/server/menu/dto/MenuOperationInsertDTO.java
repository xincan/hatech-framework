package cn.com.hatechframework.server.menu.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.dto
 * @className MenuOperationInsertDTO
 * @description 新增菜单操作关系表DTO
 * @author WangMingShuai
 * @create 2020/01/15 16:20
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 16:20             1.0                         新增菜单操作关系表DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.menu.dto.MenuOperationInsertDTO", description = "新增菜单操作关系表DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuOperationInsertDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="菜单ID", dataType = "String", required = true, example = "UUID")
	@NotBlank(message = "菜单ID不能为空")
	@Size(message = "菜单ID长度应小于{max}", max = 64)
	private String menuId;

	@ApiModelProperty(value="操作ids", dataType = "String",example = "[\"UUID\"]")
	private List<String> operationIds;

}
