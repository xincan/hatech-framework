package cn.com.hatechframework.log.controller;

import cn.com.hatechframework.entity.center.log.dto.SystemLogSaveDTO;
import cn.com.hatechframework.log.dto.SystemLogPageDTO;
import cn.com.hatechframework.log.po.SystemLogPO;
import cn.com.hatechframework.log.service.ISystemLoginService;
import cn.com.hatechframework.log.vo.SystemLogVO;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.log.controller
 * @className SystemLogController
 * @description 日志管理控制层
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/20 17:03             1.0                         日志管理控制层
 */
@Api(value = "cn.com.hatechframework.log.controller.SystemLogController", tags = {"日志管理"})
@RestController
@RequestMapping("system")
@Slf4j
public class SystemLogController {

    private ISystemLoginService systemLoginService;

    @Autowired
    public SystemLogController (ISystemLoginService systemLoginService) {
        this.systemLoginService = systemLoginService;
    }

    /**
     *  添加日志信息
     * @param systemLogSaveDTO  添加日志信息
     * @author WangMingShuai
     * @date 2019/12/24 16:42
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="添加日志信息",httpMethod="POST",notes="根据参数添加日志信息")
    @PostMapping("/insert")
    public ResponseObject insert(@ApiParam @RequestBody @Validated SystemLogSaveDTO systemLogSaveDTO) {
        SystemLogPO systemLog = OrikaUtils.map(systemLogSaveDTO, SystemLogPO.class);
        int num = this.systemLoginService.insert(systemLog);
        if (num > 0) {
            return ResponseResult.success("添加日志信息成功！",num);
        }
        return ResponseResult.error("添加日志信息失败！");
    }

    /**
     *  日志分页查询
     * @param systemLogPageDTO  日志分页查询条件
     * @author WangMingShuai
     * @date 2019/12/24 16:43
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value = "日志分页查询", httpMethod = "GET", notes = "根据参数分页查询日志")
    @GetMapping("/page")
    public ResponseObject page (@ApiParam @Validated SystemLogPageDTO systemLogPageDTO) {
        Page<SystemLogVO> page = systemLoginService.findAll(systemLogPageDTO);
        if (page != null) {
            return ResponseResult.success("日志分页查询成功！",page.getTotal(),page.getRecords());
        }
        return ResponseResult.error("日志分页查询失败！");
    }

}
