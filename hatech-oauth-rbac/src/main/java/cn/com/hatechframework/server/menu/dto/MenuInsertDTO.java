package cn.com.hatechframework.server.menu.dto;

import cn.com.hatechframework.validator.HatechJsonValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.dto
 * @className MenuSaveDTO
 * @description 菜单实体类DTO
 * @author WangMingShuai
 * @create 2019/12/23 10:05
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/23 10:05             1.0                         菜单实体类
 */
@ApiModel(value = "cn.com.hatechframework.server.menu.dto.MenuInsertDTO", description = "菜单实体类DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuInsertDTO {

    @ApiModelProperty(value="菜单名称", dataType = "String", required = true, example = "用户列表查询")
    @NotBlank(message = "菜单名称不能为空")
    @Length(message = "菜单名称长度应该在{min}~{max}之间", min = 1, max = 15)
    private String menuName;

    @ApiModelProperty(value="菜单路由", dataType = "String", required = true, example = "/user/list")
    @NotBlank(message = "菜单路由不能为空")
    @Length(message = "菜单路由长度应该在{min}~{max}之间", min = 1, max = 50)
    private String path;

    @ApiModelProperty(value="菜单编码", dataType = "String", required = true, example = "bcms_1_6_1")
    @NotBlank(message = "菜单编码不能为空")
    @Length(message = "菜单编码长度应该在{min}~{max}之间", min = 1, max = 100)
    private String code;

    @ApiModelProperty(value="父级菜单ID", dataType = "String", example = "UUID")
    @Length(message = "父级菜单ID长度应该在{min}~{max}之间", max = 64)
    private String parentId;

    @ApiModelProperty(value="菜单图标", dataType = "String", example = "home")
    @NotBlank(message = "菜单图标不能为空")
    @Length(message = "菜单图标长度应该在{min}~{max}之间", min = 1, max = 25)
    private String icon;

    @ApiModelProperty(value="路由参数", dataType = "String", example = "{\"id\":\"UUID\"}")
    @HatechJsonValidator(message = "路由参数是非法json")
    private String params;

    @ApiModelProperty(value="菜单顺序", dataType = "String", example = "1")
    @NotNull(message = "菜单顺序不能为空")
    @DecimalMin(message = "菜单顺序错误,应当大于等于于{value}", value = "0")
    @DecimalMax(message = "菜单顺序错误,应当小于等于{value}", value = "500")
    private Integer orderInfo;
}
