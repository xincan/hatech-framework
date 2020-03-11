package cn.com.hatechframework.server.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.organization.dto
 * @className OrganizationUpdateDTO
 * @description 机构更新DTO
 * @author WangMingShuai
 * @create 2019/12/27 19:18
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 19:18             1.0                         机构更新DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.organization.dto.OrganizationUpdateDTO", description = "机构更新DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationUpdateDTO {

    @ApiModelProperty(value="机构ID", dataType = "String", required = true, example = "UUID")
    @NotBlank(message = "机构ID不能为空")
    @Length(message = "机构ID长度应该在{min}~{max}之间", min = 1, max = 64)
    private String id;

    @ApiModelProperty(value="机构名称", dataType = "String", required = true, example = "同创集团")
    @NotBlank(message = "机构名称不能为空")
    @Length(message = "机构名称长度应该在{min}~{max}之间", min = 1, max = 100)
    private String name;

    @ApiModelProperty(value="父级菜单ID", dataType = "String", required = true, example = "UUID")
    @NotBlank(message = "父级菜单ID不能为空")
    @Length(message = "父级菜单ID长度应该在{min}~{max}之间", min = 1, max = 64)
    private String parentId;

    @ApiModelProperty(value="机构描述", dataType = "String", example = "机构描述")
    @Size(message = "机构描述长度应小于{max}", max = 100)
    private String description;

    @ApiModelProperty(value="机构顺序", dataType = "String", example = "1")
    @DecimalMin(message = "机构顺序错误,应当大于等于于{value}", value = "0")
    @DecimalMax(message = "机构顺序错误,应当小于等于{value}", value = "500")
    private Integer orderInfo;
}
