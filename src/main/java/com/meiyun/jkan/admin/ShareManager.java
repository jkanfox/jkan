package com.meiyun.jkan.admin;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.meiyun.jkan.model.Post;
import com.meiyun.jkan.model.Share;
import com.meiyun.jkan.service.PostService;
import com.meiyun.jkan.service.ShareService;

/**
 * 帖子管理
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/admin")
public class ShareManager {
	
	private static Logger logger = LoggerFactory.getLogger(ShareManager.class);

	@Resource
	private ShareService ss;

	@RequestMapping("/shares")
	public String indexPage(Model model) {
		model.addAttribute("title", "分享管理");
		return "admin/shares/index";
	}
	
	/**
	 * 查询所有类别数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/shares/list")
	public @ResponseBody DataGrid<Share> findAll(Model model,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		Page<Share> pageInfo = ss.findAll(new PageRequest(page-1, rows));
		return new DataGrid<Share>(pageInfo.getTotalPages(), pageInfo.getContent());
	}
	
}
