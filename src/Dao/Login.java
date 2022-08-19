package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Business;
import database.Customer;
import database.Manager;

public class Login {

	
	public Manager managerLogin(String ID,String Psw) {
		String sql="select * from manager where ManagerID='"+ID+"' and ManagerPsw='"+Psw+"';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		Manager manager=new Manager();
		try {
			if(rs.next()) {
				manager.setManagerID(rs.getString("ManagerID"));
				manager.setManagerName(rs.getString("ManagerName"));
				manager.setManagerPhone(rs.getString("ManagerPhone"));
				manager.setManagerPsw(rs.getString("ManagerPsw"));
				manager.setManagerAddress(rs.getString("ManagerAddress"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return manager;
		
	}
	
	public Customer customerLogin(String ID,String Psw) {
		String sql="select * from customer where CustomerID='"+ID+"' and CustomerPsw='"+Psw+"';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		Customer customer=new Customer();
		try {
			if(rs.next()) {
				customer.setCustomerID(rs.getString("CustomerID"));
				customer.setCustomerName(rs.getString("CustomerName"));
				customer.setCustomerPhone(rs.getString("CustomerPhone"));
				customer.setCustomerPsw(rs.getString("CustomerPsw"));
				customer.setCustomerAddress(rs.getString("CustomerAddress"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return customer;
		
	}
	
	public Business businessLogin(String ID,String Psw) {
		String sql="select * from business where BusinessID='"+ID+"' and BusinessPsw='"+Psw+"';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		Business business=new Business();
		try {
			if(rs.next()) {
				business.setBusinessID(rs.getString("BusinessID"));
				business.setBusinessName(rs.getString("BusinessName"));
				business.setBusinessPhone(rs.getString("BusinessPhone"));
				business.setBusinessPsw(rs.getString("BusinessPsw"));
				business.setBusinessAddress(rs.getString("BusinessAddress"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return business;
	}
}
