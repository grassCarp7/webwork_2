package Dao;

import java.util.List;

import database.Stock;

public interface business_stockDao {

	//�鿴�̼��Լ������п��
		public List<Stock> findAll(String ID);
		//ͨ����Ʒ���ࡢ��Ʒ���������������鿴���
		public List<Stock> find(String ID,String goodstype,String goodsname,int min,int max);
		//�����Լ�����������Ʒ����
		public int addStock(Stock stock);
		//�����Ƿ��и���Ʒ
		public int findGoods(Stock stock);
		//�޸��Լ��Ŀ��
		public int updateStock(Stock stock);
		//�����Լ�����������Ʒ����
		public int deleteStock(Stock stock);
}
