package org.yuan.project.platform.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuan.project.platform.entity.Product;
import org.yuan.project.platform.helper.CheckHelper;
import org.yuan.project.platform.model.ProductJson;
import org.yuan.project.platform.model.ResultJson;

@Controller
@RequestMapping("/v1/product")
public class ProductController extends BaseController {

	@ResponseBody
	@RequestMapping("list")
	public ResultJson listJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			String type = request.getParameter("type");
			
			// 校验参数 - 
			CheckHelper.checkShowType(type);
			
			// 处理请求
			List<Product> products = productManager.selectProductList(Integer.valueOf(type));
			List<ProductJson> productList = new ArrayList<ProductJson>();
			for(Product product : products) {
				ProductJson item = new ProductJson();
				productList.add(item);
			}
			
			// 返回数据
			result.getData().put("productList", productList);
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("info")
	public ResultJson infoJson(HttpServletRequest request) {
		ResultJson result = new ResultJson();
		
		try {
			
			log(request);
			
			// 获取参数
			String id = request.getParameter("productId");
			
			// 校验参数 - 
			CheckHelper.checkProductId(id);
			
			// 处理请求
			Product product = productManager.selectProduct(Integer.valueOf(id));
			
			// 返回数据
			result.getData().put("product", product);
			
		} catch(Exception e) {
			exc(result, e);
		}
		
		log(result);
		return result;
	}
	
}
