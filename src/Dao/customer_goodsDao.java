package Dao;

import java.util.List;

import database.Stock;

public interface customer_goodsDao {
	//����������Ʒ
	public List<Stock> findAll();
	//������Ʒ�����ѯ
	public List<Stock> findGoodsType(String type);
	//������Ʒ�����۸�����
	public List<Stock> findGoods(String name,double min,double max);
}
