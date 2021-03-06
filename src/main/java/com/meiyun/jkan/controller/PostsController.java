package com.meiyun.jkan.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Preconditions;
import com.jkanfox.jkan.boot.http.FetchUtils;
import com.jkanfox.jkan.boot.http.FetchUtils.WebModel;
import com.meiyun.jkan.Constants;
import com.meiyun.jkan.Context;
import com.meiyun.jkan.annotation.LoginUser;
import com.meiyun.jkan.model.Group;
import com.meiyun.jkan.model.Post;
import com.meiyun.jkan.service.GroupService;
import com.meiyun.jkan.service.PostService;

/**
 * <ul>
 * <li>/posts: GET</li>
 * <li>/posts/{id}: GET</li>
 * <li>/posts/check: POST</li>
 * <li>/posts/fetch: POST/GET</li>
 * <li>/posts/new: GET</li>
 * <li>/posts/new: POST</li>
 * <li>/posts/{id}/edit: GET</li>
 * <li>/posts/{id}/edit: POST</li>
 * <li>/posts/{id}/delete: POST</li>
 * </ul>
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/posts")
public class PostsController extends BaseController {
	
	@Resource
	private PostService ps;
	
	@Resource
	private GroupService gs;
	
	/**
	 * 查询Posts
	 * @return
	 */
	@LoginUser
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String findPosts(Post pm, Model model,
			@RequestParam(defaultValue = "0", required = false) Integer page, 
			@RequestParam(defaultValue = "50", required = false) Integer size,
			@RequestParam(required = false) String q) {
		model.addAttribute("c", new Context(ps.findPosts(new PageRequest(page, size))));
		return "views/posts/index";
	}
	
	/**
	 * 根据ID查询Posts
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Post findById(@PathVariable Long id) {
		Preconditions.checkNotNull(id);
		return ps.findById(id);
	}
	
	/**
	 * 校验Posts是否存在
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public @ResponseBody boolean checkPost(String title) {
		return ps.checkPost(title);
	}
	
	/**
	 * 根据URL抓取数据
	 * @return
	 */
	@RequestMapping(value = "/fetch", method = {RequestMethod.GET, RequestMethod.POST})
	public String fetchByUrl(@RequestParam(required = true) String url, Model model) {
		// Groups
		Context c = new Context(gs.findGroups(new PageRequest(0, 50)));
		
		// Fetch URL
		WebModel wm = FetchUtils.connect(url);
		Post pm = new Post();
		pm.setDescription(wm.getDescription());
		pm.setTags(wm.getKeywords());
		pm.setTitle(wm.getTitle());
		pm.setUrl(wm.getUrl());
		c.add("info", pm);
		model.addAttribute("c", c);
		return "views/posts/fetch";
	}
	
	/**
	 * 跳转到添加Posts页面
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addPostsPage(Model model) {
		return "views/posts/new";
	}
	
	/**
	 * 添加Posts
	 * @param title
	 * @param url
	 * @throws Exception
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody Post addPosts(@RequestParam String url, @RequestParam String title, String description, String tags,
			@RequestParam Long groupId) {
		return ps.addPosts(Post.create(url, title, description, tags, groupId));
	}
	
	/**
	 * 跳转到编辑Posts页面
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editPostsPage(@PathVariable Long id, Model model) {
		Preconditions.checkNotNull(id);
		Context c = new Context(ps.findById(id));
		Page<Group> pageInfo = gs.findGroups(new PageRequest(0, 50));
		c.add("groups", pageInfo);
		model.addAttribute("c", c);
		return "views/posts/edit";
	}
	
	/**
	 * 保存编辑的Posts
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public @ResponseBody Post editPosts(@PathVariable Long id, Post pm) {
		Preconditions.checkNotNull(id);
		Preconditions.checkNotNull(pm);
		Preconditions.checkArgument(id == pm.getId());
		return ps.updatePosts(pm);
	}
	
	/**
	 * 根据ID删除Posts
	 */
	@RequestMapping(value = "/{id}/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public void deletePosts(@PathVariable Long id) {
		Preconditions.checkNotNull(id);
		ps.deletePost(id);
	}

}
