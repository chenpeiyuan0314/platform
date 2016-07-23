package org.yuan.project.platform.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuan.project.platform.entity.Client;
import org.yuan.project.platform.entity.Token;
import org.yuan.project.platform.helper.CheckHelper;
import org.yuan.project.platform.helper.CodeHelper;
import org.yuan.project.platform.helper.DateHelper;
import org.yuan.project.platform.model.ClientJson;
import org.yuan.project.platform.model.ResultJson;
import org.yuan.project.platform.other.CheckExceptionMessage;
import org.yuan.project.platform.other.CheckRuntimeException;

@Controller
@RequestMapping("/v1/client")
public class ClientController extends BaseController {

	@ResponseBody
	@RequestMapping("login.json")
	public ResultJson loginJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// 校验参数 - 电话，密码、用户
			CheckHelper.checkPhone(username);
			CheckHelper.checkPassword(password);
			Client client = CheckHelper.checkLogin(username, CodeHelper.sha(password));
			
			// 添加令牌对象
			Date date = new Date();
			Token token = new Token();
			token.setClientId(client.getId());
			token.setCode(CodeHelper.token());
			token.setCreateDate(DateHelper.format(date, DateHelper.FMT_DATETIMEMS));
			date = DateHelper.alertDay(date, 30);
			token.setAbadeDate(DateHelper.format(date, DateHelper.FMT_DATETIMEMS));
			clientManager.insertSelective(token);
			
			// 返回用户信息
			ClientJson clientJson = new ClientJson();
			clientJson.setUsername(client);
			clientJson.setToken(token.getCode());
			result.getData().put("client", clientJson);
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("register.json")
	public ResultJson registerJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// 校验参数 - 电话、密码、已经注册
			CheckHelper.checkPhone(username);
			CheckHelper.checkRegister(username);
			CheckHelper.checkPassword(password);
			
			// 添加用户对象
			Client client = new Client();
			client.setPhone(username);
			client.setPassword(CodeHelper.sha(password));
			clientManager.insertSelective(client);
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("logout.json")
	public ResultJson logoutJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			String code = request.getParameter("token");
			
			// 验证参数 - 令牌
			Token token = CheckHelper.checkToken(code);
			
			// 更新token的过期时间
			String dateStr = DateHelper.format(new Date(), DateHelper.FMT_DATETIMEMS);
			Token record = new Token();
			record.setId(token.getId());
			record.setAbadeDate(dateStr);
			clientManager.updateSelective(token);
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("detail.json")
	public ResultJson detailJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			String code = request.getParameter("token");
			
			// 验证参数 - 令牌
			Token token = CheckHelper.checkToken(code);
			
			// 获取用户信息
			Client client = clientManager.selectClient(token.getClientId());
			
			// 返回用户信息
			ClientJson clientJson = new ClientJson();
			clientJson.setUsername(client);
			clientJson.setToken(token.getCode());
			result.getData().put("client", clientJson);
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("alterPassword.json")
	public ResultJson alterPasswordJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			String code = request.getParameter("token");
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			
			// 验证参数 - 令牌
			Token token = CheckHelper.checkToken(code);
			Client client = clientManager.selectClient(token.getClientId());
			if(!client.getPassword().equals(CodeHelper.sha(oldPassword))) {
				throw new CheckRuntimeException(CheckExceptionMessage.CODE_10008);
			}
			CheckHelper.checkPassword(newPassword);
			if(newPassword.equals(oldPassword)) {
				throw new CheckRuntimeException(CheckExceptionMessage.CODE_10009);
			}
			
			// 保存新密码
			Client record = new Client();
			record.setId(client.getId());
			record.setPassword(CodeHelper.sha(newPassword));
			clientManager.updateSelective(record);
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("alterDetail.json")
	public ResultJson alterDetailJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			String code = request.getParameter("token");
			String username = request.getParameter("username");
			
			// 验证参数 - 令牌
			Token token = CheckHelper.checkToken(code);
			CheckHelper.checkUsername(username);
			
			// 获取用户信息
			Client client = clientManager.selectClient(token.getClientId());
			
			// 保存修改信息
			Client record = new Client();
			record.setId(client.getId());
			record.setUsername(username);
			clientManager.updateSelective(record);
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
}
