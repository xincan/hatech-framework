package cn.com.hatechframework.server.tenant.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.tenant.po.TenantPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.tenant.mapper
 * @className ITenantMapper
 * @description 租户mapper
 * @author YeMeng
 * @create 2019/12/28 14:25
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * YeMeng              2019/12/28 14:25             1.0                         租户mapper
 */
@Mapper
public interface ITenantMapper extends IBaseMapper<TenantPO> {
}
