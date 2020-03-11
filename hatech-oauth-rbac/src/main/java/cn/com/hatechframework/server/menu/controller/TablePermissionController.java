package cn.com.hatechframework.server.menu.controller;

import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.menu.controller
 * @className TablePermissionController
 * @description 表格权限控制层
 * @author WangMingShuai
 * @create 2020/1/15 9:34
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/1/15 9:34             1.0                         表格权限控制层
 */
@Slf4j
@RestController
@RequestMapping("/tableCell")
public class TablePermissionController {

    @PostMapping("/insert")
    public ResponseObject insert () {
        return ResponseResult.success("查询无结果",0,null);
    }

    @GetMapping("/select")
    public ResponseObject select () {
        return ResponseResult.success("查询无结果",0,null);
    }
}
