package database;

public class Manager {

	private String ManagerID;//管理员ID
	private String ManagerName;//管理员姓名
	private String ManagerPhone;//管理员电话
	private String ManagerPsw;//管理员密码
	private String ManagerAddress;//管理员地址
	public Manager() {
		super();
	}
	public String getManagerID() {
		return ManagerID;
	}
	public void setManagerID(String managerID) {
		ManagerID = managerID;
	}
	public String getManagerName() {
		return ManagerName;
	}
	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}
	public String getManagerPhone() {
		return ManagerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		ManagerPhone = managerPhone;
	}
	public String getManagerPsw() {
		return ManagerPsw;
	}
	public void setManagerPsw(String managerPsw) {
		ManagerPsw = managerPsw;
	}
	public String getManagerAddress() {
		return ManagerAddress;
	}
	public void setManagerAddress(String managerAddress) {
		ManagerAddress = managerAddress;
	}
	
}
