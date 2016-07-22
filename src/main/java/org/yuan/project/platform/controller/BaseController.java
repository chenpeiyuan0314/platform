package org.yuan.project.platform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.yuan.project.platform.manager.ClientManager;

import com.fasterxml.jackson.core.JsonFactory;

public class BaseController {

	@Autowired
	protected ClientManager clientManager;
	
	
	//-------------------------------------------------------
	// 公用方法
	//-------------------------------------------------------
	
	/**
	 * 解析普通键值对
	 * @param request
	 * @return
	 */
	protected Map<String,String> getParams(HttpServletRequest request) {
		Map<String,String> params = new HashMap<String,String>();
		
		
		LOG.info(params);
		return params;
	}
	
	private static final Logger LOG = Logger.getLogger(BaseController.class);
}
