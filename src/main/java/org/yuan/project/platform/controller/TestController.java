package org.yuan.project.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuan.project.platform.model.ResultJson;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("info.html")
	public String infoHtml() {
		return "info";
	}
	
	@ResponseBody
	@RequestMapping("info.json")
	public ResultJson infoJson() {
		ResultJson result = new ResultJson();
		
		result.setCode(0);
		result.setInfo("调用成功");
		//result.setData();
		
		return result;
	}
}
