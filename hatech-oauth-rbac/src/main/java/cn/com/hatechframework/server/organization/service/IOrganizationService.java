package cn.com.hatechframework.server.organization.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.server.organization.dto.OrganizationInsertDTO;
import cn.com.hatechframework.server.organization.dto.OrganizationPageDTO;
import cn.com.hatechframework.server.organization.dto.OrganizationUpdateDTO;
import cn.com.hatechframework.server.organization.po.OrganizationPO;
import cn.com.hatechframework.server.organization.vo.OrganizationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.organization.service
 * @className IOrganizationService
 * @description 机构信息业务接口层
 * @author WangMingShuai
 * @create 2019/12/27 19:33
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 19:33             1.0                         机构信息业务接口层
 */
public interface IOrganizationService extends IBaseService<OrganizationPO> {

    /**
     * 机构分页查询
     * @param organizationPageDTO  机构分页条件
     * @author WangMingShuai
     * @date 2019/12/24 17:43
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.organization.vo.OrganizationVO>
     */
    Page<OrganizationVO> findPage(OrganizationPageDTO organizationPageDTO);

    /**
     * 租户注册时插入默认组织结构
     * @param userId  用户ID
     * @author YeMeng
     * @date 2020/2/5 10:19
     * @return int
     */
    OrganizationPO insertPlatformOrganization(String userId);

    /**
     * 添加机构
     * @param organizationInsertDTO  机构信息
     * @author WangMingShuai
     * @date 2019/12/24 17:46
     * @return java.lang.Integer
     */
    int insertOrganization(OrganizationInsertDTO organizationInsertDTO);

    /**
     * 修改机构
     * @param organizationUpdateDTO  机构信息
     * @author WangMingShuai
     * @date 2019/12/24 17:46
     * @return java.lang.Integer
     */
    int updateOrganization(OrganizationUpdateDTO organizationUpdateDTO);

    /**
     * 查询机构树
     * @param
     * @author WangMingShuai
     * @date 2019/12/24 17:47
     * @return java.util.List<cn.com.hatechframework.server.organization.vo.OrganizationVO>
     */
    List<OrganizationVO> findOrganizationTree();

    /**
     * 查询机构下用户个数
     * @param ids  机构ids
     * @author YeMeng
     * @date 2020/1/20 9:51
     * @return int
     */
    int countOrganizationUser(String ids);


    boolean importFile(MultipartFile file);

}
