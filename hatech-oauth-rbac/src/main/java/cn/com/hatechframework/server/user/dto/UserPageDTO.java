package cn.com.hatechframework.server.user.dto;

import cn.com.hatechframework.data.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.dto
 * @className UserPageDTO
 * @description 用户分页查询DTO
 * @author WangMingShuai
 * @create 2019/12/23 17:49
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/23 17:49             1.0                         用户分页查询DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.user.dto.UserPageDTO", description = "用户分页查询DTO")
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPageDTO extends PaginationQuery {

    @ApiModelProperty(value="用户登录名称", dataType = "String", example = "admin")
    private String username;

    @ApiModelProperty(value="用户名", dataType = "String", example = "张三")
    private String name;

    @ApiModelProperty(value="用户手机号", dataType = "String", example = "17088888888")
    private String phone;

    @ApiModelProperty(value="状态", dataType = "Integer", example = "1")
    private Integer status;

    @ApiModelProperty(value = "组织ID", dataType = "String", example = "组织id")
    private String organizationId;

    @ApiModelProperty(value = "角色ID", dataType = "String", example = "角色ID")
    private String roleId;

    @ApiModelProperty(value = "角色组ID", dataType = "String", example = "角色组ID")
    private String roleGroupId;

}
