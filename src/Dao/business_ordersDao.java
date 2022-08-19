package Dao;

import java.util.List;

import database.Orders;

public interface business_ordersDao {

	//查看商家自己的所有订单信息
	public List<Orders> findAll(String ID);
	//通过顾客名、商品名、商品种类、售价区域查看订单信息
	public List<Orders> find(String ID,String customername,String goodsname,String goodstype,int min,int max);
	
}
