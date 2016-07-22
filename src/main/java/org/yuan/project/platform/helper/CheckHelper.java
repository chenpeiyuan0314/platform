package org.yuan.project.platform.helper;

import static org.yuan.project.platform.other.CheckExceptionMessage.*;

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
		if(password == null || !password.matches("^.{6,20}&")) {
			throw new CheckRuntimeException(CODE_10002);
		}
		if(password.matches("[^0-9a-zA-Z]+") || 
			!(password.matches("[0-9]+") && password.matches("[a-zA-Z]+"))) {
			throw new CheckRuntimeException(CODE_10003);
		}
	}
	
	/**
	 * 验证
	 * @param code
	 */
	public static void checkToken(String code) {

	}
	
}
