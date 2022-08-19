package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Login;
import Dao.Regist;
import database.Business;
import database.Customer;
import database.Manager;


public class ss {
	public static void main(String[] args) {
		Manager m=new Manager();
		Business b=new Business();
		Customer c=new Customer();
		m.setManagerID("00");
		m.setManagerName("00");
		m.setManagerPhone("00");
		m.setManagerPsw("00");
		m.setManagerAddress("00");
		
		b.setBusinessID("00");
		b.setBusinessName("00");
		b.setBusinessPhone("00");
		b.setBusinessPsw("00");
		b.setBusinessAddress("00");
		
		c.setCustomerID("00");
		c.setCustomerName("00");
		c.setCustomerPhone("00");
		c.setCustomerPsw("00");
		c.setCustomerAddress("00");
		int result=0;
		int result1=0;
		int result2=0;
		Regist r=new Regist();
		result=r.businessRegist(b);
		System.out.println(result);
		result1=r.customerRegist(c);
		System.out.println(result1);
		result2=r.managerRegist(m);
		System.out.println(result2);
	}
}
