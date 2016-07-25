package org.yuan.project.platform.helper;

import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10001;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10002;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10003;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10004;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10005;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10006;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10007;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10010;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10011;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10012;
import static org.yuan.project.platform.other.CheckExceptionMessage.CODE_10013;

import java.util.Date;

import org.yuan.project.platform.entity.Client;
import org.yuan.project.platform.entity.Token;
import org.yuan.project.platform.manager.ClientManager;
import org.yuan.project.platform.manager.ProductManager;
import org.yuan.project.platform.other.CheckRuntimeException;

public class CheckHelper {
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
		if(password == null || !password.matches("^.{6,20}$")) {
			throw new CheckRuntimeException(CODE_10002);
		}
		
		boolean hasAlpha = false;
		boolean hasDigit = false;
		for(char ch : password.toCharArray()) {
			if(hasAlpha && hasDigit) {
				return;
			}
			if(Character.isLetter(ch)) {
				hasAlpha = true;
				continue;
			}
			if(Character.isDigit(ch)) {
				hasDigit = true;
				continue;
			}
			throw new CheckRuntimeException(CODE_10003);
		}
	}
	
	/**
	 * 验证账号名称
	 * @param password
	 */
	public static void checkUsername(String username) {
		if(username == null || !username.matches("^.{6,20}$")) {
			throw new CheckRuntimeException(CODE_10010);
		}
		
		for(char ch : username.toCharArray()) {
			if(Character.isLetter(ch)) {
				continue;
			}
			throw new CheckRuntimeException(CODE_10011);
		}
	}
	
	/**
	 * 验证令牌
	 * @param code
	 * @return
	 */
	public static Token checkToken(String code) {
		if(isBlank(code)) {
			throw new CheckRuntimeException(CODE_10007);
		}
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

	/**
	 * 判断字符串是否为空
	 * @param s
	 * @return
	 */
	private static boolean isBlank(String s) {
		if(s == null) {
			return true;
		}
		if(s.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 校验显示类型
	 * @param type
	 */
	public static void checkShowType(String type) {
		if(isBlank(type) || !"1".equals(type)) {
			throw new CheckRuntimeException(CODE_10012);
		}
	}
	
	/**
	 * 校验商品标识
	 * @param productId
	 */
	public static void checkProductId(String productId) {
		if(isBlank(productId) || !productId.matches("\\d+")) {
			throw new CheckRuntimeException(CODE_10013);
		}
		Integer id = Integer.valueOf(productId);
		if(productManager.selectProductSize(id) != 1) {
			throw new CheckRuntimeException(CODE_10013);
		}
		
	}

	private static ClientManager clientManager;
	public void setClientManager(ClientManager clientManager) {
		CheckHelper.clientManager = clientManager;
	}
	
	private static ProductManager productManager;
	public void setProductManager(ProductManager productManager) {
		CheckHelper.productManager = productManager;
	}
}
