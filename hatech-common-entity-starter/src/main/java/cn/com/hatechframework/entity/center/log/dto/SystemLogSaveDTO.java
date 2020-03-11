package cn.com.hatechframework.entity.center.log.dto;

import cn.com.hatechframework.validator.HatechJsonValidator;
import cn.com.hatechframework.validator.ValidatorUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.entity.center.log.dto
 * @className SystemLogSaveDTO
 * @description 系统日志DTO
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/20 17:03             1.0                         系统日志DTO
 */
@ApiModel(value = "cn.com.hatechframework.entity.center.log.dto.SystemLogSaveDTO", description = "系统日志DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemLogSaveDTO {

    @ApiModelProperty(value="当前系统操作用户ID", dataType = "String", required = true, example = "UUID")
    @NotBlank(message = "当前系统操作用户ID不能为空")
    @Length(message = "当前系统操作用户ID长度应该在{min}~{max}之间", min = 1, max = 64)
    private String userId;

    @ApiModelProperty(value="当前系统操作用户名称", dataType = "String", required = true, example = "张三")
    @NotBlank(message = "当前系统操作用户名称不能为空")
    @Length(message = "当前系统操作用户名称长度应该在{min}~{max}之间", min = 1, max = 25)
    private String userName;

    @ApiModelProperty(value="当前系统操作租户ID", dataType = "String", required = true, example = "UUID")
    @NotBlank(message = "当前系统操作租户ID不能为空")
    @Length(message = "当前系统操作租户ID长度应该在{min}~{max}之间", min = 1, max = 64)
    private String tenantId;

    @ApiModelProperty(value="当前系统操作用户所属公司名称", dataType = "String", required = true, example = "同创永益")
    @NotBlank(message = "当前系统操作用户所属公司名称不能为空")
    @Length(message = "当前系统操作用户所属公司名称长度应该在{min}~{max}之间", min = 1, max = 50)
    private String company;

    @ApiModelProperty(value="当前系统操作用户所在部门名称", dataType = "String", required = true, example = "视觉交互部")
    @NotBlank(message = "当前系统操作用户所在部门名称不能为空")
    @Length(message = "当前系统操作用户所在部门名称长度应该在{min}~{max}之间", min = 1, max = 50)
    private String department;

    @ApiModelProperty(value="当前系统操作主机IP", dataType = "String", required = true, example = "192.168.1.1")
    @NotBlank(message = "当前系统操作主机IP不能为空")
    @Pattern(regexp = ValidatorUtils.REGEX_IP_ADDR, message = "当前系统操作主机IP格式错误")
    private String ip;

    @ApiModelProperty(value="当前系统操作微服务端口", dataType = "Integer", required = true, example = "99999")
    @NotNull(message = "当前系统操作微服务端口不能为空")
    @DecimalMin(message = "当前系统操作微服务端口错误,应当大于等于于{value}", value = "1")
    @DecimalMax(message = "当前系统操作微服务端口错误,应当小于等于{value}", value = "99999")
    private Integer port;

    @ApiModelProperty(value="当前系统微服务名称", dataType = "String", required = true, example = "xincan-transaction-user")
    @NotBlank(message = "当前系统微服务名称不能为空")
    @Length(message = "当前系统微服务名称长度应该在{min}~{max}之间", min = 1, max = 50)
    private String microService;

    @ApiModelProperty(value="当前系统请求微服务方法函数路径", dataType = "String", required = true, example = "http://192.168.1.1:8080/user/find")
    @NotBlank(message = "当前系统请求微服务方法函数路径不能为空")
    @Length(message = "当前系统请求微服务方法函数路径长度应该在{min}~{max}之间", min = 1, max = 100)
    private String classUrl;

    @ApiModelProperty(value="当前系统类请求微服务方法函数参数", dataType = "String", required = true, example = "[{\"name\":\"lisi\"}]")
    @HatechJsonValidator(message = "当前系统类请求微服务方法函数参数是非法json字符")
    private String classParam;

    @ApiModelProperty(value="当前系统操作类型", dataType = "String", required = true, example = "登录日志")
    @NotNull(message = "当前系统操作类型不能为空")
    @Length(message = "当前系统操作类型长度应该在{min}~{max}之间", min = 1, max = 25)
    private String type;

    @ApiModelProperty(value="当前系统业务日志类型", dataType = "String", required = true, example = "增加")
    @NotNull(message = "当前系统业务日志类型不能为空")
    @Length(message = "当前系统业务日志类型长度应该在{min}~{max}之间", min = 1, max = 25)
    private String businessType;

    @ApiModelProperty(value="操作模块名称", dataType = "String", required = true, example = "用户管理、角色管理")
    @NotBlank(message = "操作模块名称不能为空")
    @Length(message = "操作模块名称长度应该在{min}~{max}之间", min = 1, max = 50)
    private String model;

    @ApiModelProperty(value="当前系统操作说明", dataType = "String", example = "调用接口做实现")
    @Size(message = "当前系统操作说明长度应小于{max}", max = 500)
    private String description;

}
