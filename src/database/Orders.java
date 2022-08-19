package database;

public class Orders {
	private String id;//订单id
	private String CustomerID;//顾客ID
	private String CustomerName;//顾客姓名
	private String BusinessID;//商家ID
	private String BusinessName;//商家姓名
	private String GoodsID;//商品ID
	private String GoodsName;//商品名
	private String GoodsType;//商品品种
	private String Image;//照片路径
	private String Number;//购买数量
	private String Introduction;//商品描述
	private String SalePrice;//售价
	private String Sum;//总价
	private String Date;//下单日期
	public Orders() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getBusinessID() {
		return BusinessID;
	}
	public void setBusinessID(String businessID) {
		BusinessID = businessID;
	}
	public String getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(String goodsID) {
		GoodsID = goodsID;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(String salePrice) {
		SalePrice = salePrice;
	}
	public String getSum() {
		return Sum;
	}
	public void setSum(String sum) {
		Sum = sum;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getBusinessName() {
		return BusinessName;
	}
	public void setBusinessName(String businessName) {
		BusinessName = businessName;
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

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getIntroduction() {
		return Introduction;
	}

	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
	
}
