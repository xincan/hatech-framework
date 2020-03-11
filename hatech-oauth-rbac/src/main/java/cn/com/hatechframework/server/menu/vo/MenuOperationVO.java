package cn.com.hatechframework.server.menu.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.vo
 * @className MenuOperationVO
 * @description 菜单操作关系表VO
 * @author WangMingShuai
 * @create 2020/01/15 16:20
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 16:20             1.0                         菜单操作关系表VO
 */
@ApiModel(value = "cn.com.hatechframework.server.menu.vo.MenuOperationVO", description = "菜单操作关系表VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuOperationVO {

	@ApiModelProperty(value="资源ID", dataType = "String", required = true, example = "测试资源ID")
	private String id;

	@ApiModelProperty(value="菜单ID", dataType = "String", required = true, example = "测试菜单ID")
	private String menuId;

	@ApiModelProperty(value="操作ID", dataType = "String", required = true, example = "测试操作ID")
	private String operationId;

}
