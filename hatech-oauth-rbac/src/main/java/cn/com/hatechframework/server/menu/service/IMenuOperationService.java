package cn.com.hatechframework.server.menu.service;

import cn.com.hatechframework.server.menu.dto.MenuOperationInsertDTO;
import cn.com.hatechframework.server.menu.po.MenuOperationPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.service
 * @className IMenuOperationService
 * @description 菜单操作关系管理接口层
 * @author WangMingShuai
 * @create 2020/01/15 16:20
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 16:20             1.0                         菜单操作关系管理接口层
 */
public interface IMenuOperationService extends IService<MenuOperationPO> {

    /**
     * 新增菜单操作关系表
     * @param menuOperationInsertDTO  菜单操作关系表新增参数
     * @author WangMingShuai
     * @date 2020/01/15 16:20
     * @return boolean
     */
    boolean insertMenuOperation(MenuOperationInsertDTO menuOperationInsertDTO);

    /**
     * 根据菜单id获取，菜单下的按钮信息
     * @param menuId  菜单ID
     * @author WangMingShuai
     * @date 2020/1/15 16:54
     * @return java.util.List<java.lang.String>
     */
    List<String> findRelationOperationIds(String menuId);
}
