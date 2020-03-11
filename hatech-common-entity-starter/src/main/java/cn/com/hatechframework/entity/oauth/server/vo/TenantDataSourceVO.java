package cn.com.hatechframework.entity.oauth.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.entity.oauth.server.vo
 * @className TenantDataSourceVO
 * @description 租户数据源实体类
 * @author YeMeng
 * @create 2019/12/27 13:12
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/27 13:12             1.0                         租户数据源实体类
 */
@ApiModel(value = "cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO", description = "租户数据源实体类VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantDataSourceVO {

    @ApiModelProperty(value="租户数据源ID", dataType = "String", example = "123456")
    private String id;

    @ApiModelProperty(value = "租户名称", dataType = "String", example = "product")
    private String tenantName;

    @ApiModelProperty(value = "数据源连接地址", dataType = "String", example = "jdbc:mysql://localhost:3306/transaction")
    private String dataSourceUrl;

    @ApiModelProperty(value = "数据源连接用户名", dataType = "String", example = "root")
    private String dataSourceUsername;

    @ApiModelProperty(value = "数据源连接密码", dataType = "String", example = "root")
    private String dataSourcePassword;

    @ApiModelProperty(value = "数据源连接驱动", dataType = "String", example = "com.mysql.cj.jdbc.Driver")
    private String dataSourceDriver;

    @ApiModelProperty(value = "数据源连接池类型", dataType = "String", example = "com.zaxxer.hikari.HikariDataSource")
    private String dataSourceType;

}
