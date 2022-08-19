package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Customer;

public class manager_customerDaoImpl implements manager_customerDao{

	//
	public List<Customer> findAll() {
		String sql="select * from customer;";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Customer> list=new ArrayList<Customer>();
		try {
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setCustomerID(rs.getString("CustomerID"));
				customer.setCustomerName(rs.getString("CustomerName"));
				customer.setCustomerPhone(rs.getString("CustomerPhone"));
				customer.setCustomerAddress(rs.getString("CustomerAddress"));
				customer.setCustomerPsw(rs.getString("CustomerPsw"));
				list.add(customer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	//
	public List<Customer> findCustomerID(String ID) {
		String sql="select * from customer where CustomerID like '%"+ID+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Customer> list=new ArrayList<Customer>();
		try {
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setCustomerID(rs.getString("CustomerID"));
				customer.setCustomerName(rs.getString("CustomerName"));
				customer.setCustomerPhone(rs.getString("CustomerPhone"));
				customer.setCustomerAddress(rs.getString("CustomerAddress"));
				customer.setCustomerPsw(rs.getString("CustomerPsw"));
				list.add(customer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	//
	public List<Customer> findCustomerName(String name) {
		String sql="select * from customer where CustomerName like '%"+name+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Customer> list=new ArrayList<Customer>();
		try {
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setCustomerID(rs.getString("CustomerID"));
				customer.setCustomerName(rs.getString("CustomerName"));
				customer.setCustomerPhone(rs.getString("CustomerPhone"));
				customer.setCustomerAddress(rs.getString("CustomerAddress"));
				customer.setCustomerPsw(rs.getString("CustomerPsw"));
				list.add(customer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	//
	public List<Customer> findCustomerPhone(String phone) {
		String sql="select * from customer where CustomerPhone like '%"+phone+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Customer> list=new ArrayList<Customer>();
		try {
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setCustomerID(rs.getString("CustomerID"));
				customer.setCustomerName(rs.getString("CustomerName"));
				customer.setCustomerPhone(rs.getString("CustomerPhone"));
				customer.setCustomerAddress(rs.getString("CustomerAddress"));
				customer.setCustomerPsw(rs.getString("CustomerPsw"));
				list.add(customer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	//
	public int addCustomer(Customer customer) {
		/****濡傛灉鎻掑叆澶辫触锛宺esult=0锛屽鏋滅數璇濆彿鐮佸凡缁忓瓨鍦紝result=3锛屾彃鍏ユ垚鍔熷垯result=1***/
		int result = 0 ;
		//
		String sql1="select * from customer where CustomerPhone='"+customer.getCustomerPhone()+"';";
		ResultSet rs1;
		rs1=dbutil.executeQuery(sql1);
		List<Customer> list1=new ArrayList<Customer>();
		try {
			while(rs1.next()) {
				Customer customer1=new Customer();
				customer1.setCustomerPhone("CustomerPhone");
				list1.add(customer1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(list1.size()==0) {
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
		if(list1.size()>0)
			result=3;
		return result;
	}

	//
	public int deleteCustomer(String ID) {
		String sql="delete from customer where CustomerID = '"+ID+"';";
		int result = 0 ;
		result = dbutil.executeUpdate(sql);
		dbutil.close();
		return result;
	}

	//
	public int updateCustomer(Customer customer) {
		/****濡傛灉鎻掑叆澶辫触锛宺esult=0锛屽鏋滅數璇濆彿鐮佸凡缁忓瓨鍦紝result=3锛屾彃鍏ユ垚鍔熷垯result=1***/
		int result = 0 ;
		//
		String sql1="select * from customer where CustomerPhone='"+customer.getCustomerPhone()+"' and CustomerID !='"+customer.getCustomerID()+"';";
		ResultSet rs1;
		rs1=dbutil.executeQuery(sql1);
		List<Customer> list1=new ArrayList<Customer>();
		try {
			while(rs1.next()) {
				Customer customer1=new Customer();
				customer1.setCustomerPhone("CustomerPhone");
				list1.add(customer1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(list1.size()==0) {
			String sql = "update customer set CustomerPhone=?,CustomerAddress=?,CustomerPsw=? WHERE CustomerID=? and CustomerName=?;";
			PreparedStatement ps = dbutil.executePreparedStatement(sql);
			try {
			
				ps.setString(1,customer.getCustomerPhone());
				ps.setString(2,customer.getCustomerAddress());
				ps.setString(3,customer.getCustomerPsw());
				ps.setString(4,customer.getCustomerID());
				ps.setString(5,customer.getCustomerName());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(list1.size()>0)
			result=3;
	return result;	
	}

}
