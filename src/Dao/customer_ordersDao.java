package Dao;

import java.util.List;

import database.Orders;

public interface customer_ordersDao {

	//���ݹ˿�ID��ѯ֮ǰ�Ķ�����Ϣ
	public List<Orders> findOrders(String ID);
	//�����Լ��Ķ�����Ϣ(���˳ɹ���������)
	public int addOrders(Orders order);
}
