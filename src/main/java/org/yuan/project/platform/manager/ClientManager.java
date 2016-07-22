package org.yuan.project.platform.manager;

import org.yuan.project.platform.entity.Client;
import org.yuan.project.platform.entity.Token;

public interface ClientManager {
	
	int insertSelective(Client client);
	
	int insertSelective(Token token);
	
	int updateSelective(Client client);
	
	int updateSelective(Token token);
	
	/**
	 * 根据令牌和失效时间获取记录
	 * @param code
	 * @param date
	 * @return
	 */
	Token selectToken(String code, String date);
	
	/**
	 * 根据电话和密码获取记录
	 * @param phone
	 * @param password
	 * @return
	 */
	Client selectClient(String phone, String password);
	
	/**
	 * 根据用户标识获取记录
	 * @param id
	 * @return
	 */
	Client selectClient(Integer id);
	
	/**
	 * 判断电话是否已经注册
	 * @param username
	 * @return
	 */
	boolean selectExists(String phone);
}
