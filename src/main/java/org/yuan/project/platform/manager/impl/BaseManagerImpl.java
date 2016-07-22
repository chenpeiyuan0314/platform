package org.yuan.project.platform.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yuan.project.platform.mapper.ClientMapper;
import org.yuan.project.platform.mapper.TokenMapper;

public class BaseManagerImpl {

	@Autowired
	protected ClientMapper clientMapper;
	
	@Autowired
	protected TokenMapper tokenMapper;
}
