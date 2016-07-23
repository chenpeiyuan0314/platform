package org.yuan.project.platform.manager.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yuan.project.platform.entity.Client;
import org.yuan.project.platform.entity.Token;
import org.yuan.project.platform.helper.CodeHelper;
import org.yuan.project.platform.manager.ClientManager;

@Service("clientManager")
@Transactional
public class ClientManagerImpl extends BaseManagerImpl implements ClientManager {

	@Override
	public int insertSelective(Client client) {
		int count = clientMapper.insertSelective(client);
		return count;
	}
	
	@Override
	public int insertSelective(Token token) {
		int count = tokenMapper.insertSelective(token);
		return count;
	}
	
	@Override
	public int updateSelective(Client client) {
		int count = clientMapper.updateByPrimaryKeySelective(client);
		return count;
	}

	@Override
	public int updateSelective(Token token) {
		int count = tokenMapper.updateByPrimaryKeySelective(token);
		return count;
	}
	
	@Override
	public Token selectToken(String code, String date) {
		Map<String,Object> args = new HashMap<String,Object>();
		args.put("code", code);
		args.put("date", date);
		Token token = tokenMapper.selectSole(args);
		return token;
	}

	@Override
	public Client selectClient(String phone, String password) {
		Map<String,Object> args = new HashMap<String,Object>();
		args.put("phone", phone);
		args.put("password", password);
		Client client = clientMapper.selectSole(args);
		return client;
	}

	@Override
	public Client selectClient(Integer id) {
		Client client = clientMapper.selectByPrimaryKey(id);
		return client;
	}

	@Override
	public boolean selectExists(String username) {
		Map<String,Object> args = new HashMap<String,Object>();
		args.put("phone", username);
		int count = clientMapper.selectCount(args);
		return count == 1 ? true : false;
	}
	
}
