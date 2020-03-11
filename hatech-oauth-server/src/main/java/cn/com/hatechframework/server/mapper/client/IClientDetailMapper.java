package cn.com.hatechframework.server.mapper.client;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.po.ClientDetailPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-oauth-server
 * @package cn.com.hatechframework.mapper.client
 * @className IClientDetailMapper
 * @description 客户端详情mapper
 * @author YeMeng
 * @create 2019/12/18 9:39
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 9:39             1.0                         客户端详情mapper
 */
@Mapper
public interface IClientDetailMapper extends IBaseMapper<ClientDetailPO> {
}
