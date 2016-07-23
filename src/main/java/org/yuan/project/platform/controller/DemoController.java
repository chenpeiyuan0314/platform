package org.yuan.project.platform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuan.project.platform.model.ResultJson;

@Controller
@RequestMapping("/v1/demo")
public class DemoController extends BaseController {

	@ResponseBody
	@RequestMapping("one")
	public ResultJson loginJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			
			// 校验参数 - 
			
			// 处理请求
			
			// 返回数据
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
	
}
