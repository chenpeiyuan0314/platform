package org.yuan.project.platform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.yuan.project.platform.manager.ClientManager;
import org.yuan.project.platform.model.ResultJson;
import org.yuan.project.platform.other.CheckExceptionMessage;
import org.yuan.project.platform.other.CheckRuntimeException;

import com.alibaba.fastjson.JSON;

public class BaseController {

	@Autowired
	protected ClientManager clientManager;
	
	
	//-------------------------------------------------------
	// 公用方法
	//-------------------------------------------------------
	
	/**
	 * 打印请求参数
	 * @param request
	 */
	protected void log(HttpServletRequest request) {
		Map<String,String> params = new HashMap<String,String>();
		
		for(String key : request.getParameterMap().keySet()) {
			params.put(key, request.getParameter(key));
		}
		
		LOG.info("Request Params: " + params);
	}
	
	/**
	 * 打印请求结果
	 * @param result
	 */
	protected void log(ResultJson result) {
		LOG.info("Request Result: " + JSON.toJSONString(result));
	}
	
	/**
	 * 处理请求异常
	 * @param result
	 * @param e
	 */
	protected void exc(ResultJson result, Exception e) {
		if(e instanceof CheckRuntimeException) {
			CheckRuntimeException cre = (CheckRuntimeException)e;
			result.setCode(cre.getCode());
			result.setInfo(cre.getMessage());
		} else {
			int code = CheckExceptionMessage.CODE_10000;
			result.setCode(code);
			String info = CheckExceptionMessage.getInfo(code);
			result.setInfo(info);
		}
		LOG.error(e, e);
	}
	
	private static final Logger LOG = Logger.getLogger(BaseController.class);
}
