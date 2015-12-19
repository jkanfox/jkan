package com.meiyun.jkan.client;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.User;
import com.meiyun.jkan.repository.UserRepository;

@Service
@Transactional
public class Client {

	@Autowired
	private UserRepository ur;
	
	public void testAdd(User user) {
		ur.save(user);
	}
	
}
