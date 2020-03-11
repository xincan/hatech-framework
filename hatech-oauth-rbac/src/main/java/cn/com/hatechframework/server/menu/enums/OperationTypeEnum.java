package cn.com.hatechframework.server.menu.enums;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.enums
 * @className MenuTypeEnum
 * @description 操作类型枚举类
 * @author WangMingShuai
 * @create 2020/1/21 15:01
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/21 15:01             1.0                         操作类型枚举类
 */
public enum OperationTypeEnum {

    /**
     * 表格头部
     * */
    TABLE_HEADER("table-header","【表格头部】"),
    /**
     * 表格内部
     * */
    TABLE_INNER("table-inner","【表格内部】"),
    /**
     * 左侧树头部
     * */
    LEFT_TREE_HEADER("left-tree-header","【左侧树头部】"),
    /**
     * 其他
     * */
    OTHER("other","【其他】");

    private String type;
    private String name;

    OperationTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public static String getNameByType (String type) {
        for (OperationTypeEnum operationType : OperationTypeEnum.values()) {
            if (operationType.getType().equals(type)) {
                return operationType.getName();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
