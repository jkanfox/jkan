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
import com.meiyun.jkan.service.PostService;

/**
 * 标签管理
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/admin")
public class PostManager {
	
	private static Logger logger = LoggerFactory.getLogger(PostManager.class);

	@Resource
	private PostService ps;

	@RequestMapping("/posts")
	public String indexPage(Model model) {
		model.addAttribute("title", "链接管理");
		return "admin/posts/index";
	}
	
	/**
	 * 查询所有类别数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/posts/list")
	public @ResponseBody DataGrid<Post> findAll(Model model,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		Page<Post> pageInfo = ps.findPosts(new PageRequest(page-1, rows));
		return new DataGrid<Post>(pageInfo.getTotalPages(), pageInfo.getContent());
	}
	
}
