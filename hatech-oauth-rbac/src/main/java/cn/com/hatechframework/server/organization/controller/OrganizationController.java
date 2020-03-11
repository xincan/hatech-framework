package cn.com.hatechframework.server.organization.controller;

import cn.com.hatechframework.config.shardingjdbc.SwitchDataSource;
import cn.com.hatechframework.server.organization.dto.OrganizationInsertDTO;
import cn.com.hatechframework.server.organization.dto.OrganizationPageDTO;
import cn.com.hatechframework.server.organization.dto.OrganizationUpdateDTO;
import cn.com.hatechframework.server.organization.service.IOrganizationService;
import cn.com.hatechframework.server.organization.vo.OrganizationVO;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.organization.controller
 * @className OrganizationController
 * @description 机构信息控制层
 * @author WangMingShuai
 * @create 2019/12/27 19:36
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 19:36             1.0                         机构信息控制层
 */
@Slf4j
@Api(value = "cn.com.hatechframework.server.organization.controller.OrganizationController", tags = {"机构管理"})
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private IOrganizationService organizationService;

    @Autowired
    public OrganizationController (IOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * 机构分页查询
     * @param organizationPageDTO  机构分页条件
     * @author WangMingShuai
     * @date 2019/12/24 17:43
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="机构分页查询",httpMethod="GET",notes="根据参数分页查询机构")
    @GetMapping("/page")
    @SwitchDataSource
    public ResponseObject page(@ApiParam @Validated OrganizationPageDTO organizationPageDTO) {
        Page<OrganizationVO> page = organizationService.findPage(organizationPageDTO);
        if (page != null) {
            return ResponseResult.success("机构分页查询成功！",page.getTotal(),page.getRecords());
        }
        return ResponseResult.error("机构分页查询失败！");
    }

    /**
     * 新增机构
     * @param organizationInsertDTO  机构信息
     * @author WangMingShuai
     * @date 2019/12/24 17:43
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="新增机构",httpMethod="POST",notes="根据参数新增机构")
    @PostMapping("/insert")
    @SwitchDataSource
    public ResponseObject insert(@ApiParam @RequestBody @Validated OrganizationInsertDTO organizationInsertDTO) {
        int num = organizationService.insertOrganization(organizationInsertDTO);
        if (num > 0) {
            return ResponseResult.success("新增机构成功！",num);
        }
        return ResponseResult.error("新增机构失败！");
    }

    /**
     * 修改机构
     * @param organizationUpdateDTO  机构信息
     * @author WangMingShuai
     * @date 2019/12/24 17:44
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="修改机构",httpMethod="POST",notes="根据参数修改机构")
    @PostMapping("/update")
    @SwitchDataSource
    public ResponseObject update(@ApiParam @RequestBody @Validated OrganizationUpdateDTO organizationUpdateDTO) {
        int num = organizationService.updateOrganization(organizationUpdateDTO);
        if (num > 0) {
            return ResponseResult.success("修改机构成功！",num);
        }
        return ResponseResult.error("修改机构失败！");
    }

    /**
     * 删除机构
     * @param map  机构ids
     * @author WangMingShuai
     * @date 2019/12/24 17:44
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="删除机构",httpMethod="POST",notes="根据id删除机构，多个id逗号分隔 例如 123,456")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "机构ids", dataType = "String", required = true, paramType = "query",example = "123,456")
    })
    @PostMapping("/delete")
    @SwitchDataSource
    public ResponseObject delete(@ApiParam(value = "ids") @RequestBody Map<String, String> map) {
        String ids = map.get("ids");
        int countUser = organizationService.countOrganizationUser(ids);
        if (countUser > 0) {
            return ResponseResult.error("该组织机构下包含用户,请先删除组织机构下的用户");
        }
        int num = organizationService.deleteByIds(ids);
        if (num > 0) {
            return ResponseResult.success("删除机构成功！",num);
        }
        return ResponseResult.error("删除机构失败！");
    }

    /**
     * 查询机构树
     * @author WangMingShuai
     * @date 2019/12/24 17:45
     * @return cn.com.hatechframework.utils.response.ResponseObject
     */
    @ApiOperation(value="查询机构树",httpMethod="GET",notes="根据参数查询机构树")
    @GetMapping("/tree")
    @SwitchDataSource
    public ResponseObject tree () {
        List<OrganizationVO> list = this.organizationService.findOrganizationTree();
        if (list != null) {
            return ResponseResult.success("查询机构树成功！",list);
        }
        return ResponseResult.error("查询机构树失败！");
    }

    @ApiOperation(value = "租户组织机构导入", httpMethod = "POST", notes = "租户组织机构导入")
    @PostMapping("/ImportExcel")
    public ResponseObject importExcelTenant(MultipartFile file) {
        if (ObjectUtils.isEmpty(file)) {
            return ResponseResult.error(ResponseCode.FILE_NOT_EXIST, "操作失败,文件不存在!");
        }
        boolean res = organizationService.importFile(file);
        return res ? ResponseResult.success("操作成功") : ResponseResult.error("操作失败");
    }

}
