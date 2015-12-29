package com.meiyun.jkan.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @LoginUser
 * 处理用户登录
 * @author larry.qi
 */
@Aspect
@Component
public class LoginUserAspect {
	
	static final Logger logger = LoggerFactory.getLogger(LoginUserAspect.class);
	
	@Pointcut("@annotation(com.meiyun.jkan.annotation.LoginUser)")
	public void loginUser() {}
	
	@Before("loginUser()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("=======================================");
	}

}
