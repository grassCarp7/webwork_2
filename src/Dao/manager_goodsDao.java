package Dao;

import java.util.List;

import database.Goods;

public interface manager_goodsDao {
	//查找Goods表里的所有商品
	public List<Goods> findAll();
	//根据商品ID查找商品
	public List<Goods> findGoodsID(String ID);
	//根据种类、商品名查找商品（多查询）
	public List<Goods> findGoodsName_type(String goodsname,String goodstype);
	//增加商品
	public int addGoods(Goods good);
	//删除商品
	public int deleteGoods(String ID);
	//修改商品
	public int updateGoods(Goods good);
}
