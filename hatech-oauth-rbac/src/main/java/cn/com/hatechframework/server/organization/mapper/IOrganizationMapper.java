package cn.com.hatechframework.server.organization.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.organization.dto.OrganizationPageDTO;
import cn.com.hatechframework.server.organization.po.OrganizationPO;
import cn.com.hatechframework.server.organization.vo.OrganizationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.organization.mapper
 * @className IOrganizationMapper
 * @description 机构信息数据层
 * @author WangMingShuai
 * @create 2019/12/27 19:32
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 19:32             1.0                         机构信息数据层
 */
@Mapper
public interface IOrganizationMapper extends IBaseMapper<OrganizationPO> {

    /**
     * 机构分页查询
     * @param page
     * @param organizationPageDTO  分页参数
     * @author WangMingShuai
     * @date 2020/1/7 11:33
     * @return java.util.List<cn.com.hatechframework.server.organization.vo.OrganizationVO>
     */
    List<OrganizationVO> findAll(Page<OrganizationVO> page, @Param("params") OrganizationPageDTO organizationPageDTO);

    /**
     * 根据参数查询机构信息
     * @param organizationVO  查询参数
     * @author WangMingShuai
     * @date 2020/1/7 11:33
     * @return java.util.List<cn.com.hatechframework.server.organization.vo.OrganizationVO>
     */
    List<OrganizationVO> findAll(@Param("params") OrganizationVO organizationVO);


    /**
     * 查询组织机构下用户个数
     * @param ids  组织机构id
     * @author YeMeng
     * @date 2020/1/20 9:58
     * @return java.lang.Integer
     */
    Integer countOrganizationUser(@Param("list")List<String> ids);
}
