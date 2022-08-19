package Dao;

import java.util.List;

import database.Business;



public interface manager_bussinessDao {
		//����bussiness����������̼�
		public List<Business> findAll();
		//�����̼�ID�����̼�
		public List<Business> findBusinessID(String ID);
		//�����̼��������̼�
		public List<Business> findBusinessName(String name);
		//���ݵ绰��������̼�
		public List<Business> findBusinessPhone(String phone);
		//�����̼�
		public int addBusiness(Business business);
		//ɾ���̼�
		public int deleteBusiness(String ID);
		//�޸��̼�
		public int updateBusiness(Business business);
}
