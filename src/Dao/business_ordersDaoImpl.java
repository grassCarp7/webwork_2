package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Goods;
import database.Orders;
import database.Stock;

public class business_ordersDaoImpl implements business_ordersDao{

	
	public List<Orders> findAll(String ID) {
		String sql="select orders.id,customer.CustomerID,customer.CustomerName,goods.GoodsID," + 
				"goods.GoodsName,goods.GoodsType,orders.Number,orders.SalePrice,orders.Sum," + 
				"orders.Date,goods.Image,goods.Introduction from orders,customer,goods where orders.CustomerID=customer.CustomerID " + 
				"and orders.GoodsID=goods.GoodsID and orders.BusinessID='"+ID+"' ;";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Orders> list=new ArrayList<Orders>();
		try {
			while(rs.next()) {
				Orders orders=new Orders();
				orders.setId(rs.getString("id"));
				orders.setCustomerID(rs.getString("CustomerID"));
				orders.setCustomerName(rs.getString("CustomerName"));
				orders.setGoodsID(rs.getString("GoodsID"));
				orders.setGoodsName(rs.getString("GoodsName"));
				orders.setGoodsType(rs.getString("GoodsType"));
				orders.setNumber(rs.getString("Number"));
				orders.setSalePrice(rs.getString("SalePrice"));
				orders.setSum(rs.getString("Sum"));
				orders.setDate(rs.getString("Date"));
				orders.setImage(rs.getString("Image"));
				orders.setIntroduction(rs.getString("Introduction"));
				list.add(orders);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	
	public List<Orders> find(String ID,String customername, String goodsname, String goodstype, int min, int max) {
		String sql="select orders.id,customer.CustomerID,customer.CustomerName,goods.GoodsID," + 
				"goods.GoodsName,goods.GoodsType,orders.Number,orders.SalePrice,orders.Sum," + 
				"orders.Date from orders,customer,goods where orders.CustomerID=customer.CustomerID " + 
				"and orders.GoodsID=goods.GoodsID and orders.BusinessID='"+ID+"' and " + 
				"customer.CustomerName like '%"+customername+"%' and goods.GoodsName like '%"+goodsname+"%' and " + 
				"goods.GoodsType like '%"+goodstype+"%' and (orders.SalePrice between "+min+" and "+max+");";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Orders> list=new ArrayList<Orders>();
		try {
			while(rs.next()) {
				Orders orders=new Orders();
				orders.setId(rs.getString("id"));
				orders.setCustomerID(rs.getString("CustomerID"));
				orders.setCustomerName(rs.getString("CustomerName"));
				orders.setGoodsID(rs.getString("GoodsID"));
				orders.setGoodsName(rs.getString("GoodsName"));
				orders.setGoodsType(rs.getString("GoodsType"));
				orders.setNumber(rs.getString("Number"));
				orders.setSalePrice(rs.getString("SalePrice"));
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

}