package Dao;

import java.util.List;

import database.Orders;



public interface manager_orderDao {
	
		//����Orders��������ж�����Ϣ
		public List<Orders> findAll();
		//�����̼�ID����ƷID���û�ID���Ҷ�����Ϣ
		public List<Orders> findCustomer_Goods_BusinessID(String CID,String GID,String BID);
		/**************��ɾ��******************/
		//���Ӷ�����Ϣ
		public int addOrders(Orders order);
		//ɾ��������Ϣ
		public int deleteOrders(Orders order);
		//�޸Ķ�����Ϣ
		public int updateOrders(Orders order);
}
