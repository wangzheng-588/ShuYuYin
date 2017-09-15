package cn.shuyuyin.bean;

public class Goods {

	private String imageUrl;
	
	private String productTitle;
	private String productCategory;
	private double productSpecification;
	private long productPrice;
	private int productCount;
	//后面要
	private boolean isCuxiao;
	private String cuxiaoDes;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getProductSpecification() {
		return productSpecification;
	}
	public void setProductSpecification(double productSpecification) {
		this.productSpecification = productSpecification;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public boolean isCuxiao() {
		return isCuxiao;
	}
	public void setCuxiao(boolean isCuxiao) {
		this.isCuxiao = isCuxiao;
	}
	public String getCuxiaoDes() {
		return cuxiaoDes;
	}
	public void setCuxiaoDes(String cuxiaoDes) {
		this.cuxiaoDes = cuxiaoDes;
	}
	
}
