package com.meiyun.jkan.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

/**
 * 全局异常处理
 * @author larry.qi
 */
@Component
public class GlobalHandlerException implements HandlerExceptionResolver  {
	
	private static Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception e) {
		
		logger.debug(Throwables.getStackTraceAsString(e));
		
		if (e instanceof BusinessException) {
			
		}
		
		return new ModelAndView("error");
	}

}
