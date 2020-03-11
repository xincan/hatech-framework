package cn.com.hatechframework.server.menu.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.utils
 * @className BaseTree
 * @description 树形基类
 * @author WangMingShuai
 * @create 2020/1/21 15:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/21 15:36             1.0                         树形基类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseTree {

    @ApiModelProperty(value="主键ID", dataType = "String", example = "UUID")
    private String id;

    @ApiModelProperty(value="父类ID", dataType = "String", example = "UUID")
    private String parentId;

    @ApiModelProperty(value="子类集合", dataType = "String", example = "[{}]")
    private List<BaseTree> children;
}
