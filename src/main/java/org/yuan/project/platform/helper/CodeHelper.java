package org.yuan.project.platform.helper;

import java.security.MessageDigest;
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
	
	/**
	 * SHA加密
	 * @param text
	 * @return
	 */
	public static String sha(String text) {
		return encode(text, "SHA");
	}
	
	/**
	 * MD5加密
	 * @param text
	 * @return
	 */
	public static String md5(String text) {
		return encode(text, "MD5");
	}
	
	/**
	 * MD5或SHA加密
	 * @return
	 */
	private static String encode(String text, String encode) {
		try {
			MessageDigest digest = MessageDigest.getInstance(encode);
			digest.update(text.getBytes("UTF-8"));
			byte[] bs = digest.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < bs.length; i++) {
				String hex = Integer.toHexString(bs[i] & 0xFF);
				if (hex.length() < 2) {
					sb.append(0);
				}
				sb.append(hex);
			}
			
			return sb.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
