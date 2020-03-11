package cn.com.hatechframework.server.tenant.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.server.tenant.po.TenantDataSourcePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.mapper.tenant
 * @className ITenantDatasourceMapper
 * @description 租户数据源mapper
 * @author YeMeng
 * @create 2019/12/27 13:16
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/27 13:16             1.0                         租户数据源mapper
 */
@Mapper
public interface ITenantDatasourceMapper extends IBaseMapper<TenantDataSourcePO> {

    /**
     * 查询所有可用的租户数据源
     * @author WangMingShuai
     * @date 2020/1/7 11:02
     * @return java.util.List<cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO>
     */
    List<TenantDataSourceVO> findAllUsableDataSource();

    /**
     * 根据数据源名称查询数据源信息
     * @param   tenantName 数据源名称
     * @author WangMingShuai
     * @date 2020/1/7 11:02
     * @return cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO
     */
    TenantDataSourceVO findOneUsableDataSource(String tenantName);
}
