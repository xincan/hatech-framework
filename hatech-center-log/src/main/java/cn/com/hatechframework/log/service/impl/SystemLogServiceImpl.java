package cn.com.hatechframework.log.service.impl;

import cn.com.hatechframework.data.page.Pagination;
import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.log.po.SystemLogPO;
import cn.com.hatechframework.log.mapper.ISystemLogMapper;
import cn.com.hatechframework.log.dto.SystemLogPageDTO;
import cn.com.hatechframework.log.service.ISystemLoginService;
import cn.com.hatechframework.log.vo.SystemLogVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.log.service.impl
 * @className SystemLogServiceImpl
 * @description 系统操作日志接口实现层
 * @author WangMingShuai
 * @create 2019/12/18 15:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/18 15:09             1.0                         系统操作日志接口实现层
 */
@Service("systemLoginService")
public class SystemLogServiceImpl extends AbstractService<SystemLogPO> implements ISystemLoginService {

    @Resource
    private ISystemLogMapper systemLogMapper;

    /**
     *  日志分页查询
     * @param systemLogPageDTO  日志分页查询条件
     * @author WangMingShuai
     * @date 2019/12/24 17:18
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.log.vo.SystemLogVo>
     */
    @Override
    public Page<SystemLogVO> findAll(SystemLogPageDTO systemLogPageDTO) {
        Page<SystemLogVO> page = Pagination.page(systemLogPageDTO);
        List<SystemLogVO> list = systemLogMapper.findAll(page,systemLogPageDTO);
        page.setRecords(list);
        return page;
    }
}
