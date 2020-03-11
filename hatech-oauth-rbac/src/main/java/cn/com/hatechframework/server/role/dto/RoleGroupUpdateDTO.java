package cn.com.hatechframework.server.role.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.dto
 * @className RoleGroupUpdateDTO
 * @description 角色组更新DTO
 * @author WangMingShuai
 * @create 2019/12/27 14:57
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 14:57             1.0                         角色组更新DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.role.dto.RoleGroupUpdateDTO", description = "角色分页DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleGroupUpdateDTO {

    @ApiModelProperty(value="角色ID", dataType = "String", required = true, example = "UUID")
    @NotBlank(message = "角色ID不能为空")
    @Length(message = "角色ID长度应该在{min}~{max}之间", min = 1, max = 64)
    private String id;

    @ApiModelProperty(value="角色组名称", dataType = "String", required = true, example = "ADMIN组")
    @NotBlank(message = "角色组名称不能为空")
    @Length(message = "角色组名称长度应该在{min}~{max}之间", min = 1, max = 15)
    private String roleGroupName;

    @ApiModelProperty(value="角色组描述", dataType = "String", example = "超级管理员")
    @Size(message = "角色组描述长度应小于{max}", max = 150)
    private String description;

    @ApiModelProperty(value="角色ids", dataType = "String",example = "[\"UUID\"]")
    private List<String> roleIds;

    @ApiModelProperty(value="用户ids", dataType = "String",example = "[\"UUID\"]")
    private List<String> userIds;

}
