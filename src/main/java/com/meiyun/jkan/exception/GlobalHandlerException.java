package com.meiyun.jkan.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import com.meiyun.jkan.model.Track;
import com.meiyun.jkan.service.TrackService;

/**
 * 全局异常处理
 * @author larry.qi
 */
@Component
public class GlobalHandlerException implements HandlerExceptionResolver  {
	
	private static Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);
	
	@Autowired
	private TrackService ts;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception e) {
		
		// 记录日志并保存到数据库
		logger.debug(Throwables.getStackTraceAsString(e));
		ts.addTrack(new Track(e.getClass().getName(), JSON.toJSONString(object)));
		
		// 通过异常管理和追踪来更友好的处理异常问题
		if (e instanceof BusinessException) {
			
		}
		
		return new ModelAndView("views/error/404");
	}

}
