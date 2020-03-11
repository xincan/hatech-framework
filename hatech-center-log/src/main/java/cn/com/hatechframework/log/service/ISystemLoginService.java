package cn.com.hatechframework.log.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.log.po.SystemLogPO;
import cn.com.hatechframework.log.dto.SystemLogPageDTO;
import cn.com.hatechframework.log.vo.SystemLogVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.log.service
 * @className ISystemLoginService
 * @description 系统操作日志接口层
 * @author WangMingShuai
 * @create 2019/12/18 15:09
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/18 15:09             1.0                         系统操作日志接口层
 */
public interface ISystemLoginService extends IBaseService<SystemLogPO> {

    /**
     *  日志分页查询
     * @param systemLogPageDTO  日志分页查询条件
     * @author WangMingShuai
     * @date 2019/12/24 17:18
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.log.vo.SystemLogVo>
     */
    Page<SystemLogVO> findAll(SystemLogPageDTO systemLogPageDTO);
}
