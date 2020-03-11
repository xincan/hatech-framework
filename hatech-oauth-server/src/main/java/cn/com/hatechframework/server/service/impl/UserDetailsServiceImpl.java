package cn.com.hatechframework.server.service.impl;

import cn.com.hatechframework.config.exception.BusinessException;
import cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO;
import cn.com.hatechframework.entity.oauth.rbac.vo.UserVO;
import cn.com.hatechframework.server.feign.IFUserDetailsService;
import cn.com.hatechframework.server.mapper.user.IUserMapper;
import cn.com.hatechframework.server.po.RolePO;
import cn.com.hatechframework.server.po.TenantPO;
import cn.com.hatechframework.server.po.UserPO;
import cn.com.hatechframework.utils.bean.OrikaUtils;
import cn.com.hatechframework.utils.context.BaseContextHandler;
import cn.com.hatechframework.utils.response.ResponseCode;
import cn.com.hatechframework.utils.response.ResponseObject;
import cn.com.hatechframework.utils.statics.DataKeyPrefix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.service.impl
 * @className UserDetailsServiceImpl
 * @description 查询用户信息
 * @author YeMeng
 * @create 2019/12/18 17:00
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 17:00             1.0                        查询用户信息
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 注入user mapper
     */
    @Resource
    private IUserMapper userMapper;

    /**
     * 注入feign调用rbac的/user/findUserByUsername请求
     */
    private IFUserDetailsService fUserDetailsService;

    public UserDetailsServiceImpl(IFUserDetailsService fUserDetailsService) {
        this.fUserDetailsService = fUserDetailsService;
    }


    /**
     * 根据用户名查询用户详情
     * @param username 用户名
     * @author YeMeng
     * @date 2020/2/13 14:45
     * @return org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // 查询用户所属租户信息
        List<TenantPO> tenants = userMapper.findTenantByUsername(username);
        if (tenants == null || tenants.isEmpty()) {
            throw new BusinessException(ResponseCode.USER_NOT_EXIST, "用户 "+username+" 不存在");
        }
        String tenantNames = tenants.stream().map(TenantPO::getId).collect(Collectors.joining(","));
        log.info("查询用户及其角色信息, 用户:{}, 租户:{}", username, DataKeyPrefix.TENANT_DATASOURCE_PREFIX+tenantNames);
        ResponseObject<UserVO> userResp = fUserDetailsService.findUserByUsername(username, DataKeyPrefix.TENANT_DATASOURCE_PREFIX+tenantNames);
        if (userResp.getCode() != ResponseCode.REQUEST_SUCCESS.code()) {
            throw new BusinessException(ResponseCode.USER_NOT_EXIST, userResp.getMsg());
        }
        UserVO userVO = userResp.getData();
        if (userVO.getStatus() != DataKeyPrefix.USER_ENABLED) {
            throw new BusinessException(ResponseCode.USER_UNUSED, userVO.getUsername());
        }
        OrikaUtils.registerClassMap(RoleVO.class, RolePO.class);
        UserPO user = OrikaUtils.map(userVO, UserPO.class);
        user.setTenantList(tenants);

        BaseContextHandler.setUser(userVO);
        return user;
    }
}
