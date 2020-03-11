package cn.com.hatechframework.log.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.log.po.SystemLogPO;
import cn.com.hatechframework.log.dto.SystemLogPageDTO;
import cn.com.hatechframework.log.vo.SystemLogVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.log.mapper
 * @className ISystemLogMapper
 * @description 系统操作日志数据访问层
 * @author WangMingShuai
 * @create 2019/12/18 15:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/18 15:09             1.0                         系统操作日志数据访问层
 */
@Mapper
public interface ISystemLogMapper extends IBaseMapper<SystemLogPO> {

    /**
     * 日志分页查询
     * @param page
     * @param systemLogPageDTO
     * @return
     */
    List<SystemLogVO> findAll(Page<SystemLogVO> page, @Param("params") SystemLogPageDTO systemLogPageDTO);
}
