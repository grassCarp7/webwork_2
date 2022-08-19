package Dao;

import java.util.List;

import database.Customer;


public interface manager_customerDao {

			//����customer��������й˿�
			public List<Customer> findAll();
			//���ݹ˿�ID���ҹ˿�
			public List<Customer> findCustomerID(String ID);
			//���ݹ˿������ҹ˿�
			public List<Customer> findCustomerName(String name);
			//���ݵ绰������ҹ˿�
			public List<Customer> findCustomerPhone(String phone);
			//���ӹ˿�
			public int addCustomer(Customer customer);
			//ɾ���˿�
			public int deleteCustomer(String ID);
			//�޸Ĺ˿�
			public int updateCustomer(Customer customer);
}
