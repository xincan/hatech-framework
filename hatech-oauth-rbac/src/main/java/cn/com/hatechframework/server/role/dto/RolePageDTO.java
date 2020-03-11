package cn.com.hatechframework.server.role.dto;

import cn.com.hatechframework.data.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.dto
 * @className RolePageDTO
 * @description 角色分页DTO
 * @author WangMingShuai
 * @create 2019/12/23 17:21
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/23 17:21             1.0                         角色分页DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.role.dto.RolePageDTO", description = "角色分页DTO")
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolePageDTO extends PaginationQuery {

    @ApiModelProperty(value="角色名称", dataType = "String", example = "ADMIN")
    private String roleName;

    @ApiModelProperty(value="角色组ID", dataType = "String", example = "UUID")
    private String roleGroupId;
}
