package Dao;

import java.util.List;

import database.Stock;


public interface manager_stockDao {

	
	//����stock����������̼ҵĿ����Ϣ
	public List<Stock> findAll();
	
/**************** ��������ѯ*********************/
	//�����̼�ID����ƷID���ҿ����Ϣ
	public List<Stock> findBusiness_GoodsID(String BID,String GID);
	/**************��ɾ��******************/
	//���ӿ����Ϣ
	public int addStock(Stock stock);
	//�����Ƿ��и���Ʒ
		public int findGoods(Stock stock);
	//ɾ�������Ϣ
	public int deleteStock(String BID,String GID);
	//�޸Ŀ����Ϣ
	public int updateStock(Stock stock);
	
}
