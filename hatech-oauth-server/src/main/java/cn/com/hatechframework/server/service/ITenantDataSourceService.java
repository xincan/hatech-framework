package cn.com.hatechframework.server.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO;
import cn.com.hatechframework.server.po.TenantDataSourcePO;

import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.service
 * @className ITenantDataSourceService
 * @description 租户数据源servive接口
 * @author YeMeng
 * @create 2019/12/27 13:25
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/27 13:25             1.0                         租户数据源servive接口
 */
public interface ITenantDataSourceService extends IBaseService<TenantDataSourcePO> {
    /**
     *  查询所有数据源
     * @author YeMeng
     * @date 2019/12/27 13:32
     * @return java.util.List<cn.com.hatechframework.entity.oauth.server.vo.TenantDataSourceVO>
     */
    List<TenantDataSourceVO> findAll();

    /**
     *  创建租户数据源
     * @param databaseName  租户id
     * @param dbUrl 数据库url
     * @param dataSourceUsername  数据源用户名
     * @param dataSourcePassword  数据源密码
     * @author YeMeng
     * @date 2019/12/28 15:39
     * @return int
     */
    int createTenantDatasource(String databaseName, String dbUrl, String dataSourceUsername, String dataSourcePassword);
}
