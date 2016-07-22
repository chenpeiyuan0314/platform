package org.yuan.project.platform.manager.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yuan.project.platform.entity.Client;
import org.yuan.project.platform.entity.Token;
import org.yuan.project.platform.helper.CodeHelper;
import org.yuan.project.platform.manager.ClientManager;

@Service
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
	public boolean selectExists(String username, String password) {
		Map<String,Object> args = new HashMap<String,Object>();
		args.put("phone", username);
		args.put("password", password);
		int count = clientMapper.selectCount(args);
		return count == 1 ? true : false;
	}
	
}
