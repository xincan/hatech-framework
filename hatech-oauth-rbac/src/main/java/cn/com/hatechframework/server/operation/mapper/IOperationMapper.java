package cn.com.hatechframework.server.operation.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.operation.dto.OperationPageDTO;
import cn.com.hatechframework.server.operation.po.OperationPO;
import cn.com.hatechframework.server.operation.vo.OperationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.operation.mapper
 * @className IOperationMapper
 * @description 操作按钮管理数据层
 * @author WangMingShuai
 * @create 2020/01/15 17:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 17:36             1.0                         操作按钮管理数据层
 */
@Mapper
public interface IOperationMapper extends IBaseMapper<OperationPO> {

    /**
     * 操作按钮分页查询
     * @param page  MP 分页
     * @param operationPageDTO  操作按钮分页条件
     * @author WangMingShuai
     * @date 2020/01/15 17:36
     * @return java.util.List<cn.com.hatechframework.server.operation.vo.OperationVO>
     */
    List<OperationVO> findAll(Page<OperationVO> page, @Param("params") OperationPageDTO operationPageDTO);

    /**
     * 查询操作按钮列表
     * @param operationVO 操作参数
     * @author WangMingShuai
     * @date 2020/1/15 17:40
     * @return java.util.List<cn.com.hatechframework.server.operation.vo.OperationVO>
     */
    List<OperationVO> findAll(@Param("params") OperationVO operationVO);

    /**
     * 根据角色获取按钮信息
     * @param roleIdList  多个角色
     * @author WangMingShuai
     * @date 2020/2/3 16:05
     * @return java.util.List<cn.com.hatechframework.server.operation.po.OperationPO>
     */
    List<OperationPO> findOperationByRoles(List<String> roleIdList);

    /**
     * 批量插入操作信息
     * @param operationList  操作集合
     * @author WangMingShuai
     * @date 2020/2/3 16:07
     * @return void
     */
    void batchInsert(List<OperationPO> operationList);
}
