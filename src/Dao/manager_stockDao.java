package Dao;

import java.util.List;

import database.Stock;


public interface manager_stockDao {

	
	//查找stock表里的所有商家的库存信息
	public List<Stock> findAll();
	
/**************** 多条件查询*********************/
	//根据商家ID、商品ID查找库存信息
	public List<Stock> findBusiness_GoodsID(String BID,String GID);
	/**************增删改******************/
	//增加库存信息
	public int addStock(Stock stock);
	//查找是否有该商品
		public int findGoods(Stock stock);
	//删除库存信息
	public int deleteStock(String BID,String GID);
	//修改库存信息
	public int updateStock(Stock stock);
	
}
