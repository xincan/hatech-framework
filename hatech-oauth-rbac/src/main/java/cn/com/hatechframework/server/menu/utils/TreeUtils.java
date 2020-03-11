package cn.com.hatechframework.server.menu.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.utils
 * @className TreeUtils
 * @description 树形工具类
 * @author WangMingShuai
 * @create 2020/1/21 15:33
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/21 15:33             1.0                         树形工具类
 */
public class TreeUtils {

    private TreeUtils(){}

    /**
     * 递归循环获得树结构
     * @param list  菜单集合
     * @param rootNodeId  根节点id
     * @author WangMingShuai
     * @date 2019/12/24 17:48
     * @return java.util.List<T>
     */
    public static <T extends BaseTree> List<T> listToTree (List<T> list,String rootNodeId) {
        List<T> treeList = Lists.newArrayList();
        for (T node : list) {
            if (rootNodeId.equals(node.getParentId())) {
                treeList.add(findChildren(node, list));
            }
        }
        return treeList;
    }

    /**
     * 获取目标节点的子节点
     * @param targetNode  目标节点
     * @param list  节点集合
     * @author WangMingShuai
     * @date 2020/2/4 13:37
     * @return T
     */
    private static <T extends BaseTree> T findChildren(T targetNode, List<T> list) {
        for (T node : list) {
            if (node.getParentId().equals(targetNode.getId())) {
                if (targetNode.getChildren() == null) {
                    targetNode.setChildren(Lists.newArrayList());
                }
                targetNode.getChildren().add(findChildren(node, list));
            }
        }
        return targetNode;
    }
}
