package org.yuan.project.platform.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yuan.project.platform.entity.Product;
import org.yuan.project.platform.manager.ProductManager;

@Service("productManager")
@Transactional
public class ProductManagerImpl extends BaseManagerImpl implements ProductManager {

	@Override
	public List<Product> selectProductList(Integer type) {
		Map<String,Object> args = new HashMap<String,Object>();
		List<Product> list = productMapper.selectList(args);
		return list;
	}

	@Override
	public Product selectProduct(Integer id) {
		Product item = productMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public int selectProductSize(Integer id) {
		Map<String,Object> args = new HashMap<String,Object>();
		args.put("id", id);
		int size = productMapper.selectSize(args);
		return size;
	}
	
	
}
