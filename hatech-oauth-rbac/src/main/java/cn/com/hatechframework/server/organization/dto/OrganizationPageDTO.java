package cn.com.hatechframework.server.organization.dto;

import cn.com.hatechframework.data.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.organization.dto
 * @className OrganizationPageDTO
 * @description 机构分页DTO
 * @author WangMingShuai
 * @create 2019/12/27 19:17
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 19:17             1.0                         机构分页DTO
 */
@ApiModel(value = "cn.com.hatechframework.server.organization.dto.OrganizationPageDTO", description = "机构分页DTO")
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationPageDTO extends PaginationQuery {

    @ApiModelProperty(value="机构名称", dataType = "String", example = "同创集团")
    private String name;

}
