package com.meiyun.jkan.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meiyun.jkan.Constants;
import com.meiyun.jkan.admin.vo.DataGrid;
import com.meiyun.jkan.model.Track;
import com.meiyun.jkan.service.TrackService;

/**
 * 错误管理与追踪
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/admin")
public class TrackManager {
	
	private static Logger logger = LoggerFactory.getLogger(TrackManager.class);
	
	@Autowired
	private TrackService ts;
	
	/**
	 * 用户管理
	 * @return
	 */
	@RequestMapping("/tracks")
	public String indexPage(Model model) {
		model.addAttribute("title", "异常管理与追踪");
		return "admin/tracks/index";
	}
	
	/**
	 * 查询所有用户数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/tracks/list")
	public @ResponseBody DataGrid<Track> findAll(Model model,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		Page<Track> pageInfo = ts.findAll(new PageRequest(page-1, rows));
		return new DataGrid<Track>(pageInfo.getTotalPages(), pageInfo.getContent());
	}

}
