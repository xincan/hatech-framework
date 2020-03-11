package cn.com.hatechframework.server.mapper.tenant;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.po.TenantDataSourcePO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.mapper.tenant
 * @className ITenantDatasourceMapper
 * @description 租户数据源mapper
 * @author YeMeng
 * @create 2019/12/27 13:16
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/27 13:16             1.0                         租户数据源mapper
 */
@Mapper
public interface ITenantDatasourceMapper extends IBaseMapper<TenantDataSourcePO> {

}
