package Dao;

import java.util.List;

import database.Orders;

public interface business_ordersDao {

	//�鿴�̼��Լ������ж�����Ϣ
	public List<Orders> findAll(String ID);
	//ͨ���˿�������Ʒ������Ʒ���ࡢ�ۼ�����鿴������Ϣ
	public List<Orders> find(String ID,String customername,String goodsname,String goodstype,int min,int max);
	
}
