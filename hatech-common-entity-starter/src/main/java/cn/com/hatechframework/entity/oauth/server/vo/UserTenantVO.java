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
 * @className UserTenantVO
 * @description 用户租户对应VO
 * @author YeMeng
 * @create 2019/12/28 15:17
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/28 15:17             1.0                         用户租户对应VO
 */
@ApiModel(value = "cn.com.hatechframework.entity.oauth.server.vo.UserTenantVO", description = "用户租户对应VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTenantVO {

    @ApiModelProperty(value="用户租户对应ID", dataType = "String", example = "1")
    private String id;

    @ApiModelProperty(value="用户登录名", dataType = "String", example = "11@qq.com")
    private String username;

    @ApiModelProperty(value="用户手机号", dataType = "String", example = "123456")
    private String phone;

    @ApiModelProperty(value="租户ID", dataType = "String", example = "111")
    private String tenantId;
}
