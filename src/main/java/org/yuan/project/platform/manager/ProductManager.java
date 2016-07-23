package org.yuan.project.platform.manager;

import java.util.List;

import org.yuan.project.platform.entity.Product;

public interface ProductManager {
	
	/**
	 * 根据搜索条件获取商品列表
	 * @param type
	 * @return
	 */
	List<Product> selectProductList(Integer type);
	
	/**
	 * 根据商品标识获取商品记录
	 * @param id
	 * @return
	 */
	Product selectProduct(Integer id);
}
