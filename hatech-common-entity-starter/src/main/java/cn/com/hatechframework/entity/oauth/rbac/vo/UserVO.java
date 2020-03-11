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
 * @className UserVO
 * @description 用户实体类VO
 * @author WangMingShuai
 * @create 2019/12/19 16:29
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/19 16:29             1.0                         用户实体类VO
 */
@ApiModel(value = "cn.com.hatechframework.entity.oauth.rbac.vo.UserVO", description = "用户实体类VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    @ApiModelProperty(value="用户ID", dataType = "String", example = "UUID")
    private String id;

    @ApiModelProperty(value="用户登录名称", dataType = "String", example = "admin")
    private String username;

    @ApiModelProperty(value="用户登录密码", dataType = "String", example = "123456")
    private String password;

    @ApiModelProperty(value="用户名", dataType = "String", example = "张三")
    private String name;

    @ApiModelProperty(value="用户手机号", dataType = "String", example = "17088888888")
    private String phone;

    @ApiModelProperty(value="用户邮箱", dataType = "String", example = "11@qq.com")
    private String email;

    @ApiModelProperty(value="是否是管理员", dataType = "boolean", example = "0")
    private Boolean isAdmin;

    @ApiModelProperty(value="用户状态", dataType = "Integer", example = "1")
    private Integer status;

    @ApiModelProperty(value="是否是租户", dataType = "boolean", example = "true")
    private Boolean isTenant;

    @ApiModelProperty(value="公司名称", dataType = "String", example = "同创永益")
    private String company;

    @ApiModelProperty(value="企业统一码", dataType = "String", example = "企业统一码")
    private String code;

    @ApiModelProperty(value="关联地区ID", dataType = "String", example = "UUID")
    private String areaId;

    @ApiModelProperty(value="关联机构ID", dataType = "String", example = "UUID")
    private String organizationId;

    @ApiModelProperty(value="关联机构名称", dataType = "String", example = "机构名称")
    private String organizationName;

    @ApiModelProperty(value="编辑人员ID", dataType = "String", example = "UUID")
    private String editUserId;

    @ApiModelProperty(value="操作时间，格式：yyyy-MM-dd HH:mm:ss", dataType="String", notes="格式：yyyy-MM-dd HH:mm:ss", example = "2019-09-09 09:09:09")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;

    /**
     * 用户角色
     */
    private List<RoleVO> authorities;
}
