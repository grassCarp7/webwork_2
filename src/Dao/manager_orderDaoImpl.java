package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Orders;
import database.Stock;

public class manager_orderDaoImpl implements manager_orderDao{

	
	//
	public List<Orders> findAll() {
		String sql="select orders.id,customer.CustomerID,customer.CustomerName,business.BusinessID,business.BusinessName," + 
				"goods.GoodsID,goods.GoodsName,orders.SalePrice,orders.Number,orders.Sum,orders.Date " + 
				"from orders,business,goods,customer where customer.CustomerID=orders.CustomerID and " + 
				"business.BusinessID=orders.BusinessID and goods.GoodsID=orders.GoodsID;";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Orders> list=new ArrayList<Orders>();
		try {
			while(rs.next()) {
				Orders orders=new Orders();
				orders.setId(rs.getString("id"));
				orders.setBusinessID(rs.getString("BusinessID"));
				orders.setBusinessName(rs.getString("BusinessName"));
				orders.setCustomerID(rs.getString("CustomerID"));
				orders.setCustomerName(rs.getString("CustomerName"));
				orders.setGoodsID(rs.getString("GoodsID"));
				orders.setGoodsName(rs.getString("GoodsName"));
				orders.setSalePrice(rs.getString("SalePrice"));
				orders.setNumber(rs.getString("Number"));
				orders.setSum(rs.getString("Sum"));
				orders.setDate(rs.getString("Date"));
				list.add(orders);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	//
	public List<Orders> findCustomer_Goods_BusinessID(String CID, String GID, String BID) {
		String sql="select orders.id,customer.CustomerID,customer.CustomerName,business.BusinessID,business.BusinessName," + 
				"goods.GoodsID,goods.GoodsName,orders.SalePrice,orders.Number,orders.Sum,orders.Date " + 
				"from orders,business,goods,customer where customer.CustomerID=orders.CustomerID and " + 
				"business.BusinessID=orders.BusinessID and goods.GoodsID=orders.GoodsID and "+
				"orders.GoodsID like '%"+GID+"%' and orders.CustomerID like '%"+CID+"%' and orders.BusinessID like '%"+BID+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Orders> list=new ArrayList<Orders>();
		try {
			while(rs.next()) {
				Orders orders=new Orders();
				orders.setId(rs.getString("id"));
				orders.setBusinessID(rs.getString("BusinessID"));
				orders.setBusinessName(rs.getString("BusinessName"));
				orders.setCustomerID(rs.getString("CustomerID"));
				orders.setCustomerName(rs.getString("CustomerName"));
				orders.setGoodsID(rs.getString("GoodsID"));
				orders.setGoodsName(rs.getString("GoodsName"));
				orders.setSalePrice(rs.getString("SalePrice"));
				orders.setNumber(rs.getString("Number"));
				orders.setSum(rs.getString("Sum"));
				orders.setDate(rs.getString("Date"));
				list.add(orders);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	/**************婢х偛鍨归弨锟�******************/
	//
	public int addOrders(Orders order) {
		String sql = "INSERT INTO orders (CustomerID,BusinessID,GoodsID,Number,SalePrice,Sum,Date) "
				+ "VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = dbutil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			double sum=0;
			int number=Integer.parseInt(order.getNumber());//
			double saleprice=Double.parseDouble(order.getSalePrice());//
			//
			sum=number*saleprice;
			//
			DecimalFormat df = new DecimalFormat("0.00");
			//
			String saleprice1=df.format(saleprice);
			String sum1 = df.format(sum);
			
			ps.setString(1,order.getCustomerID());
			ps.setString(2,order.getBusinessID());
			ps.setString(3,order.getGoodsID());
			ps.setString(4,String.valueOf(number));//
			ps.setString(5,saleprice1);
			ps.setString(6,sum1);
			ps.setString(7, order.getDate());
			result = ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
				if(result==1) {
					manager_orderDaoImpl m=new manager_orderDaoImpl();
					result=m.deleteStock(order);
			}
		dbutil.close();
		return result;
	}

	//
	public int deleteOrders(Orders order) {
		//
		String sql="delete from orders where CustomerID = '"+order.getCustomerID()+"' and BusinessID='"+order.getBusinessID()+"' and GoodsID='"+order.getGoodsID()+"' and id="+order.getId()+";";
		int result = 0 ;
		result = dbutil.executeUpdate(sql);
		
		//
		if(result==1 && order.getDate() != null) {
			manager_orderDaoImpl m=new manager_orderDaoImpl();
			result=m.addStock(order);
	}
		dbutil.close();
		return result;
	}

	//
	public int updateOrders(Orders order) {
		
		//
		String sql1="select * from orders where orders.GoodsID='"+order.getGoodsID()+"' and orders.CustomerID='"+order.getCustomerID()+"' and orders.BusinessID='"+order.getBusinessID()+"' and id="+order.getId()+";";
		ResultSet rs;
		rs=dbutil.executeQuery(sql1);
		Orders goods=new Orders();
		try {
			if(rs.next()) {
				goods.setNumber(rs.getString("Number"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "update orders set Number=?,SalePrice=?,Sum=?,Date = ? WHERE GoodsID=? and CustomerID=? and BusinessID=? and id=?;";
		PreparedStatement ps = dbutil.executePreparedStatement(sql);
		int result = 0 ;
		double sum=0;
		int number=Integer.parseInt(order.getNumber());//
		
		double saleprice=Double.parseDouble(order.getSalePrice());//
		//
		sum=number*saleprice;
		//
		DecimalFormat df = new DecimalFormat("0.00");
		
		String saleprice1=df.format(saleprice);
		String sum1 = df.format(sum);
		
		try {
			System.out.println("NUMBER: " + number);
			ps.setString(1,number + "");//
			ps.setString(2,saleprice1);
			ps.setString(3,sum1);
			ps.setString(5,order.getGoodsID());
			ps.setString(6,order.getCustomerID());
			ps.setString(7,order.getBusinessID());
			ps.setString(8,order.getId());
			if(order.getDate() != null)
			{
				ps.setString(4,order.getDate());
			}
			else
			{
				System.out.println("!DATE CHECKED!");
				ps.setString(4,null);
			}
			result = ps.executeUpdate();
			System.out.println("result = " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  if(result==1 && order.getDate() != null) { 
			  int num=Integer.parseInt(goods.getNumber());//
			  manager_orderDaoImpl m=new manager_orderDaoImpl();
		  //
			  
			  order.setNumber(String.valueOf(number)); result=m.deleteStock(order); 
			  
		  
		  }
		 
			
		dbutil.close();
		return result;
	}
	//
	public int addStock(Orders order) {
		//
		String sql="select * from stock where BusinessID='"+order.getBusinessID()+"' and GoodsID='"+order.getGoodsID()+"';";
		ResultSet rs;
		int result=-1;
		rs=dbutil.executeQuery(sql);
		Stock stock=new Stock();
		try {
			if(rs.next()) {
			stock.setStock(rs.getString("Stock"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//
		String sql2="update stock set Stock=? where BusinessID=? and GoodsID=?;";
		PreparedStatement ps1 = dbutil.executePreparedStatement(sql2);
		
		try {
			//
			int number=Integer.parseInt(order.getNumber());
			int stock1=Integer.parseInt(stock.getStock());
			int stock2=stock1+number;
			ps1.setString(1,String.valueOf(stock2));//
			ps1.setString(2,order.getBusinessID());
			ps1.setString(3,order.getGoodsID());
			result = ps1.executeUpdate()+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int deleteStock(Orders order) {
		//
		String sql="select * from stock where BusinessID='"+order.getBusinessID()+"' and GoodsID='"+order.getGoodsID()+"';";
		ResultSet rs;
		int result=-1;
		rs=dbutil.executeQuery(sql);
		Stock stock=new Stock();
		try {
			if(rs.next()) {
			stock.setStock(rs.getString("Stock"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//
		String sql2="update stock set Stock=? where BusinessID=? and GoodsID=?;";
		PreparedStatement ps1 = dbutil.executePreparedStatement(sql2);
		
		try {
			//
			int number=Integer.parseInt(order.getNumber());
			int stock1=Integer.parseInt(stock.getStock());
			int stock2;
			if(stock1 >= number)
			{
				stock2=stock1-number;
			}
			else
			{
				stock2 = 0;
			}
			ps1.setString(1,String.valueOf(stock2));//
			ps1.setString(2,order.getBusinessID());
			ps1.setString(3,order.getGoodsID());
			result = ps1.executeUpdate()+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
