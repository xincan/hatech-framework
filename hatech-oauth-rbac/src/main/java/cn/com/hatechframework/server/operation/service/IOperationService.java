package cn.com.hatechframework.server.operation.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.server.operation.dto.OperationInsertDTO;
import cn.com.hatechframework.server.operation.dto.OperationPageDTO;
import cn.com.hatechframework.server.operation.dto.OperationUpdateDTO;
import cn.com.hatechframework.server.operation.po.OperationPO;
import cn.com.hatechframework.server.operation.vo.OperationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.operation.service
 * @className IOperationService
 * @description 操作按钮管理接口层
 * @author WangMingShuai
 * @create 2020/01/15 17:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 17:36             1.0                         操作按钮管理接口层
 */
public interface IOperationService extends IBaseService<OperationPO> {

    /**
     * 操作按钮分页查询
     * @param operationPageDTO  操作按钮分页条件
     * @author WangMingShuai
     * @date 2020/01/15 17:36
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.operation.vo.OperationVO>
     */
    Page<OperationVO> findPage(OperationPageDTO operationPageDTO);

    /**
     * 新增操作按钮
     * @param operationInsertDTO  操作按钮新增参数
     * @author WangMingShuai
     * @date 2020/01/15 17:36
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    int insertOperation(OperationInsertDTO operationInsertDTO);

    /**
     * 修改操作按钮
     * @param operationUpdateDTO  操作按钮修改参数
     * @author WangMingShuai
     * @date 2020/01/15 17:36
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    int updateOperation(OperationUpdateDTO operationUpdateDTO);

    /**
     * 查询操作按钮列表
     * @param
     * @author WangMingShuai
     * @date 2020/1/15 17:40
     * @return java.util.List<cn.com.hatechframework.server.operation.vo.OperationVO>
     */
    List<OperationVO> findAll();
}
