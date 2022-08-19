package Dao;

import java.util.List;

import database.Business;



public interface manager_bussinessDao {
		//查找bussiness表里的所有商家
		public List<Business> findAll();
		//根据商家ID查找商家
		public List<Business> findBusinessID(String ID);
		//根据商家名查找商家
		public List<Business> findBusinessName(String name);
		//根据电话号码查找商家
		public List<Business> findBusinessPhone(String phone);
		//增加商家
		public int addBusiness(Business business);
		//删除商家
		public int deleteBusiness(String ID);
		//修改商家
		public int updateBusiness(Business business);
}
