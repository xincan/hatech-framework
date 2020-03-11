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
 * @className RoleInsertDTO
 * @description 角色信息DTO
 * @author WangMingShuai
 * @create 2019/12/23 17:01
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/23 17:01             1.0                         角色信息DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.role.dto.RoleSaveDTO", description = "角色信息DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleInsertDTO {

    @ApiModelProperty(value="角色名称", dataType = "String", required = true, example = "ADMIN")
    @NotBlank(message = "角色名称不能为空")
    @Length(message = "角色名称长度应该在{min}~{max}之间", min = 1, max = 15)
    private String roleName;

    @ApiModelProperty(value="角色描述", dataType = "String", example = "超级管理员")
    @Size(message = "角色描述长度应小于{max}", max = 150)
    private String description;

    @ApiModelProperty(value="菜单ids", dataType = "String",example = "[\"UUID\"]")
    private List<String> menuIds;

}
