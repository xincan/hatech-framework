package cn.com.hatechframework.server.menu.vo;

import cn.com.hatechframework.server.menu.utils.BaseTree;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.vo
 * @className MenuOperationTreeVo
 * @description 菜单操作树
 * @author WangMingShuai
 * @create 2020/1/21 15:13
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/21 15:13             1.0                         菜单操作树
 */
@ApiModel(value = "cn.com.hatechframework.server.menu.vo.MenuOperationTreeVo", description = "菜单操作树Vo")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class MenuOperationTreeVo extends BaseTree {

    @ApiModelProperty(value="菜单ID", dataType = "String", example = "UUID")
    private String menuId;

    @ApiModelProperty(value="操作ID", dataType = "String", example = "UUID")
    private String operationId;

    @ApiModelProperty(value="名称", dataType = "String", example = "用户列表查询")
    private String name;

    @ApiModelProperty(value="类型", dataType = "String", example = "table-header")
    private String type;

    @ApiModelProperty(value="禁用类型", dataType = "String", example = "true")
    private boolean disabled = true;

    @Builder
    public MenuOperationTreeVo(String id, String parentId, List<BaseTree> children, String menuId, String operationId, String name, String type) {
        super(id, parentId, children);
        this.menuId = menuId;
        this.operationId = operationId;
        this.name = name;
        this.type = type;
    }
}
