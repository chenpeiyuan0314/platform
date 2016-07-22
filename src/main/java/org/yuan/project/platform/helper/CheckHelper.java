package org.yuan.project.platform.helper;

import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10001;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10002;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10003;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10004;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10005;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10006;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.yuan.project.platform.entity.Client;
import org.yuan.project.platform.entity.Token;
import org.yuan.project.platform.manager.ClientManager;
import org.yuan.project.platform.other.CheckRuntimeException;

public class CheckHelper {
	@Autowired
	private static ClientManager clientManager;

	/**
	 * 验证手机好吗
	 * @param phone
	 */
	public static void checkPhone(String phone) {
		if(phone == null || !phone.matches("^[1][3,4,5,8][0-9]{9}$")) {
			throw new CheckRuntimeException(CODE_10001);
		}
	}
	
	/**
	 * 验证账号密码
	 * @param password
	 */
	public static void checkPassword(String password) {
		if(password == null || !password.matches("^.{6,20}&")) {
			throw new CheckRuntimeException(CODE_10002);
		}
		if(password.matches("[^0-9a-zA-Z]+") || 
			!(password.matches("[0-9]+") && password.matches("[a-zA-Z]+"))) {
			throw new CheckRuntimeException(CODE_10003);
		}
	}
	
	/**
	 * 验证令牌
	 * @param code
	 * @return
	 */
	public static Token checkToken(String code) {
		String dateStr = DateHelper.format(new Date(), DateHelper.FMT_DATETIMEMS);
		Token token = clientManager.selectToken(code, dateStr);
		if(token == null) {
			throw new CheckRuntimeException(CODE_10006);
		}
		return token;
	}
	
	/**
	 * 验证登录
	 * @param username
	 * @param password
	 * @return
	 */
	public static Client checkLogin(String username, String password) {
		Client client = clientManager.selectClient(username, password);
		if(client == null) {
			throw new CheckRuntimeException(CODE_10005);
		}
		return client;
	}
	
	/**
	 * 验证注册
	 * @param username
	 */
	public static void checkRegister(String username) {
		boolean exists = clientManager.selectExists(username);
		if(exists) {
			throw new CheckRuntimeException(CODE_10004);
		}
	}
	
}
