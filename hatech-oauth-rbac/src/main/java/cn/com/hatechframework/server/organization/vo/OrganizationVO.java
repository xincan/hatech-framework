package cn.com.hatechframework.server.organization.vo;

import cn.com.hatechframework.server.menu.utils.BaseTree;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.organization.vo
 * @className OrganizationVO
 * @description 机构信息VO
 * @author WangMingShuai
 * @create 2019/12/27 19:15
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 19:15             1.0                         机构信息VO
 */
@ApiModel(value = "cn.com.hatechframework.server.organization.vo.OrganizationVO", description = "机构信息VO")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class OrganizationVO extends BaseTree {

    @ApiModelProperty(value="机构名称", dataType = "String", example = "同创集团")
    private String name;

    @ApiModelProperty(value="机构状态", dataType = "Integer", example = "1")
    private Integer status;

    @ApiModelProperty(value="描述", dataType = "String", example = "机构描述")
    private String description;

    @ApiModelProperty(value="菜单顺序", dataType = "String", example = "1")
    private Integer orderInfo;

    @ApiModelProperty(value="编辑人员ID", dataType = "String", example = "UUID")
    private String editUserId;

    @ApiModelProperty(value="操作时间，格式：yyyy-MM-dd HH:mm:ss", dataType="String", notes="格式：yyyy-MM-dd HH:mm:ss", example = "2019-09-09 09:09:09")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;

    @Builder
    public OrganizationVO(String id, String parentId, List<BaseTree> children, String name, Integer status, String description, Integer orderInfo, String editUserId, Date editTime) {
        super(id, parentId, children);
        this.name = name;
        this.status = status;
        this.description = description;
        this.orderInfo = orderInfo;
        this.editUserId = editUserId;
        this.editTime = editTime;
    }
}
