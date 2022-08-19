package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Goods;
import database.Stock;

public class manager_stockDaoImpl implements manager_stockDao{


	//
	public List<Stock> findAll() {
		String sql="select stock.BusinessID,business.BusinessName,stock.GoodsID,goods.GoodsName,goods.GoodsType," + 
				"stock.SalePrice,stock.PurchasePrice,stock.PurchaseNum,stock.Stock " + 
				"from stock,business,goods where stock.BusinessID=business.BusinessID and stock.GoodsID=goods.GoodsID;";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Stock> list=new ArrayList<Stock>();
		try {
			while(rs.next()) {
				Stock stock=new Stock();
				stock.setBusinessID(rs.getString("BusinessID"));
				stock.setBusinessName(rs.getString("BusinessName"));
				stock.setGoodsID(rs.getString("GoodsID"));
				stock.setGoodsName(rs.getString("GoodsName"));
				stock.setGoodsType(rs.getString("GoodsType"));
				stock.setPurchaseNum(rs.getString("PurchaseNum"));
				stock.setPurchasePrice(rs.getString("PurchasePrice"));
				stock.setSalePrice(rs.getString("SalePrice"));
				stock.setStock(rs.getString("Stock"));
				list.add(stock);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}


	/**************** 澶氭潯浠舵煡璇�*********************/
	//
	public List<Stock> findBusiness_GoodsID(String BID, String GID) {
		String sql="select stock.BusinessID,business.BusinessName,stock.GoodsID,goods.GoodsName,goods.GoodsType," + 
				"stock.SalePrice,stock.PurchasePrice,stock.PurchaseNum,stock.Stock " + 
				"from stock,business,goods where stock.BusinessID=business.BusinessID and stock.GoodsID=goods.GoodsID "+
				"and stock.GoodsID like'%"+GID+"%' and stock.BusinessID like '%"+BID+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Stock> list=new ArrayList<Stock>();
		try {
			while(rs.next()) {
				Stock stock=new Stock();
				stock.setBusinessID(rs.getString("BusinessID"));
				stock.setBusinessName(rs.getString("BusinessName"));
				stock.setGoodsID(rs.getString("GoodsID"));
				stock.setGoodsName(rs.getString("GoodsName"));
				stock.setGoodsType(rs.getString("GoodsType"));
				stock.setPurchaseNum(rs.getString("PurchaseNum"));
				stock.setPurchasePrice(rs.getString("PurchasePrice"));
				stock.setSalePrice(rs.getString("SalePrice"));
				stock.setStock(rs.getString("Stock"));
				list.add(stock);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	/**************澧炲垹鏀�******************/
	//澧炲姞搴撳瓨淇℃伅
	public int addStock(Stock stock) {
		//BusinessID,GoodsID,SalePrice,PurchasePrice,PurchaseNum,Stock
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

	//
	public int deleteStock(String BID, String GID) {
		String sql="delete from stock where GoodsID = '"+GID+"' and BusinessID='"+BID+"';";
		int result = 0 ;
		result = dbutil.executeUpdate(sql);
		dbutil.close();
		return result;
	}

	//
	public int updateStock(Stock stock) {
		//BusinessID,GoodsID
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
	//
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
			//
			if(list.size()>0)
				result=1;
			dbutil.close();
			return result;
		}
}
