package org.yuan.project.platform.helper;

import java.util.UUID;

public class CodeHelper {
	
	/**
	 * 根据UUID获取token
	 * @return
	 */
	public static String token() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		str = str.replace("-", "");
		str = str.toUpperCase();
		return str;
	}
	
}
