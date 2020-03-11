package cn.com.hatechframework.entity.oauth.rbac.vo;

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
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.entity.oauth.rbac.vo
 * @className RoleVO
 * @description 角色实体类VO
 * @author WangMingShuai
 * @create 2019/12/23 17:02
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/23 17:02             1.0                         角色实体类VO
 */
@ApiModel(value = "cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO", description = "角色实体类VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO {

    @ApiModelProperty(value="角色ID", dataType = "String", example = "UUID")
    private String id;

    @ApiModelProperty(value="角色名称", dataType = "String", required = true, example = "ADMIN")
    private String roleName;

    @ApiModelProperty(value="角色描述", dataType = "String", example = "超级管理员")
    private String description;

    @ApiModelProperty(value="角色状态", dataType = "Integer", example = "1")
    private Integer status;

    @ApiModelProperty(value="编辑人员ID", dataType = "String", example = "UUID")
    private String editUserId;

    @ApiModelProperty(value="操作时间，格式：yyyy-MM-dd HH:mm:ss", dataType="String", notes="格式：yyyy-MM-dd HH:mm:ss", example = "2019-09-09 09:09:09")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;

    @ApiModelProperty(value="菜单操作ID集合", dataType = "String", example = "UUID")
    private List<String> menuIds;
}
