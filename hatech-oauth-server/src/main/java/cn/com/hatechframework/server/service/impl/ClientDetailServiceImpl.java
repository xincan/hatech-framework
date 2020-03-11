package cn.com.hatechframework.server.service.impl;

import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.entity.oauth.server.dto.ClientDetailDTO;
import cn.com.hatechframework.server.mapper.client.IClientDetailMapper;
import cn.com.hatechframework.server.po.ClientDetailPO;
import cn.com.hatechframework.server.po.MybatisClientDetailsPO;
import cn.com.hatechframework.server.service.IClientDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.service.impl
 * @className ClientDetailsServiceImpl
 * @description 客户端详情ClientDetails实现
 * @author YeMeng
 * @create 2019/12/18 17:00
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 17:00             1.0                         客户端详情ClientDetails实现
 */
@Slf4j
@Service("clientDetailService")
public class ClientDetailServiceImpl extends AbstractService<MybatisClientDetailsPO> implements IClientDetailService {

    @Resource
    private IClientDetailMapper clientDetailMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ClientDetailServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     *  添加客户端详情
     * @param clientDetailDTO  客户端详情
     * @author YeMeng
     * @date 2019/12/24 19:34
     * @return boolean
     */
    @Override
    public boolean addClientDetail(ClientDetailDTO clientDetailDTO) {
        ClientDetailPO clientDetail = new ClientDetailPO();
        BeanUtils.copyProperties(clientDetailDTO, clientDetail);
        QueryWrapper<ClientDetailPO> queryWrapper = new QueryWrapper<>();
        log.info("查询客户端id: {}", clientDetail.getClientId());
        queryWrapper.lambda().eq(ClientDetailPO::getClientId, clientDetail.getClientId());
        int client = clientDetailMapper.selectCount(queryWrapper);
        if (client > 0) {
            return true;
        }
        clientDetail.setClientSecret(bCryptPasswordEncoder.encode(clientDetail.getClientSecret()));
        int res = clientDetailMapper.insert(clientDetail);
        return res > 0;
    }

}
