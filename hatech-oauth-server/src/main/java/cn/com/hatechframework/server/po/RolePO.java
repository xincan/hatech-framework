package cn.com.hatechframework.server.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.po
 * @className RolePO
 * @description 角色实体类
 * @author YeMeng
 * @create 2019/12/18 18:42
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 18:42             1.0                        角色实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolePO implements GrantedAuthority {

	/**
	 * 角色id
	 */
	private String id;

	/**
	 * 角色名称
	 */
	private String roleName;

	@Override
	public String getAuthority() {
		return roleName;
	}

}
