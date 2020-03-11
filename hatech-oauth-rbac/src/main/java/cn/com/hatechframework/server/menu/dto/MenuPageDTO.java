package cn.com.hatechframework.server.menu.dto;

import cn.com.hatechframework.data.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.dto
 * @className MenuPageDTO
 * @description 菜单分页查询参数
 * @author WangMingShuai
 * @create 2019/12/20 17:10
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:10             1.0                         菜单分页查询参数
 */
@ApiModel(value = "cn.com.hatechframework.server.menu.dto.MenuPageDTO", description = "菜单分页查询参数")
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuPageDTO extends PaginationQuery {

    @ApiModelProperty(value="菜单名称", dataType = "String", example = "用户列表查询")
    private String menuName;

    @ApiModelProperty(value="菜单路由", dataType = "String", example = "/user/list")
    private String path;

    @ApiModelProperty(value="父级菜单ID", dataType = "String", example = "UUID")
    private String parentId;

}
