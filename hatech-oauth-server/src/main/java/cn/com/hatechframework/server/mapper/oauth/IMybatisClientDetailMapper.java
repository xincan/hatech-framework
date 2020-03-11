package cn.com.hatechframework.server.mapper.oauth;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.po.MybatisClientDetailsPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-oauth-server
 * @package cn.com.hatechframework.mapper.oauth
 * @className IMybatisClientDetailMapper
 * @description Mybatis客户端详情
 * @author YeMeng
 * @create 2019/12/18 9:39
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 9:39             1.0                         Mybatis客户端详情
 */
@Mapper
public interface IMybatisClientDetailMapper extends IBaseMapper<MybatisClientDetailsPO> {
}
