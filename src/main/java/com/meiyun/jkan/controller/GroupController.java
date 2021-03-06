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
import com.meiyun.jkan.Constants;
import com.meiyun.jkan.Context;
import com.meiyun.jkan.model.Group;
import com.meiyun.jkan.service.GroupService;

/**
 * <ul>
 * <li>/groups: GET</li>
 * <li>/groups/{id}: GET</li>
 * <li>/groups/{id}/posts: GET</li>
 * <li>/groups/check: POST</li>
 * <li>/groups/new: GET</li>
 * <li>/groups/new: POST</li>
 * <li>/groups/{id}/edit: GET</li>
 * <li>/groups/{id}/edit: POST</li>
 * <li>/groups/{id}/delete: POST</li>
 * </ul>
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/groups")
public class GroupController extends BaseController {
	
	@Resource
	private GroupService gs;
	
	/**
	 * 查询Groups
	 * <li>GroupModel: 实体查询</li>
	 * <li>OrderBy: 排序</li>
	 * <li>Page: 分页</li>
	 * <li>Rules: 其他规则</li>
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String findGroups(Group gm, Model model,
			@RequestParam(defaultValue = "0", required = false) Integer page, 
			@RequestParam(defaultValue = "50", required = false) Integer size,
			@RequestParam(required = false) String q) {
		Page<Group> pageInfo = gs.findGroups(new PageRequest(page, size));
		model.addAttribute("c", new Context(pageInfo));
		return "views/group/index";
	}
	
	/**
	 * 根据Id查询Group
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Group findById(@PathVariable Long id) {
		return gs.findById(id);
	}
	
	/**
	 * 根据Id查询Group下所有的posts
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public String findPostsByGroupId(@PathVariable Long id, Model model) {
		Context c = new Context(gs.findPostsByGroupId(id, new PageRequest(0, 50)));
		c.add("flag", true);
		c.add("group", gs.findById(id));
		model.addAttribute("c", c);
		return "views/posts/index";
	}
	
	/**
	 * 检验Group title是否可用
	 * @return
	 */
	@RequestMapping(value = "/check", method = {RequestMethod.GET})
	public @ResponseBody boolean checkGroup(@RequestParam String title) {
		return gs.checkGroup(title);
	}
	
	/**
	 * 跳转到添加Group页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/new", method = {RequestMethod.GET})
	public String addGroupPage() {
		return "views/group/new";
	}
	
	/**
	 * 添加Group
	 * @param title
	 * @throws Exception
	 */
	@RequestMapping( value = "/new", method = RequestMethod.POST)
	public @ResponseBody Group addGroup(@RequestParam String title, String description) throws Exception {
		return gs.addGroup(Group.create(title, description));
	}
	
	/**
	 * 跳转到编辑Group页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = {RequestMethod.GET})
	public String editGroupPage(@PathVariable Long id, Model model) {
		Preconditions.checkNotNull(id, "Group Id 不能为空。");
		model.addAttribute("c", new Context(gs.findById(id)));
		return "views/group/edit";
	}
	
	/**
	 * 编辑Group
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = {RequestMethod.POST})
	public @ResponseBody Group editGroup(@PathVariable Long id, Group gm) {
		Preconditions.checkNotNull(id);
		Preconditions.checkNotNull(gm);
		Preconditions.checkArgument(id == gm.getId());
		return gs.updateGroup(gm);
	}
	
	/**
	 * 删除GROUP
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public void deleteGroup(@PathVariable Long id) {
		Preconditions.checkNotNull(id);
		gs.deleteGroup(id);
	}

}
