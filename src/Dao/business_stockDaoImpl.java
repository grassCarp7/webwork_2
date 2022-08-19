package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Goods;
import database.Stock;

public class business_stockDaoImpl implements business_stockDao{

	
	public List<Stock> findAll(String ID) {
		String sql="select stock.BusinessID,stock.GoodsID,goods.GoodsName,goods.GoodsType," + 
				"stock.SalePrice,stock.PurchasePrice,stock.PurchaseNum,stock.Stock,goods.Introduction,goods.Image" + 
				" from stock,goods where stock.GoodsID=goods.GoodsID and stock.BusinessID='"+ID+"';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Stock> list=new ArrayList<Stock>();
		try {
			while(rs.next()) {
				Stock stock=new Stock();
				stock.setBusinessID(rs.getString("BusinessID"));
				stock.setGoodsID(rs.getString("GoodsID"));
				stock.setGoodsName(rs.getString("GoodsName"));
				stock.setGoodsType(rs.getString("GoodsType"));
				stock.setPurchasePrice(rs.getString("PurchasePrice"));
				stock.setSalePrice(rs.getString("SalePrice"));
				stock.setPurchaseNum(rs.getString("PurchaseNum"));
				stock.setStock(rs.getString("Stock"));
				stock.setIntroduction(rs.getString("Introduction"));
				stock.setImage(rs.getString("Image"));
				list.add(stock);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	
	public List<Stock> find(String ID, String goodstype, String goodsname, int min, int max) {
		String sql="select stock.BusinessID,stock.GoodsID,goods.GoodsName,goods.GoodsType," + 
				"stock.SalePrice,stock.PurchasePrice,stock.PurchaseNum,stock.Stock" + 
				" from stock,goods where stock.GoodsID=goods.GoodsID and stock.BusinessID='"+ID+"'" + 
				" and goods.GoodsType like'%"+goodstype+"%' and goods.GoodsName like '%"+goodsname+"%'"+
				" and (stock.Stock between "+min+" and "+max+");";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Stock> list=new ArrayList<Stock>();
		try {
			while(rs.next()) {
				Stock stock=new Stock();
				stock.setBusinessID(rs.getString("BusinessID"));
				stock.setGoodsID(rs.getString("GoodsID"));
				stock.setGoodsName(rs.getString("GoodsName"));
				stock.setGoodsType(rs.getString("GoodsType"));
				stock.setPurchasePrice(rs.getString("PurchasePrice"));
				stock.setSalePrice(rs.getString("SalePrice"));
				stock.setPurchaseNum(rs.getString("PurchaseNum"));
				stock.setStock(rs.getString("Stock"));
				
				list.add(stock);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	
	public int addStock(Stock stock) {
		String sql = "INSERT INTO stock (BusinessID,GoodsID,SalePrice,PurchasePrice,PurchaseNum,Stock) "
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = dbutil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1,stock.getBusinessID());
			ps.setString(2,stock.getGoodsID());
			ps.setString(3,stock.getSalePrice());
			ps.setString(4,stock.getPurchasePrice());
			ps.setString(5,stock.getPurchaseNum());
			ps.setString(6,stock.getStock());
			result = ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	public int updateStock(Stock stock) {
		
				String sql = "update stock set SalePrice=?,PurchasePrice=?,PurchaseNum=?,Stock=? WHERE GoodsID=? and BusinessID=?;";
				PreparedStatement ps = dbutil.executePreparedStatement(sql);
				int result = 0 ;
				try {
					ps.setString(1,stock.getSalePrice());
					ps.setString(2,stock.getPurchasePrice());
					ps.setString(3,stock.getPurchaseNum());
					ps.setString(4,stock.getStock());
					ps.setString(5,stock.getGoodsID());
					ps.setString(6,stock.getBusinessID());
				
					result = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
	}

	
	public int deleteStock(Stock stock) {
		String sql="delete from stock where GoodsID = '"+stock.getGoodsID()+"' and BusinessID='"+stock.getBusinessID()+"';";
		int result = 0 ;
		result = dbutil.executeUpdate(sql);
		dbutil.close();
		return result;
	}
	
	public int findGoods(Stock stock){
		String sql="select * from goods where GoodsID='"+stock.getGoodsID()+"';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Goods> list=new ArrayList<Goods>();
		try {
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setGoodsID(rs.getString("GoodsID"));
				list.add(goods);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		int result = 0 ;
		
		if(list.size()>0)
			result=1;
		dbutil.close();
		return result;
	}
	
}