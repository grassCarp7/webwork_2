package database;

public class Goods {
	private String GoodsID;
	private String GoodsName;
	private String GoodsType;
	private String Introduction;
	private String Image;
	public Goods() {
		super();
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
	
}
