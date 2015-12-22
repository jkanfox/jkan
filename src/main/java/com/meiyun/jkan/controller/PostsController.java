package com.meiyun.jkan.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.meiyun.jkan.Constants;
import com.meiyun.jkan.model.PostsModel;
import com.meiyun.jkan.service.PostsService;

/**
 * <ul>
 * <li>/posts: GET</li>
 * <li>/posts/{id}: GET</li>
 * <li>/posts/check: GET</li>
 * <li>/posts/fetch: GET</li>
 * <li>/posts/new: GET</li>
 * <li>/posts/new: POST</li>
 * <li>/posts/{id}/edit: GET</li>
 * <li>/posts/{id}/edit: PUT</li>
 * <li>/posts/{id}/delete: DELETE</li>
 * </ul>
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/posts")
public class PostsController extends BaseController {
	
	@Resource
	private PostsService postsService;
	
	/**
	 * 查询Posts
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String findPosts() {
		return "home";
	}
	
	/**
	 * 根据ID查询Posts
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable Integer id) {
		return null;
	}
	
	/**
	 * 校验Posts是否存在
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String checkPosts() {
		return null;
	}
	
	/**
	 * 根据URL抓取数据
	 * @return
	 */
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public String fetchByUrl() {
		return null;
	}
	
	/**
	 * 跳转到添加Posts页面
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void addPostsPage() {
		
	}
	
	/**
	 * 添加Posts
	 * @param title
	 * @param url
	 * @throws Exception
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addPosts(@RequestParam String title, @RequestParam String url) throws Exception {
		PostsModel pm = new PostsModel();
		pm.setDescription("description");
		pm.setGroup(1);
		pm.setName(super.randomUUID());
		pm.setState(1);
		pm.setTags("DD");
		pm.setTitle(title);
		pm.setUrl(url);
		postsService.addPosts(pm);
	}
	
	/**
	 * 跳转到编辑Posts页面
	 */
	@RequestMapping(value = "/{id}/eidt", method = RequestMethod.GET)
	public void editPostsPage() {
		
	}
	
	/**
	 * 保存编辑的Posts
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public void editPosts() {
		
	}
	
	/**
	 * 根据ID删除Posts
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deletePosts() {
		
	}

}
