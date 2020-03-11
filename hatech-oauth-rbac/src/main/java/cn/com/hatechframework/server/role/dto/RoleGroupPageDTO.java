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
 * @className RoleGroupPageDTO
 * @description 用户组分页DTO
 * @author WangMingShuai
 * @create 2019/12/27 14:58
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 14:58             1.0                         用户组分页DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.role.dto.RoleGroupPageDTO", description = "角色分页DTO")
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleGroupPageDTO extends PaginationQuery {

    @ApiModelProperty(value="角色组名称", dataType = "String", example = "ADMIN组")
    private String roleGroupName;
}
