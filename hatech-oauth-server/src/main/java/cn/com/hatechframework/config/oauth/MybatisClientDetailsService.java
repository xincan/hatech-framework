package cn.com.hatechframework.config.oauth;

import cn.com.hatechframework.server.mapper.oauth.IMybatisClientDetailMapper;
import cn.com.hatechframework.server.po.MybatisClientDetailsPO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.oauth
 * @className MybatisClientDetailsService
 * @description 替换掉原spring的datasource, 查询方式需要改变为mybatis plus查询
 * @author YeMeng
 * @create 2019/12/20 18:33
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/20 18:33             1.0                        替换掉原spring的datasource, 查询方式需要改变为mybatis plus查询
 */
public class MybatisClientDetailsService extends JdbcClientDetailsService {

    /**
     * mybatis plus客户端查询mapper
      */
    private IMybatisClientDetailMapper mybatisClientDetailMapper;

    public MybatisClientDetailsService(DataSource dataSource, IMybatisClientDetailMapper mybatisClientDetailMapper) {
        super(dataSource);
        this.mybatisClientDetailMapper = mybatisClientDetailMapper;
    }

    /**
     *  根据客户端clientId查询客户端详情
     * @param clientId 客户端clientId
     * @author YeMeng
     * @date 2019/12/24 17:51
     * @return org.springframework.security.oauth2.provider.ClientDetails
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        ClientDetails details;
        QueryWrapper<MybatisClientDetailsPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MybatisClientDetailsPO::getClientId, clientId);
        details = mybatisClientDetailMapper.selectOne(queryWrapper);
        if (details == null) {
            throw new NoSuchClientException("没有此id: " + clientId + "的客户端存在");
        }
        return details;
    }

}
