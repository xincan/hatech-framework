package cn.com.hatechframework.server.menu.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.po
 * @className MenuPO
 * @description 菜单实体类
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         菜单实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "menu")
public class MenuPO {

    @TableId(type = IdType.UUID)
    @TableField("id")
    private String id;

    @TableField("menu_name")
    private String menuName;

    @TableField("path")
    private String path;

    @TableField("code")
    private String code;

    @TableField("parent_id")
    private String parentId;

    @TableField("icon")
    private String icon;

    @TableField("params")
    private String params;

    @TableField("level")
    private Integer level;

    @TableField("order_info")
    private Integer orderInfo;

    @TableField("edit_user_id")
    private String editUserId;

    @TableField(value = "edit_time", fill = FieldFill.UPDATE)
    private Date editTime;
}
