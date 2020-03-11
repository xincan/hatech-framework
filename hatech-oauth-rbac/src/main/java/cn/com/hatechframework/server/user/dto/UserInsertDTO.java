package cn.com.hatechframework.server.user.dto;

import cn.com.hatechframework.validator.ValidatorUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.user.dto
 * @className UserSaveDTO
 * @description 用户信息（输入）
 * @author WangMingShuai
 * @create 2019/12/19 16:34
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/19 16:34             1.0                         用户信息（输入）
 */
@ApiModel(value = "cn.com.hatechframework.server.user.dto.UserSaveDTO", description = "用户信息实体类")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInsertDTO {

    @ApiModelProperty(value="用户登录名称", dataType = "String", required = true, example = "admin")
    @NotBlank(message = "用户账号不能为空")
    @Size(message = "用户账号不能超过{max}个字符",max = 100)
    @Pattern(regexp = ValidatorUtils.REGEX_EMAIL, message = "用户账号必须为邮箱")
    @Email(regexp = ValidatorUtils.REGEX_EMAIL, message = "用户账号必须为邮箱")
    private String username;

    @ApiModelProperty(value="用户名", dataType = "String", example = "张三")
    @NotBlank(message = "用户名不能为空")
    @Size(message = "用户名不能超过{max}个字符",max = 100)
    private String name;

    @ApiModelProperty(value="手机号", dataType = "String", example = "17088888888")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = ValidatorUtils.REGEX_MOBILE,message = "手机号不正确")
    private String phone;

    @ApiModelProperty(value="公司名称", dataType = "String", example = "同创永益")
    @Size(message = "公司名称不能超过{max}个字符",max = 50)
    private String company;

    @ApiModelProperty(value="企业统一码", dataType = "String", example = "企业统一码")
    @Size(message = "企业统一码不能超过{max}个字符",max = 50)
    private String code;

    @ApiModelProperty(value="关联地区ID", dataType = "String", example = "UUID")
    @Size(message = "关联地区ID不能超过{max}个字符",max = 64)
    private String areaId;

    @ApiModelProperty(value="关联机构ID", dataType = "String", example = "UUID")
    @Size(message = "关联机构ID不能超过{max}个字符",max = 64)
    private String organizationId;

    @ApiModelProperty(value="用户角色ids", dataType = "String",example = "[\"UUID\"]")
    private List<String> roleIds;

    @ApiModelProperty(value="用户角色组ids", dataType = "String",example = "[\"UUID\"]")
    private List<String> roleGroupIds;
}
