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

public class customer_ordersDaoImpl implements customer_ordersDao{

		
		public List<Orders> findOrders(String ID) {
			String sql="select orders.id,business.BusinessID,business.BusinessName,goods.GoodsID,goods.GoodsName," + 
					"goods.GoodsType,goods.Image,goods.Introduction,orders.Number,orders.SalePrice,orders.Sum," + 
					"orders.Date from orders,business,goods where orders.BusinessID=business.BusinessID and "+
					"orders.GoodsID=goods.GoodsID and orders.CustomerID='"+ID+"';";
			ResultSet rs;
			rs=dbutil.executeQuery(sql);
			List<Orders> list=new ArrayList<Orders>();
			try {
				while(rs.next()) {
					Orders orders=new Orders();
					orders.setId(rs.getString("id"));
					orders.setBusinessID(rs.getString("BusinessID"));
					orders.setBusinessName(rs.getString("BusinessName"));
					orders.setGoodsID(rs.getString("GoodsID"));
					orders.setGoodsName(rs.getString("GoodsName"));
					orders.setIntroduction(rs.getString("Introduction"));
					orders.setGoodsType("GoodsType");
					orders.setImage(rs.getString("Image"));
					orders.setSalePrice(rs.getString("SalePrice"));
					orders.setNumber(rs.getString("Number"));
					orders.setSum(rs.getString("Sum"));
					orders.setDate(rs.getString("Date"));
					orders.setCustomerID(ID);
					list.add(orders);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			dbutil.close();
			return list;
		}

		
		public int addOrders(Orders order) {
			String sql = "INSERT INTO orders (CustomerID,BusinessID,GoodsID,Number,SalePrice,Sum,Date) "
					+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = dbutil.executePreparedStatement(sql);
			int result = 0 ;
			try {
				double sum=0;
				int number=Integer.parseInt(order.getNumber());
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
			
			
					if(result==1 && order.getDate() != null) {
						manager_orderDaoImpl m=new manager_orderDaoImpl();
						result=m.deleteStock(order);
				}
			dbutil.close();
			return result;
		}
		public int deleteStock(Orders order) {
			
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
			
			String sql2="update stock set Stock=? where BusinessID=? and GoodsID=?;";
			PreparedStatement ps1 = dbutil.executePreparedStatement(sql2);
			
			try {
				
				int number=Integer.parseInt(order.getNumber());
				int stock1=Integer.parseInt(stock.getStock());
				int stock2=stock1-number;
				ps1.setString(1,String.valueOf(stock2));
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
