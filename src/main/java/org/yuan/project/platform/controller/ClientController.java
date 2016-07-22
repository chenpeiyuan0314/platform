package org.yuan.project.platform.controller;

import java.util.Date;

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
	public ResultJson loginJson(String username, String password) {
		// 校验参数 - 电话，密码、用户
		CheckHelper.checkPhone(username);
		CheckHelper.checkPassword(password);
		Client client = CheckHelper.checkLogin(username, password);
		
		// 添加令牌对象
		Date date = new Date();
		Token token = new Token();
		token.setClientId(client.getId());
		token.setCode(CodeHelper.token());
		token.setCreateDate(DateHelper.format(date, DateHelper.FMT_DATETIMEMS));
		date = DateHelper.alertDay(date, 30);
		token.setAbadeDate(DateHelper.format(date, DateHelper.FMT_DATETIMEMS));
		clientManager.insertSelective(token);
		
		ResultJson result = new ResultJson();
		return result;
	}
	
	@ResponseBody
	@RequestMapping("register.json")
	public ResultJson registerJson(String username, String password) {
		// 校验参数 - 电话、密码、已经注册
		CheckHelper.checkPhone(username);
		CheckHelper.checkRegister(username);
		CheckHelper.checkPassword(password);
		
		// 添加用户对象
		Client client = new Client();
		client.setPhone(username);
		client.setPassword(password);
		clientManager.insertSelective(client);
		
		ResultJson result = new ResultJson();
		return result;
	}
	
	@ResponseBody
	@RequestMapping("logout.json")
	public ResultJson logoutJson(String code) {
		// 验证参数 - 令牌
		Token token = CheckHelper.checkToken(code);
		
		// 更新token的过期时间
		String dateStr = DateHelper.format(new Date(), DateHelper.FMT_DATETIMEMS);
		Token record = new Token();
		record.setId(token.getId());
		record.setAbadeDate(dateStr);
		clientManager.updateSelective(token);
		
		ResultJson result = new ResultJson();
		return result;
	}
	
	@ResponseBody
	@RequestMapping("detail.json")
	public ResultJson detailJson(String code) {
		// 验证参数 - 令牌
		Token token = CheckHelper.checkToken(code);
		
		// 获取用户信息
		Client client = clientManager.selectClient(token.getClientId());
		
		// 返回用户信息
		ClientJson clientJson = new ClientJson();
		clientJson.setUsername(client);
		clientJson.setToken(token.getCode());
		
		ResultJson result = new ResultJson();
		result.getData().put("client", clientJson);
		return result;
	}
}
