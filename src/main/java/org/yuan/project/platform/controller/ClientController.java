package org.yuan.project.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuan.project.platform.model.ResultJson;

@Controller
@RequestMapping("/v1/user")
public class UserController extends BaseController {

	@ResponseBody
	@RequestMapping("login")
	public ResultJson login() {
		return null;
	}
	
	@ResponseBody
	@RequestMapping("register")
	public ResultJson register() {
		return null;
	}
	
	@ResponseBody
	@RequestMapping("logout")
	public ResultJson logout() {
		return null;
	}
}
