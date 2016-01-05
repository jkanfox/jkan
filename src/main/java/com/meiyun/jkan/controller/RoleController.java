package com.meiyun.jkan.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meiyun.jkan.Constants;

/**
 * 角色管理
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/roles")
public class RoleController extends BaseController {

}
