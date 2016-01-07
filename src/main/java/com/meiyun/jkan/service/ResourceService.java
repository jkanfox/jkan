package com.meiyun.jkan.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.meiyun.jkan.model.MResource;

public interface ResourceService {
	
	public MResource createResource(MResource resource);
    public MResource updateResource(MResource resource);
    public void deleteResource(Long resourceId);

    MResource findOne(Long resourceId);
    Page<MResource> findAll(Pageable pageable);

    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<MResource> findMenus(Set<String> permissions);

}
