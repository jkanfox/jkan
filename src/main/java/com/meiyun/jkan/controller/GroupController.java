package com.meiyun.jkan.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.meiyun.jkan.Constants;
import com.meiyun.jkan.model.GroupModel;
import com.meiyun.jkan.service.GroupService;

/**
 * <ul>
 * <li>/groups: GET</li>
 * <li>/groups/{id}: GET</li>
 * <li>/groups/{id}/posts: GET</li>
 * <li>/groups/check: GET</li>
 * <li>/groups/new: GET</li>
 * <li>/groups/new: POST</li>
 * <li>/groups/{id}/edit: GET</li>
 * <li>/groups/{id}/edit: PUT</li>
 * <li>/groups/{id}/delete: DELETE</li>
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
	public String findGroups() {
		List<GroupModel> list = gs.findGroups();
		System.out.println(list.stream().count());
		return null;
	}
	
	/**
	 * 根据Id查询Group
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable Integer id) {
		GroupModel gm = gs.findById(id);
		System.out.println(gm.getName());
		return null;
	}
	
	/**
	 * 根据Id查询Group下所有的posts
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public String findPostsByGroupId(@PathVariable Integer id) {
		
		return null;
	}
	
	/**
	 * 检验Group title是否可用
	 * @return
	 */
	@RequestMapping(value = "/check", method = {RequestMethod.GET, RequestMethod.POST})
	public String checkGroup() {
		
		return null;
	}
	
	/**
	 * 跳转到添加Group页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/new", method = {RequestMethod.GET})
	public String addGroupPage() {
		
		return null;
	}
	
	/**
	 * 添加Group
	 * @param title
	 * @throws Exception
	 */
	@RequestMapping( value = "/new", method = RequestMethod.POST)
	public String addGroup(@RequestParam String title) throws Exception {
		GroupModel gm = new GroupModel();
		gm.setDescription("description");
		gm.setPosition(0);
		gm.setTitle(title);
		gm.setState(1);
		gm.setName(super.randomUUID());
		gm = gs.addGroup(gm);
		System.out.println("ID:" + gm.getId() + "Name: "+ gm.getName());
		return null;
	}
	
	/**
	 * 跳转到编辑Group页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = {RequestMethod.GET})
	public String editGroupPage(@PathVariable Integer id) {
		
		return null;
	}
	
	/**
	 * 编辑Group
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = {RequestMethod.PUT})
	public String editGroup(@PathVariable Integer id) {
		
		return null;
	}
	
	/**
	 * 删除GROUP
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = {RequestMethod.DELETE})
	public String deleteGroup(@PathVariable Integer id) {
		gs.deleteGroup(id);
		return null;
	}

}
