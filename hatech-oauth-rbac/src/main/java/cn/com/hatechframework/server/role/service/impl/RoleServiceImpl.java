package cn.com.hatechframework.server.role.service.impl;

import cn.com.hatechframework.config.exception.BusinessException;
import cn.com.hatechframework.data.page.Pagination;
import cn.com.hatechframework.entity.oauth.rbac.vo.RoleVO;
import cn.com.hatechframework.server.role.dto.RolePageDTO;
import cn.com.hatechframework.server.role.mapper.IRoleMapper;
import cn.com.hatechframework.server.role.po.RoleMenuOperationPO;
import cn.com.hatechframework.server.role.po.RolePO;
import cn.com.hatechframework.server.role.service.IRoleMenuOperationService;
import cn.com.hatechframework.server.role.service.IRoleService;
import cn.com.hatechframework.utils.response.ResponseCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.service.impl
 * @className RoleServiceImpl
 * @description 角色信息接口层实现
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 17:03             1.0                         角色信息接口层实现
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<IRoleMapper, RolePO> implements IRoleService {

    /**
     * 逗号分隔符
     */
    private static final String SPLIT_COMMA = ",";

    /**
     * 角色启用
     */
    private static final int ROLE_ENABLED = 1;

    @Resource
    private IRoleMapper roleMapper;

    private final IRoleMenuOperationService roleMenuOperationService;

    public RoleServiceImpl(IRoleMenuOperationService roleMenuOperationService) {
        this.roleMenuOperationService = roleMenuOperationService;
    }

    /**
     * 角色分页查询
     * @param rolePageDTO  分页查询参数
     * @author WangMingShuai
     * @date 2019/12/24 19:50
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.hatechframework.server.role.vo.RoleVo>
     */
    @Override
    public Page<RoleVO> findPage(RolePageDTO rolePageDTO) {
        Page<RoleVO> page = Pagination.page(rolePageDTO);
        List<RoleVO> list = this.roleMapper.findAll(page,rolePageDTO);
        page.setRecords(list);
        return page;
    }


    /**
     * 查询启用的角色个数
     * @param ids 角色ids
     * @author YeMeng
     * @date 2020/2/21 20:34
     * @return int
     */
    @Override
    public int findRoleEnabledCount(String ids) {
        QueryWrapper<RolePO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RolePO::getStatus, ROLE_ENABLED)
                .in(RolePO::getId, Arrays.asList(ids.split(SPLIT_COMMA)));
        return roleMapper.selectCount(queryWrapper);
    }

    /**
     * 新增角色
     * @param role  角色信息
     * @author WangMingShuai
     * @date 2019/12/27 14:36
     * @return java.lang.Integer
     */
    @Override
    @GlobalTransactional
    public int insertRole(RolePO role) {
        RolePO oldRole = this.roleMapper.findRoleByName(role.getRoleName());
        if (!ObjectUtils.isEmpty(oldRole)) {
            throw new BusinessException(ResponseCode.PARAM_ERROR.code(), "角色名称已存在");
        }
        //启用
        role.setStatus(1);
        role.setEditTime(new Date());
        int num = this.roleMapper.insert(role);
        if (num > 0 && !CollectionUtils.isEmpty(role.getMenuIds())) {
            this.insertRoleMenuOperation(role);
        }
        return num;
    }

    /**
     * 修改角色
     * @param role  角色信息
     * @author WangMingShuai
     * @date 2019/12/27 14:36
     * @return java.lang.Integer
     */
    @Override
    @GlobalTransactional
    public int updateRole(RolePO role) {
        role.setEditTime(new Date());
        int num = this.roleMapper.updateById(role);
        this.roleMapper.deleteRoleMenuByRoleId(role.getId());
        if (num > 0 && !CollectionUtils.isEmpty(role.getMenuIds())) {
            this.insertRoleMenuOperation(role);
        }
        return num;
    }

    /**
     * 根据角色ids删除角色
     * @param ids  角色ids
     * @author WangMingShuai
     * @date 2020/1/20 9:04
     * @return boolean
     */
    @Override
    @GlobalTransactional
    public boolean deleteRoleByIds(String ids) {
        if (!StringUtils.isEmpty(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            this.roleMapper.deleteBatchIds(idList);
            this.roleMapper.deleteRoleMenuByRoleIds(idList);
        }
        return true;
    }

    /**
     * 根据角色id启用停用角色
     * @param id  角色id
     * @author WangMingShuai
     * @date 2020/2/6 14:17
     * @return int
     */
    @Override
    public int updateStatusById(String id) {
        return this.roleMapper.updateStatusById(id);
    }

    /**
     * 添加角色菜单操作关联关系
     * @param role  角色参数
     * @author WangMingShuai
     * @date 2020/1/21 16:52
     * @return void
     */
    private void insertRoleMenuOperation (RolePO role) {
        List<RoleMenuOperationPO> batchList = Lists.newArrayList();
        String [] idsArr;
        for (String menuOperationId : role.getMenuIds()) {
            idsArr = menuOperationId.split("-");
            if (idsArr.length == 1) {
                batchList.add(RoleMenuOperationPO
                        .builder()
                        .roleId(role.getId())
                        .menuId(idsArr[0])
                        .build());
            }
            if (idsArr.length == 2) {
                batchList.add(RoleMenuOperationPO
                        .builder()
                        .roleId(role.getId())
                        .menuId(idsArr[0])
                        .operationId(idsArr[1])
                        .build());
            }
        }
        if (!CollectionUtils.isEmpty(batchList)) {
            this.roleMenuOperationService.saveBatch(batchList);
        }
    }
}
