package org.yuan.project.platform.manager.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yuan.project.platform.entity.Product;
import org.yuan.project.platform.manager.ProductManager;

@Service("productManager")
@Transactional
public class ProductManagerImpl extends BaseManagerImpl implements ProductManager {

	@Override
	public List<Product> selectProductList(Integer type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectProduct(Integer id) {
		Product item = productMapper.selectByPrimaryKey(id);
		return item;
	}
	
}
