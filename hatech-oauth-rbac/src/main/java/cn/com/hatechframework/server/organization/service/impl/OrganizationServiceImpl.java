package cn.com.hatechframework.server.organization.service.impl;

import cn.com.hatechframework.config.exception.BusinessException;
import cn.com.hatechframework.data.page.Pagination;
import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.server.menu.utils.TreeUtils;
import cn.com.hatechframework.server.organization.dto.OrganizationInsertDTO;
import cn.com.hatechframework.server.organization.dto.OrganizationPageDTO;
import cn.com.hatechframework.server.organization.dto.OrganizationUpdateDTO;
import cn.com.hatechframework.server.organization.mapper.IOrganizationMapper;
import cn.com.hatechframework.server.organization.po.OrganizationPO;
import cn.com.hatechframework.server.organization.service.IOrganizationService;
import cn.com.hatechframework.server.organization.vo.OrganizationVO;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.statics.FileType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.organization.service.impl
 * @className OrganizationServiceImpl
 * @description 机构信息业务接口实现层
 * @author WangMingShuai
 * @create 2019/12/27 19:34
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 19:34             1.0                         机构信息业务接口实现层
 */
@Service("organizationService")
public class OrganizationServiceImpl extends AbstractService<OrganizationPO> implements IOrganizationService {

    private static final String DEFAULT_PARENT_ID = "0";

    @Resource
    private IOrganizationMapper organizationMapper;

    /**
     * 机构分页查询
     * @param organizationPageDTO  机构分页条件
     * @author WangMingShuai
     * @date 2019/12/24 17:43
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.organization.vo.OrganizationVO>
     */
    @Override
    public Page<OrganizationVO> findPage(OrganizationPageDTO organizationPageDTO) {
        Page<OrganizationVO> page = Pagination.page(organizationPageDTO);
        List<OrganizationVO> list = organizationMapper.findAll(page,organizationPageDTO);
        page.setRecords(list);
        return page;
    }

    /**
     * 查询机构树
     * @param
     * @author WangMingShuai
     * @date 2019/12/24 17:47
     * @return java.util.List<cn.com.hatechframework.server.organization.vo.OrganizationVO>
     */
    @Override
    public List<OrganizationVO> findOrganizationTree() {
        List<OrganizationVO> list = this.organizationMapper.findAll(new OrganizationVO());
        return TreeUtils.listToTree(list, DEFAULT_PARENT_ID);
    }

    /**
     * 租户注册时插入默认组织结构
     * @author YeMeng
     * @date 2020/2/5 10:19
     * @return int
     */
    @Override
    public OrganizationPO insertPlatformOrganization(String userId) {
        OrganizationPO organization = OrganizationPO.builder()
                .name("组织架构")
                .parentId("0")
                .status(1)
                .editUserId(userId)
                .editTime(new Date())
                .build();
        organizationMapper.insert(organization);
        return organization;
    }


    /**
     * 查询相同父节点下是否有同名的组织机构
     * @param organization  机构信息
     * @author YeMeng
     * @date 2020/2/20 16:39
     * @return int
     */
    private int findOrganizationCount(OrganizationPO organization) {
        QueryWrapper<OrganizationPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(OrganizationPO::getName, organization.getName())
                .eq(OrganizationPO::getParentId, organization.getParentId());
        if (!StringUtils.isEmpty(organization.getId())) {
            queryWrapper.lambda().ne(OrganizationPO::getId, organization.getId());
        }
        return organizationMapper.selectCount(queryWrapper);
    }

    /**
     * 添加机构
     * @param organizationInsertDTO  机构信息
     * @author WangMingShuai
     * @date 2019/12/24 17:46
     * @return java.lang.Integer
     */
    @Override
    public int insertOrganization(OrganizationInsertDTO organizationInsertDTO) {
        OrganizationPO organization = OrikaUtils.map(organizationInsertDTO, OrganizationPO.class);
        if (findOrganizationCount(organization) > 0) {
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(), "同级别下有相同名称的组织机构!");
        }
        return this.organizationMapper.insert(initMenu(organization));
    }

    /**
     * 修改机构
     * @param organizationUpdateDTO  机构信息
     * @author WangMingShuai
     * @date 2019/12/24 17:46
     * @return java.lang.Integer
     */
    @Override
    public int updateOrganization(OrganizationUpdateDTO organizationUpdateDTO) {
        OrganizationPO organization = OrikaUtils.map(organizationUpdateDTO, OrganizationPO.class);
        if (findOrganizationCount(organization) > 0) {
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(), "同级别下有相同名称的组织机构!");
        }
        return this.organizationMapper.updateById(initMenu(organization));
    }

    /**
     * 查询机构下用户个数
     * @param ids  机构ids
     * @author YeMeng
     * @date 2020/1/20 9:51
     * @return int
     */
    @Override
    public int countOrganizationUser(String ids) {
        List<String> orgIds = Arrays.asList(ids.split(","));
        return organizationMapper.countOrganizationUser(orgIds);
    }

    /**
     * 机构添加修改前数据封装
     * @param organization  机构
     * @author WangMingShuai
     * @date 2020/1/21 15:31
     * @return cn.com.hatechframework.server.organization.po.OrganizationPO
     */
    private OrganizationPO initMenu (OrganizationPO organization) {
        if (StringUtils.isEmpty(organization.getParentId()) || DEFAULT_PARENT_ID.equals(organization.getParentId())) {
            organization.setParentId(DEFAULT_PARENT_ID);
        } else {
            OrganizationPO parentMenu = this.organizationMapper.selectById(organization.getParentId());
            if (parentMenu == null) {
                throw new BusinessException(ResponseCode.PARAM_ERROR.code(),"参数错误：parentId 不存在");
            }
        }
        return organization;
    }


    @Override
    public boolean importFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (!StringUtils.isEmpty(fileName) &&
                !fileName.endsWith(FileType.EXCEL_XLS) && !fileName.endsWith(FileType.EXCEL_XLSX) ) {
            throw new BusinessException(ResponseCode.FILE_TYPE_INVALID.code(), "操作失败，文件格式不正确");
        }



        return true;
    }
}
