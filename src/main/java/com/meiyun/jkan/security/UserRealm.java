package com.meiyun.jkan.security;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.meiyun.jkan.model.sys.User;
import com.meiyun.jkan.service.UserService;

/**
 * 自定义UserRealm：主要实现认证和授权的管理操作
 * @author larry.qi
 *
 */
public class UserRealm extends AuthorizingRealm {

	@Resource
	private UserService us;
	
	/**
	 * 授权操作
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		
		// 设置角色
		auth.addRole("admin");
		
		// 设置权限
		Set<String> permissions = new HashSet<>();
		permissions.add("create");
		permissions.add("read");
		permissions.add("update");
		permissions.add("delete");
		auth.addStringPermissions(permissions);
		return auth;
	}

	/**
	 * 身份验证操作
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String name = (String) token.getPrincipal();
		User um =  us.findByName(name);
		
		if (um == null) {
			// 未找到用户
			throw new UnknownAccountException("用户名或邮箱不存在");
		}
		
		/*if (Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException(); // 帐号锁定
		}*/
		
		// 身份验证操作
		SimpleAuthenticationInfo auth = new SimpleAuthenticationInfo(um.getName(), um.getPassword(), getClass().getName());
		return auth;
	}

}
