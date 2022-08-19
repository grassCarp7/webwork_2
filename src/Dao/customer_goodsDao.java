package Dao;

import java.util.List;

import database.Stock;

public interface customer_goodsDao {
	//查找所有商品
	public List<Stock> findAll();
	//根据商品种类查询
	public List<Stock> findGoodsType(String type);
	//根据商品名、价格区域
	public List<Stock> findGoods(String name,double min,double max);
}
