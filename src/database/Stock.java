package database;

public class Stock {
	private String BusinessID;//商家ID
	private String BusinessName;//商家名
	private String GoodsID;//商品ID
	private String GoodsName;//商品名
	private String GoodsType;//商品类
	private String Introduction;//商品简介
	private String Image;//商品图片路径
	private String SalePrice;//售价
	private String PurchasePrice;//进货价
	private String PurchaseNum;//进货量
	private String Stock;//库存

	public Stock() {
		super();
	}
	public String getBusinessID() {
		return BusinessID;
	}
	public void setBusinessID(String businessID) {
		BusinessID = businessID;
	}
	public String getBusinessName() {
		return BusinessName;
	}
	public void setBusinessName(String businessName) {
		BusinessName = businessName;
	}
	public String getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(String goodsID) {
		GoodsID = goodsID;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public String getGoodsType() {
		return GoodsType;
	}
	public void setGoodsType(String goodsType) {
		GoodsType = goodsType;
	}
	
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(String salePrice) {
		SalePrice = salePrice;
	}
	public String getPurchasePrice() {
		return PurchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		PurchasePrice = purchasePrice;
	}
	public String getPurchaseNum() {
		return PurchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		PurchaseNum = purchaseNum;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	
	
}
