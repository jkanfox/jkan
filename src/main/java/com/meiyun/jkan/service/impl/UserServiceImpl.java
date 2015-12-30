package com.meiyun.jkan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.UserModel;
import com.meiyun.jkan.repository.UserRepository;
import com.meiyun.jkan.service.UserService;
import com.meiyun.jkan.utils.SecurityUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository ur;

	@Override
	public UserModel regist(UserModel user) {
		return ur.saveAndFlush(user);
	}

	@Override
	public UserModel login(String name, String password) {
		List<UserModel> list = ur.findByName(name);
		if (list != null) {
			for (UserModel userModel : list) {
				String pass = SecurityUtils.encryptPassword(userModel.getSalt(), password);
				if (pass.equals(userModel.getPassword())) {
					return userModel;
				}
			}
		}
		return null;
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
