package cn.com.hatechframework.server.menu.service.impl;

import cn.com.hatechframework.server.menu.dto.MenuOperationInsertDTO;
import cn.com.hatechframework.server.menu.mapper.IMenuOperationMapper;
import cn.com.hatechframework.server.menu.po.MenuOperationPO;
import cn.com.hatechframework.server.menu.service.IMenuOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.service.impl
 * @className MenuOperationServiceImpl
 * @description 菜单操作关系管理接口实现层
 * @author WangMingShuai
 * @create 2020/01/15 16:20
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 16:20             1.0                         菜单操作关系管理接口实现层
 */
@Service("menuOperationService")
@Slf4j
public class MenuOperationServiceImpl extends ServiceImpl<IMenuOperationMapper,MenuOperationPO> implements IMenuOperationService {

	@Resource
	private IMenuOperationMapper menuOperationMapper;

	/**
     * 新增菜单操作关系表
	 * @param menuOperationInsertDTO  菜单操作关系表新增参数
	 * @author WangMingShuai
	 * @date 2020/01/15 16:20
	 * @return boolean
	 */
	@Override
	@GlobalTransactional
	public boolean insertMenuOperation(MenuOperationInsertDTO menuOperationInsertDTO) {
		List<String> hasOperationIds = menuOperationMapper.findRelationOperationIds(menuOperationInsertDTO.getMenuId());
		List<String> hasListDifference = findListDifference(hasOperationIds,menuOperationInsertDTO.getOperationIds());
		if (!CollectionUtils.isEmpty(hasListDifference)) {
			menuOperationMapper.deleteMenuOperation(menuOperationInsertDTO.getMenuId(),hasListDifference);
		}
		List<String> insertListDifference = findListDifference(menuOperationInsertDTO.getOperationIds(),hasOperationIds);
		if (!CollectionUtils.isEmpty(insertListDifference)) {
			List<MenuOperationPO> batchSaveMenuOperationList = Lists.newArrayList();
			insertListDifference.forEach(operationId -> batchSaveMenuOperationList.add(MenuOperationPO.builder()
					.menuId(menuOperationInsertDTO.getMenuId())
					.operationId(operationId)
					.build()));
			this.saveBatch(batchSaveMenuOperationList);
		}
		return true;
	}

	/**
     * 根据菜单id获取，菜单下的按钮信息
	 * @param menuId  菜单ID
	 * @author WangMingShuai
	 * @date 2020/1/15 16:54
	 * @return java.util.List<java.lang.String>
	 */
	@Override
	public List<String> findRelationOperationIds(String menuId) {
		return this.menuOperationMapper.findRelationOperationIds(menuId);
	}

	/**
     * 查询源集合和目标集合的不同
	 * @param sourceList  源集合
	 * @param targetList  目标集合
	 * @author WangMingShuai
	 * @date 2020/1/18 16:05
	 * @return java.util.List<java.lang.String>
	 */
	private List<String> findListDifference (List<String> sourceList,List<String> targetList) {
		return sourceList.stream().filter(source -> !targetList.contains(source)).collect(Collectors.toList());
	}

}
