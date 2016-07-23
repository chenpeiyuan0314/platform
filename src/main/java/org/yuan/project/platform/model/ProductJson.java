package org.yuan.project.platform.model;

public class ProductJson {

	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getProductTitle() {
		return productTitle;
	}
	
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	
	public String getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getProductDetail() {
		return productDetail;
	}
	
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	
	public String getProductGenre() {
		return productGenre;
	}
	
	public void setProductGenre(String productGenre) {
		this.productGenre = productGenre;
	}
	
	private Integer productId;
	private String productTitle;
	private String productPrice;
	private String productDetail;
	private String productGenre;
}
