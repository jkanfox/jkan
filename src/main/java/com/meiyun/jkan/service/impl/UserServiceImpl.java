package com.meiyun.jkan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.meiyun.jkan.Constants;
import com.meiyun.jkan.model.UserModel;
import com.meiyun.jkan.repository.UserRepository;
import com.meiyun.jkan.service.UserService;
import com.meiyun.jkan.utils.SecurityUtils;
import com.meiyun.jkan.utils.SessionUtils;
import com.meiyun.jkan.utils.ValidateUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository ur;

	@Override
	public UserModel regist(UserModel user) {
		return ur.saveAndFlush(user);
	}

	@Override
	public void login(String name, String password) throws Exception {
		Preconditions.checkNotNull(name);
		Preconditions.checkNotNull(password);
		List<UserModel> list = null;
		
		if (ValidateUtils.checkEmail(name)) { // 邮箱登录
			list = ur.findByEmail(name);
		} else { // 用户名登录
			list = ur.findByName(name);
		}
		
		if (list == null || list.isEmpty()) {
			throw new Exception("用户名或邮箱不存在");
		}
		
		final UserModel um = list.get(0);
		String pass = SecurityUtils.encryptPassword(um.getSalt(), password);
		if (!pass.equals(um.getPassword())) {
			throw new Exception("用户名或密码错误");
		}
		
		// 登录成功:添加到Session
		SessionUtils.add(Constants.AUTH_USER, um, 1000 * 3600 * 24);
	}

	@Override
	public boolean checkEmail(String email) {
		List<UserModel> list = ur.findByEmail(email);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public UserModel findById(Integer id) {
		return ur.findOne(id);
	}

	@Override
	public UserModel updateUser(UserModel um) {
		return ur.saveAndFlush(um);
	}

}
