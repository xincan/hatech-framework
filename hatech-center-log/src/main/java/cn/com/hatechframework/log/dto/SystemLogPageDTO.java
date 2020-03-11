package cn.com.hatechframework.log.dto;

import cn.com.hatechframework.data.page.OrderType;
import cn.com.hatechframework.data.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.log.dto
 * @className SystemLogPageDTO
 * @description 日志信息分页查询
 * @author WangMingShuai
 * @create 2019/12/18 15:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/18 15:09             1.0                         日志信息分页查询
 */
@ApiModel(value = "cn.com.hatechframework.log.dto.SystemLogPageDTO", description = "日志信息分页查询实体类")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class SystemLogPageDTO extends PaginationQuery {

    @ApiModelProperty(value="用户名", dataType = "String", example = "张三")
    private String userName;

    @ApiModelProperty(value="当前系统业务日志类型", dataType = "String", example = "登录日志")
    private String businessType;

    @ApiModelProperty(value="当前系统操作类型", dataType = "String", example = "增加")
    private String type;

    @ApiModelProperty(value="操作模块名称", dataType = "String", example = "用户管理、角色管理")
    private String model;

    @ApiModelProperty(value="当前系统操作主机IP", dataType = "String", example = "192.168.1.1")
    private String ip;

    @Builder
    public SystemLogPageDTO(Integer page, Integer limit, String sortName, OrderType sortOrder, Date startTime, Date endTime,
                            String userName, String businessType, String type, String model, String ip) {
        super(page, limit, sortName, sortOrder, startTime, endTime);
        this.userName = userName;
        this.businessType = businessType;
        this.type =type;
        this.model = model;
        this.ip = ip;
    }
}
