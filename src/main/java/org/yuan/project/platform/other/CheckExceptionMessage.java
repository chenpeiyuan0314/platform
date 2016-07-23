package org.yuan.project.platform.other;

import java.util.HashMap;
import java.util.Map;

public class CheckExceptionMessage {

	//-------------------------------------------------------
	// 错误代码
	//-------------------------------------------------------
	
	public static final int CODE_10000 = 10000;
	/**
	 * 不是有效的手机号码
	 */
	public static final int CODE_10001 = 10001;
	public static final int CODE_10002 = 10002;
	public static final int CODE_10003 = 10003;
	public static final int CODE_10004 = 10004;
	public static final int CODE_10005 = 10005;
	public static final int CODE_10006 = 10006;
	public static final int CODE_10007 = 10007;
	
	//-------------------------------------------------------
	// 错误信息
	//-------------------------------------------------------
	
	public static final Map<Integer,String> INFO;
	
	static {
		INFO = new HashMap<Integer,String>();
		
		INFO.put(CODE_10000, "程序运行错误");
		INFO.put(CODE_10001, "手机号码错误");
		INFO.put(CODE_10002, "密码必须6-20位");
		INFO.put(CODE_10003, "密码必须包含数字和字母");
		INFO.put(CODE_10004, "用户名已经被注册");
		INFO.put(CODE_10005, "用户名或密码错误");
		INFO.put(CODE_10006, "用户令牌已经失效");
		INFO.put(CODE_10007, "用户令牌不能为空");
	}
	
	/**
	 * 获取错误信息
	 * @param code
	 * 		错误代码
	 * @return
	 */
	public static String getInfo(int code) {
		String info = INFO.get(code);
		
		if(info == null) {
			return "未知错误";
		}
		
		return info;
	}
}
