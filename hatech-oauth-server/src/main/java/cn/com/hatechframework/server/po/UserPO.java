package cn.com.hatechframework.server.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.po
 * @className UserPO
 * @description 用户实体类
 * @author YeMeng
 * @create 2019/12/18 18:42
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * YeMeng              2019/12/18 18:42             1.0                        用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPO implements UserDetails, Serializable {

	private String id;

	private String username;

	private String password;

	private String phone;

	private Collection<RolePO> authorities;

	private List<TenantPO> tenantList;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
