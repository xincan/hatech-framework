package cn.com.hatechframework.server.role.mapper;

import cn.com.hatechframework.data.universal.IBaseMapper;
import cn.com.hatechframework.server.role.po.RoleMenuOperationPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.server.role.mapper
 * @className IRoleMenuOperationMapper
 * @description 角色菜单关联关系数据层
 * @author WangMingShuai
 * @create 2020/01/21 16:24
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 *  WangMingShuai          2020/01/21 16:24             1.0                         角色菜单关联关系数据层
 */
@Mapper
public interface IRoleMenuOperationMapper extends IBaseMapper<RoleMenuOperationPO> {
}
