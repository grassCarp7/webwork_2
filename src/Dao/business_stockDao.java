package Dao;

import java.util.List;

import database.Stock;

public interface business_stockDao {

	//查看商家自己的所有库存
		public List<Stock> findAll(String ID);
		//通过商品种类、商品名、库存数量区域查看库存
		public List<Stock> find(String ID,String goodstype,String goodsname,int min,int max);
		//增加自己的售卖的商品种类
		public int addStock(Stock stock);
		//查找是否有该商品
		public int findGoods(Stock stock);
		//修改自己的库存
		public int updateStock(Stock stock);
		//减少自己售卖售卖商品种类
		public int deleteStock(Stock stock);
}
