package cn.com.hatechframework.server.service;

import cn.com.hatechframework.data.universal.IBaseService;
import cn.com.hatechframework.entity.oauth.server.dto.ClientDetailDTO;
import cn.com.hatechframework.server.po.MybatisClientDetailsPO;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.service
 * @className ClientDetailService
 * @description 客户端详情ClientDetails接口
 * @author YeMeng
 * @create 2019/12/18 17:02
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 17:02             1.0                         客户端详情ClientDetails接口
 */
public interface IClientDetailService extends IBaseService<MybatisClientDetailsPO> {

    /**
     *  添加客户端详情
     * @param clientDetailDTO  客户端详情
     * @author YeMeng
     * @date 2019/12/24 19:34
     * @return boolean
     */
    boolean addClientDetail(ClientDetailDTO clientDetailDTO);
}
