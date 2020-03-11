package cn.com.hatechframework.server.role.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.vo
 * @className RoleGroupVO
 * @description 角色组VO
 * @author WangMingShuai
 * @create 2019/12/27 15:13
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 15:13             1.0                         用户组VO
 */
@ApiModel(value = "cn.com.hatechframework.server.role.vo.RoleGroupVO", description = "用户组VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleGroupVO {

    @ApiModelProperty(value="角色组ID", dataType = "String", example = "UUID")
    private String id;

    @ApiModelProperty(value="角色组名称", dataType = "String", required = true, example = "ADMIN")
    private String roleGroupName;

    @ApiModelProperty(value="角色组描述", dataType = "String", example = "超级管理员")
    private String description;

    @ApiModelProperty(value="角色组状态", dataType = "Integer", example = "1")
    private Integer status;

    @ApiModelProperty(value="编辑人员ID", dataType = "String", example = "UUID")
    private String editUserId;

    @ApiModelProperty(value="操作时间，格式：yyyy-MM-dd HH:mm:ss", dataType="String", notes="格式：yyyy-MM-dd HH:mm:ss", example = "2019-09-09 09:09:09")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;

    @ApiModelProperty(value="角色ids", dataType = "String", example = "[\"UUID\"]")
    private List<String> roleIds;

    @ApiModelProperty(value="用户ids", dataType = "String", example = "[\"UUID\"]")
    private List<String> userIds;
}
