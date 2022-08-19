package Dao;

import java.util.List;

import database.Orders;

public interface customer_ordersDao {

	//根据顾客ID查询之前的订单信息
	public List<Orders> findOrders(String ID);
	//增加自己的订单信息(结账成功才能增加)
	public int addOrders(Orders order);
}
