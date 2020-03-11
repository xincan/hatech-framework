package cn.com.hatechframework.server.role.service.impl;

import cn.com.hatechframework.config.exception.BusinessException;
import cn.com.hatechframework.data.page.Pagination;
import cn.com.hatechframework.data.universal.AbstractService;
import cn.com.hatechframework.server.role.dto.RoleGroupPageDTO;
import cn.com.hatechframework.server.role.mapper.IRoleGroupMapper;
import cn.com.hatechframework.server.role.po.RoleGroupPO;
import cn.com.hatechframework.server.role.po.RoleGroupRolePO;
import cn.com.hatechframework.server.role.po.RoleGroupUserPO;
import cn.com.hatechframework.server.role.service.IRoleGroupRoleService;
import cn.com.hatechframework.server.role.service.IRoleGroupService;
import cn.com.hatechframework.server.role.service.IRoleGroupUserService;
import cn.com.hatechframework.server.role.vo.RoleGroupVO;
import cn.com.hatechframework.utils.response.ResponseCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.service.impl
 * @className RoleGroupServiceImpl
 * @description 用户组业务接口实现层
 * @author WangMingShuai
 * @create 2019/12/27 15:06
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/27 15:06             1.0                         用户组业务接口实现层
 */
@Service("roleGroupService")
public class RoleGroupServiceImpl extends AbstractService<RoleGroupPO> implements IRoleGroupService {

    @Resource
    private IRoleGroupMapper roleGroupMapper;

    /**
     * 角色组角色
     */
    private final IRoleGroupRoleService roleGroupRoleService;

    /**
     * 角色组用户
     */
    private final IRoleGroupUserService roleGroupUserService;

    public RoleGroupServiceImpl(IRoleGroupRoleService roleGroupRoleService, IRoleGroupUserService roleGroupUserService) {
        this.roleGroupRoleService = roleGroupRoleService;
        this.roleGroupUserService = roleGroupUserService;
    }

    /**
     * 角色组分页
     * @param roleGroupPageDTO  分页参数
     * @author WangMingShuai
     * @date 2019/12/27 15:19
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.role.vo.RoleGroupVO>
     */
    @Override
    public Page<RoleGroupVO> findPage(RoleGroupPageDTO roleGroupPageDTO) {
        Page<RoleGroupVO> page = Pagination.page(roleGroupPageDTO);
        List<RoleGroupVO> list = this.roleGroupMapper.findAll(page,roleGroupPageDTO);
        page.setRecords(list);
        return page;
    }


    /**
     * 查询同名的角色组个数
     * @param roleGroup 角色组信息
     * @author YeMeng
     * @date 2020/2/20 16:47
     * @return int
     */
    private int findRoleGroupCount(RoleGroupPO roleGroup) {
        QueryWrapper<RoleGroupPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RoleGroupPO::getRoleGroupName, roleGroup.getRoleGroupName());
        if (!StringUtils.isEmpty(roleGroup.getId())) {
            queryWrapper.lambda().ne(RoleGroupPO::getId, roleGroup.getId());
        }
        return roleGroupMapper.selectCount(queryWrapper);
    }


    /**
     * 添加角色组
     * @param roleGroup  角色组信息
     * @author WangMingShuai
     * @date 2019/12/27 15:59
     * @return java.lang.Integer
     */
    @Override
    @GlobalTransactional
    public int insertRoleGroup(RoleGroupPO roleGroup) {
        if (findRoleGroupCount(roleGroup) > 0) {
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(), "角色组名称不能重名!");
        }
        //启用
        roleGroup.setStatus(1);
        int num = this.roleGroupMapper.insert(roleGroup);
        if (num > 0 && !CollectionUtils.isEmpty(roleGroup.getRoleIds())) {
            List<RoleGroupRolePO> batchList = roleGroup.getRoleIds().stream().map(roleId->
                    RoleGroupRolePO.builder().roleId(roleId).roleGroupId(roleGroup.getId()).build())
                    .collect(Collectors.toList());
            this.roleGroupRoleService.saveBatch(batchList);
        }
        if (num > 0 && !CollectionUtils.isEmpty(roleGroup.getUserIds())) {
            List<RoleGroupUserPO> batchList = roleGroup.getUserIds().stream().map(userId->
                    RoleGroupUserPO.builder().userId(userId).roleGroupId(roleGroup.getId()).build())
                    .collect(Collectors.toList());
            this.roleGroupUserService.saveBatch(batchList);
        }
        return num;
    }

    /**
     * 查询所有的角色组信息
     * @author WangMingShuai
     * @date 2020/1/18 14:35
     * @return java.util.List<cn.com.hatechframework.server.role.po.RoleGroupPO>
     */
    @Override
    public List<RoleGroupPO> findAll() {
        return this.roleGroupMapper.findAll(new RoleGroupVO());
    }

    /**
     * 根据角色组ids删除角色组
     * @param ids  角色组Ids
     * @author WangMingShuai
     * @date 2020/1/18 14:45
     * @return void
     */
    @Override
    @GlobalTransactional
    public boolean deleteRoleGroupByIds(String ids) {
        if (!StringUtils.isEmpty(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            this.roleGroupMapper.deleteBatchIds(idList);
            this.roleGroupMapper.deleteRoleGroupRoleByRoleGroupIds(idList);
            this.roleGroupMapper.deleteRoleGroupUserByRoleGroupIds(idList);
        }
        return true;
    }

    /**
     * 修改角色组
     * @param roleGroup  角色组信息
     * @author WangMingShuai
     * @date 2019/12/27 15:59
     * @return java.lang.Integer
     */
    @Override
    @GlobalTransactional
    public int updateRoleGroup(RoleGroupPO roleGroup) {
        if (findRoleGroupCount(roleGroup) > 0) {
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(), "角色组名称不能重名!");
        }
        int num = this.roleGroupMapper.updateById(roleGroup);
        if (num > 0) {
            this.roleGroupMapper.deleteRoleGroupRoleByRoleGroupId(roleGroup.getId());
            if ( !CollectionUtils.isEmpty(roleGroup.getRoleIds())) {
                List<RoleGroupRolePO> batchList = roleGroup.getRoleIds().stream().map(
                        roleId->RoleGroupRolePO.builder().roleId(roleId).roleGroupId(roleGroup.getId()).build())
                        .collect(Collectors.toList());
                this.roleGroupRoleService.saveBatch(batchList);
            }
            if (!CollectionUtils.isEmpty(roleGroup.getUserIds())) {
                this.roleGroupMapper.deleteRoleGroupUserByRoleGroupId(roleGroup.getId());
                List<RoleGroupUserPO> batchList = roleGroup.getUserIds().stream().map(userId->
                        RoleGroupUserPO.builder().userId(userId).roleGroupId(roleGroup.getId()).build())
                        .collect(Collectors.toList());
                this.roleGroupUserService.saveBatch(batchList);
            }
        }
        return num;
    }


}
