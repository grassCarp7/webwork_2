package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Business;
import database.Customer;
import database.Manager;

public class Regist {

	//管理员注册
		public int managerRegist(Manager manager) {
			/****如果插入失败，result=0，如果电话号码已经存在，result=3，id已存在，result=4，插入成功则result=1***/
			int result = 0 ;
			//先判断手机号码有没有与其他用户重复，有的话不能增加
			String sql1="select * from manager where ManagerPhone='"+manager.getManagerPhone()+"';";
			ResultSet rs1;
			rs1=dbutil.executeQuery(sql1);
			List<Manager> list1=new ArrayList<Manager>();
			try {
				while(rs1.next()) {
					Manager manager1=new Manager();
					manager1.setManagerPhone(rs1.getString("ManagerPhone"));
					list1.add(manager1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			//再判断id有没有重复，有的话就不能增加
			String sql2="select * from manager where ManagerID='"+manager.getManagerID()+"';";
			ResultSet rs2;
			rs2=dbutil.executeQuery(sql2);
			List<Manager> list2=new ArrayList<Manager>();
			try {
				while(rs2.next()) {
					Manager manager1=new Manager();
					manager1.setManagerID(rs2.getString("ManagerID"));;
					list2.add(manager1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			if(list1.size()==0&&list2.size()==0) {
				String sql = "INSERT INTO manager (ManagerID,ManagerName,ManagerPhone,ManagerAddress,ManagerPsw) "
					+ "VALUES (?,?,?,?,?)";
				PreparedStatement ps = dbutil.executePreparedStatement(sql);
				try {
					
					ps.setString(1,manager.getManagerID());
					ps.setString(2,manager.getManagerName());
					ps.setString(3,manager.getManagerPhone());
					ps.setString(4,manager.getManagerAddress());
					ps.setString(5,manager.getManagerPsw());
					result = ps.executeUpdate();
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(list2.size()>0)
				result=4;
			else if(list1.size()>0)
				result=3;
			return result;
		}
		//顾客注册
		public int customerRegist(Customer customer) {
			/****如果插入失败，result=0，如果电话号码已经存在，result=3，id已存在，result=4，插入成功则result=1***/
			int result = 0 ;
			//先判断手机号码有没有与其他用户重复，有的话不能增加
			String sql1="select * from customer where CustomerPhone='"+customer.getCustomerPhone()+"';";
			ResultSet rs1;
			rs1=dbutil.executeQuery(sql1);
			List<Customer> list1=new ArrayList<Customer>();
			try {
				while(rs1.next()) {
					Customer customer1=new Customer();
					customer1.setCustomerPhone(rs1.getString("CustomerPhone"));
					list1.add(customer1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			//再判断id有没有重复，有的话就不能增加
			String sql2="select * from customer where CustomerID='"+customer.getCustomerID()+"';";
			ResultSet rs2;
			rs2=dbutil.executeQuery(sql2);
			List<Customer> list2=new ArrayList<Customer>();
			try {
				while(rs2.next()) {
					Customer customer1=new Customer();
					customer1.setCustomerID(rs2.getString("CustomerID"));
					list2.add(customer1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			if(list1.size()==0&&list2.size()==0) {
				String sql = "INSERT INTO customer (CustomerID,CustomerName,CustomerPhone,CustomerAddress,CustomerPsw) "
					+ "VALUES (?,?,?,?,?)";
				PreparedStatement ps = dbutil.executePreparedStatement(sql);
				try {
					
					ps.setString(1,customer.getCustomerID());
					ps.setString(2,customer.getCustomerName());
					ps.setString(3,customer.getCustomerPhone());
					ps.setString(4,customer.getCustomerAddress());
					ps.setString(5,customer.getCustomerPsw());
					result = ps.executeUpdate();
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(list2.size()>0)
				result=4;
			else if(list1.size()>0)
				result=3;
			return result;
			
		}
		//商家注册
		public int businessRegist(Business business) {
			/****如果插入失败，result=0，如果电话号码已经存在，result=3，id已存在，result=4，插入成功则result=1***/
			int result = 0 ;
			//先判断手机号码有没有与其他用户重复，有的话不能增加
			String sql1="select * from business where BusinessPhone='"+business.getBusinessPhone()+"';";
			ResultSet rs1;
			rs1=dbutil.executeQuery(sql1);
			List<Business> list1=new ArrayList<Business>();
			try {
				while(rs1.next()) {
					Business business1=new Business();
					business1.setBusinessPhone(rs1.getString("BusinessPhone"));
					list1.add(business1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			//再判断id有没有重复，有的话就不能增加
			String sql2="select * from business where BusinessID='"+business.getBusinessID()+"';";
			ResultSet rs2;
			rs2=dbutil.executeQuery(sql2);
			List<Business> list2=new ArrayList<Business>();
			try {
				while(rs2.next()) {
					Business business1=new Business();
					business1.setBusinessID(rs2.getString("BusinessID"));
					list2.add(business1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			if(list1.size()==0&&list2.size()==0) {
				String sql = "INSERT INTO business (BusinessID,BusinessName,BusinessPhone,BusinessPsw,BusinessAddress) "
					+ "VALUES (?,?,?,?,?)";
				PreparedStatement ps = dbutil.executePreparedStatement(sql);
				try {
					ps.setString(1,business.getBusinessID());
					ps.setString(2,business.getBusinessName());
					ps.setString(3,business.getBusinessPhone());
					ps.setString(4,business.getBusinessPsw());
					ps.setString(5,business.getBusinessAddress());
					result = ps.executeUpdate();
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(list2.size()>0)
				result=4;
			else if(list1.size()>0)
				result=3;
			return result;
		}
}
