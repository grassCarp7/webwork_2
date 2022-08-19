package Dao;

import java.util.List;

import database.Orders;



public interface manager_orderDao {
	
		//查找Orders表里的所有订单信息
		public List<Orders> findAll();
		//根据商家ID、商品ID、用户ID查找订单信息
		public List<Orders> findCustomer_Goods_BusinessID(String CID,String GID,String BID);
		/**************增删改******************/
		//增加订单信息
		public int addOrders(Orders order);
		//删除订单信息
		public int deleteOrders(Orders order);
		//修改订单信息
		public int updateOrders(Orders order);
}
