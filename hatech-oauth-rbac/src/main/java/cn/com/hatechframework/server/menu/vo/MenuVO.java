package cn.com.hatechframework.server.menu.vo;

import cn.com.hatechframework.server.menu.utils.BaseTree;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.vo
 * @className MenuVO
 * @description 菜单实体类
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         菜单实体类
 */
@ApiModel(value = "cn.com.hatechframework.server.menu.vo.MenuVO", description = "菜单实体类")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class MenuVO extends BaseTree {

    @ApiModelProperty(value="菜单名称", dataType = "String", example = "用户列表查询")
    private String menuName;

    @ApiModelProperty(value="菜单路由", dataType = "String", example = "/user/list")
    private String path;

    @ApiModelProperty(value="菜单编码", dataType = "String", example = "bcms_1_6_1")
    private String code;

    @ApiModelProperty(value="菜单图标", dataType = "String", example = "home")
    private String icon;

    @ApiModelProperty(value="路由参数", dataType = "String", example = "{\"id\":\"UUID\"}")
    private String params;

    @ApiModelProperty(value="菜单级别", dataType = "String", example = "1")
    private Integer level;

    @ApiModelProperty(value="菜单顺序", dataType = "String", example = "1")
    private Integer orderInfo;

    @ApiModelProperty(value="编辑人员ID", dataType = "String", example = "UUID")
    private String editUserId;

    @ApiModelProperty(value="操作时间，格式：yyyy-MM-dd HH:mm:ss", dataType="String", notes="格式：yyyy-MM-dd HH:mm:ss", example = "2019-09-09 09:09:09")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;

    @ApiModelProperty(value="父类菜单名称", dataType = "String", example = "demo菜单")
    private String parentMenuName;

    @ApiModelProperty(value="操作ID集合", dataType = "String", example = "['123','456']")
    private List<String> operationIds;

    @Builder
    public MenuVO(String id, String parentId, List<BaseTree> children, String menuName, String path, String code, String icon, String params, Integer level, Integer orderInfo, String editUserId, Date editTime, String parentMenuName, List<String> operationIds) {
        super(id, parentId, children);
        this.menuName = menuName;
        this.path = path;
        this.code = code;
        this.icon = icon;
        this.params = params;
        this.level = level;
        this.orderInfo = orderInfo;
        this.editUserId = editUserId;
        this.editTime = editTime;
        this.parentMenuName = parentMenuName;
        this.operationIds = operationIds;
    }
}
