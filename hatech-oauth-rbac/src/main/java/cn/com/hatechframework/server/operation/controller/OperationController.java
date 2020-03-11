package cn.com.hatechframework.server.operation.controller;

import cn.com.hatechframework.config.shardingjdbc.SwitchDataSource;
import cn.com.hatechframework.server.operation.dto.OperationInsertDTO;
import cn.com.hatechframework.server.operation.dto.OperationPageDTO;
import cn.com.hatechframework.server.operation.dto.OperationUpdateDTO;
import cn.com.hatechframework.server.operation.service.IOperationService;
import cn.com.hatechframework.server.operation.vo.OperationVO;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.operation.controller
 * @className OperationController
 * @description 操作按钮管理控制层
 * @author WangMingShuai
 * @create 2020/01/15 17:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/15 17:36             1.0                         操作按钮管理控制层
 */
@Api(value = "cn.com.hatechframework.server.operation.controller.OperationController", tags = {"操作按钮管理"})
@RestController
@RequestMapping("/operation")
@Slf4j
public class OperationController {

	private IOperationService operationService;

	@Autowired
	public OperationController(IOperationService operationService) {
		this.operationService = operationService;
	}

	/**
     * 操作按钮分页查询
     * @param operationPageDTO  操作按钮分页条件
     * @author WangMingShuai
     * @date 2020/01/15 17:36
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
	@ApiOperation(value="操作按钮分页查询",httpMethod="GET",notes="根据参数分页查询操作按钮")
	@GetMapping("/page")
	@SwitchDataSource
	public ResponseObject page(@ApiParam @Validated OperationPageDTO operationPageDTO) {
		Page<OperationVO> page = operationService.findPage(operationPageDTO);
		if (page != null) {
			return ResponseResult.success("操作按钮分页查询成功！",page.getTotal(),page.getRecords());
		}
		return ResponseResult.error("操作按钮分页查询失败！");
	}

	/**
     * 查询操作按钮列表
	 * @author WangMingShuai
	 * @date 2020/1/15 17:39
	 * @return cn.com.hatechframework.utils.response.ResponseObject
	 */
	@ApiOperation(value="查询操作按钮列表",httpMethod="GET",notes="查询操作按钮列表")
	@GetMapping("/list")
	@SwitchDataSource
	public ResponseObject list () {
		List<OperationVO> list = this.operationService.findAll();
		return ResponseResult.success("查询操作按钮列表成功",list);
	}

	/**
     * 新增操作按钮
     * @param operationInsertDTO  操作按钮新增参数
     * @author WangMingShuai
     * @date 2020/01/15 17:36
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
	@ApiOperation(value="新增操作按钮",httpMethod="POST",notes="根据新增参数添加操作按钮")
	@PostMapping("/insert")
	@SwitchDataSource
	public ResponseObject insert(@ApiParam @RequestBody @Validated OperationInsertDTO operationInsertDTO) {
		int num = operationService.insertOperation(operationInsertDTO);
		if (num > 0) {
			return ResponseResult.success("新增操作按钮成功！",num);
		}
		return ResponseResult.error("新增操作按钮失败！");
	}

	/**
     * 修改操作按钮
     * @param operationUpdateDTO  操作按钮修改参数
     * @author WangMingShuai
     * @date 2020/01/15 17:36
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
	@ApiOperation(value="修改操作按钮",httpMethod="POST",notes="根据修改参数修改操作按钮")
	@PostMapping("/update")
	@SwitchDataSource
	public ResponseObject update(@ApiParam @RequestBody @Validated OperationUpdateDTO operationUpdateDTO) {
		int num = operationService.updateOperation(operationUpdateDTO);
		if (num > 0) {
			return ResponseResult.success("修改操作按钮成功！",num);
		}
		return ResponseResult.error("修改操作按钮失败！");
	}


	/**
     * 删除操作按钮
     * @param ids  操作按钮ids
     * @author WangMingShuai
     * @date 2020/01/15 17:36
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
	@ApiOperation(value="删除操作按钮",httpMethod="DELETE",notes="根据id删除操作按钮，多个id逗号分隔 例如 123,456")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ids", value = "操作按钮ids", dataType = "String", required = true, paramType = "query",example = "123,456")
	})
	@DeleteMapping("/delete")
	@SwitchDataSource
	public ResponseObject delete(@RequestParam(value = "ids") String ids) {
		int num = operationService.deleteByIds(ids);
		if (num > 0) {
			return ResponseResult.success("删除操作按钮成功！",num);
		}
		return ResponseResult.error("删除操作按钮失败！");
	}

}
