package Dao;

import java.util.List;

import database.Customer;


public interface manager_customerDao {

			//查找customer表里的所有顾客
			public List<Customer> findAll();
			//根据顾客ID查找顾客
			public List<Customer> findCustomerID(String ID);
			//根据顾客名查找顾客
			public List<Customer> findCustomerName(String name);
			//根据电话号码查找顾客
			public List<Customer> findCustomerPhone(String phone);
			//增加顾客
			public int addCustomer(Customer customer);
			//删除顾客
			public int deleteCustomer(String ID);
			//修改顾客
			public int updateCustomer(Customer customer);
}
