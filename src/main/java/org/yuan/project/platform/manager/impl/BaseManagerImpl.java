package org.yuan.project.platform.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.yuan.project.platform.mapper.ClientMapper;
import org.yuan.project.platform.mapper.GenreMapper;
import org.yuan.project.platform.mapper.ProductMapper;
import org.yuan.project.platform.mapper.TokenMapper;

public class BaseManagerImpl {

	@Autowired
	protected ClientMapper clientMapper;
	
	@Autowired
	protected TokenMapper tokenMapper;
	
	@Autowired
	protected GenreMapper genreMapper;
	
	@Autowired
	protected ProductMapper productMapper;
}
