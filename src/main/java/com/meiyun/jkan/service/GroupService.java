package com.meiyun.jkan.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.meiyun.jkan.model.Group;
import com.meiyun.jkan.model.Post;

/**
 * 分组
 * @author larry.qi
 */
@Transactional
public interface GroupService {
	
	/**
	 * 查询Groups
	 * @return
	 */
	Page<Group> findGroups(PageRequest pageRequest);
	
	/**
	 * 根据ID查询Group
	 * @param id
	 * @return
	 */
	Group findById(Long id);
	
	/**
	 * 根据ID查询所有Posts
	 * @param id
	 * @return
	 */
	Page<Post> findPostsByGroupId(Long id, PageRequest pageRequest);
	
	/**
	 * 检测名称是否可用
	 * @param title
	 * @return
	 */
	boolean checkGroup(String title);
	
	/**
	 * 添加分组
	 * @param group
	 * @return
	 * @throws Exception
	 */
	Group addGroup(Group group) throws Exception;
	
	/**
	 * 更新Group
	 * @param group
	 * @return
	 */
	Group updateGroup(Group group);
	
	/**
	 * 删除Group
	 * @param id
	 */
	void deleteGroup(Long id);

}
