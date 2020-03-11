package cn.com.hatechframework.log.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.log.vo
 * @className SystemLogVO
 * @description 系统日志实体类（输出）
 * @author JiangXincan
 * @create 2019/12/18 13:35
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 13:35             1.0                         系统日志实体类（输出）
 */
@ApiModel(value = "cn.com.hatechframework.log.vo.SystemLogVO", description = "系统日志实体类（输出）")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemLogVO {

    @ApiModelProperty(value="日志ID", dataType = "String", hidden = true, example = "UUID")
    private String id;

    @ApiModelProperty(value="当前系统操作用户ID", dataType = "String", required = true, example = "UUID")
    private String userId;

    @ApiModelProperty(value="当前系统操作用户名称", dataType = "String", required = true, example = "张三")
    private String userName;

    @ApiModelProperty(value="当前系统操作租户ID", dataType = "String", example = "UUID")
    private String tenantId;

    @ApiModelProperty(value="当前系统操作用户所属公司名称", dataType = "String", required = true, example = "同创永益")
    private String company;

    @ApiModelProperty(value="当前系统操作用户所在部门名称", dataType = "String", example = "视觉交互部")
    private String department;

    @ApiModelProperty(value="当前系统操作主机IP", dataType = "String", required = true, example = "192.168.1.1")
    private String ip;

    @ApiModelProperty(value="当前系统操作微服务端口", dataType = "Integer", required = true, example = "99999")
    private Integer port;

    @ApiModelProperty(value="当前系统微服务名称", dataType = "String", required = true, example = "xincan-transaction-user")
    private String microService;

    @ApiModelProperty(value="当前系统请求微服务方法函数路径", dataType = "String", required = true, example = "http://192.168.1.1:8080/user/find")
    private String classUrl;

    @ApiModelProperty(value="当前系统类请求微服务方法函数参数", dataType = "String", required = true, example = "[{\"name\":\"lisi\"}]")
    private String classParam;

    @ApiModelProperty(value="当前系统操作类型", dataType = "String", required = true, example = "登录日志")
    private String type;

    @ApiModelProperty(value="当前系统业务日志类型", dataType = "String", required = true, example = "增加")
    private String businessType;

    @ApiModelProperty(value="操作模块名称", dataType = "String", example = "用户管理、角色管理")
    private String model;

    @ApiModelProperty(value="当前系统操作说明", dataType = "String", example = "调用接口做实现")
    private String description;

    @ApiModelProperty(value="操作时间，格式：yyyy-MM-dd HH:mm:ss", dataType="String", notes="格式：yyyy-MM-dd HH:mm:ss", example = "2019-09-09 09:09:09")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;


}
