package database;

public class Business {
	private String BusinessID;//商家ID
	private String BusinessName;//商家名
	private String BusinessPhone;//商家电话
	private String BusinessPsw;//商家密码
	private String BusinessAddress;//商家地址
	public Business() {
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
	public String getBusinessPhone() {
		return BusinessPhone;
	}
	public void setBusinessPhone(String businessPhone) {
		BusinessPhone = businessPhone;
	}
	public String getBusinessPsw() {
		return BusinessPsw;
	}
	public void setBusinessPsw(String businessPsw) {
		BusinessPsw = businessPsw;
	}
	public String getBusinessAddress() {
		return BusinessAddress;
	}
	public void setBusinessAddress(String businessAddress) {
		BusinessAddress = businessAddress;
	}
	
}
