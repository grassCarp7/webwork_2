package database;

public class Customer {
	private String CustomerID;//顾客ID
	private String CustomerName;//顾客姓名
	private String CustomerPhone;//顾客电话
	private String CustomerAddress;//顾客地址
	private String CustomerPsw;//顾客密码
	public Customer() {
		super();
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerPhone() {
		return CustomerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	public String getCustomerPsw() {
		return CustomerPsw;
	}
	public void setCustomerPsw(String customerPsw) {
		CustomerPsw = customerPsw;
	}
	
}
