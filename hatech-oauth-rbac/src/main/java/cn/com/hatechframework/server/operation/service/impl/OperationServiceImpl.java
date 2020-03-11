package cn.com.hatechframework.server.operation.service.impl;

import cn.com.hatechframework.data.page.Pagination;
import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.server.operation.dto.OperationInsertDTO;
import cn.com.hatechframework.server.operation.dto.OperationPageDTO;
import cn.com.hatechframework.server.operation.dto.OperationUpdateDTO;
import cn.com.hatechframework.server.operation.mapper.IOperationMapper;
import cn.com.hatechframework.server.operation.po.OperationPO;
import cn.com.hatechframework.server.operation.service.IOperationService;
import cn.com.hatechframework.server.operation.vo.OperationVO;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.operation.service.impl
 * @className OperationServiceImpl
 * @description 操作按钮管理接口实现层
 * @author WangMingShuai
 * @create 2020/01/15 17:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 17:36             1.0                         操作按钮管理接口实现层
 */
@Service("operationService")
@Slf4j
public class OperationServiceImpl extends AbstractService<OperationPO> implements IOperationService {

	@Resource
	private IOperationMapper operationMapper;

	/**
     * 操作按钮分页查询
	 * @param operationPageDTO  操作按钮分页条件
	 * @author WangMingShuai
	 * @date 2020/01/15 17:36
	 * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.operation.vo.OperationVO>
	 */
	@Override
	public Page<OperationVO> findPage(OperationPageDTO operationPageDTO) {
		Page<OperationVO> page = Pagination.page(operationPageDTO);
		List<OperationVO> list = operationMapper.findAll(page,operationPageDTO);
		page.setRecords(list);
		return page;
	}

	/**
     * 新增操作按钮
	 * @param operationInsertDTO  操作按钮新增参数
	 * @author WangMingShuai
	 * @date 2020/01/15 17:36
	 * @return cn.com.hatechframework.utils.response.ResponseObject
	 */
	@Override
	public int insertOperation(OperationInsertDTO operationInsertDTO) {
		OperationPO operation = OrikaUtils.map(operationInsertDTO, OperationPO.class);
		operation.setEditTime(new Date());
		return this.operationMapper.insert(operation);
	}

	/**
     * 修改操作按钮
	 * @param operationUpdateDTO  操作按钮修改参数
	 * @author WangMingShuai
	 * @date 2020/01/15 17:36
	 * @return cn.com.hatechframework.utils.response.ResponseObject
	 */
	@Override
	public int updateOperation(OperationUpdateDTO operationUpdateDTO) {
		OperationPO operation = OrikaUtils.map(operationUpdateDTO, OperationPO.class);
		operation.setEditTime(new Date());
		return this.operationMapper.updateById(operation);
	}

	/**
     * 查询操作按钮列表
	 * @param
	 * @author WangMingShuai
	 * @date 2020/1/15 17:40
	 * @return java.util.List<cn.com.hatechframework.server.operation.vo.OperationVO>
	 */
	@Override
	public List<OperationVO> findAll() {
		return this.operationMapper.findAll(new OperationVO());
	}

}
