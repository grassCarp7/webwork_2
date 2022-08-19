package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;

import database.Stock;

public class customer_goodsDaoImpl implements customer_goodsDao{

	
		public List<Stock> findAll(){
			String sql="select stock.BusinessID,business.BusinessName,stock.GoodsID,goods.GoodsName,goods.GoodsType," + 
					"stock.SalePrice,stock.Stock,goods.Image,goods.Introduction " + 
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
					stock.setIntroduction(rs.getString("Introduction"));
					stock.setImage(rs.getString("Image"));
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
		
		
		public List<Stock> findGoodsType(String type){
			String sql="select stock.BusinessID,business.BusinessName,stock.GoodsID,goods.GoodsName,goods.GoodsType," + 
					"stock.SalePrice,stock.Stock,goods.Image,goods.Introduction " + 
					"from stock,business,goods where stock.BusinessID=business.BusinessID and stock.GoodsID=goods.GoodsID and goods.GoodsType like '%"+type+"%';";
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
					stock.setIntroduction(rs.getString("Introduction"));
					stock.setImage(rs.getString("Image"));
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

		
		public List<Stock> findGoods(String name, double min, double max) {
			String sql="select stock.BusinessID,business.BusinessName,stock.GoodsID," + 
					"goods.GoodsName,goods.GoodsType,stock.SalePrice,stock.Stock,goods.Image,goods.Introduction " + 
					"from stock,business,goods where stock.BusinessID=business.BusinessID and stock.GoodsID=goods.GoodsID " + 
					"and goods.GoodsName like '%"+name+"%' and (Stock.SalePrice between "+min+" and "+max+");";
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
					stock.setIntroduction(rs.getString("Introduction"));
					stock.setImage(rs.getString("Image"));
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
}
