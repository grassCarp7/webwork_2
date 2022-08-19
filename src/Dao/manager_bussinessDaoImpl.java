package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Business;


public class manager_bussinessDaoImpl implements manager_bussinessDao{

	
	public List<Business> findAll() {
		String sql="select * from business;";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Business> list=new ArrayList<Business>();
		try {
			while(rs.next()) {
				Business business=new Business();
				business.setBusinessID(rs.getString("BusinessID"));
				business.setBusinessName(rs.getString("BusinessName"));
				business.setBusinessPhone(rs.getString("BusinessPhone"));
				business.setBusinessPsw(rs.getString("BusinessPsw"));
				business.setBusinessAddress(rs.getString("BusinessAddress"));
				list.add(business);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	
	public List<Business> findBusinessID(String ID) {
		String sql="select * from business where BusinessID like '%"+ID+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Business> list=new ArrayList<Business>();
		try {
			while(rs.next()) {
				Business business=new Business();
				business.setBusinessID(rs.getString("BusinessID"));
				business.setBusinessName(rs.getString("BusinessName"));
				business.setBusinessPhone(rs.getString("BusinessPhone"));
				business.setBusinessPsw(rs.getString("BusinessPsw"));
				business.setBusinessAddress("BusinessAddress");
				list.add(business);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	
	public List<Business> findBusinessName(String name) {
		String sql="select * from business where BusinessName like '%"+name+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Business> list=new ArrayList<Business>();
		try {
			while(rs.next()) {
				Business business=new Business();
				business.setBusinessID(rs.getString("BusinessID"));
				business.setBusinessName(rs.getString("BusinessName"));
				business.setBusinessPhone(rs.getString("BusinessPhone"));
				business.setBusinessPsw(rs.getString("BusinessPsw"));
				business.setBusinessAddress("BusinessAddress");
				list.add(business);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	
	public List<Business> findBusinessPhone(String phone) {
		String sql="select * from business where BusinessPhone like '%"+phone+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Business> list=new ArrayList<Business>();
		try {
			while(rs.next()) {
				Business business=new Business();
				business.setBusinessID(rs.getString("BusinessID"));
				business.setBusinessName(rs.getString("BusinessName"));
				business.setBusinessPhone(rs.getString("BusinessPhone"));
				business.setBusinessPsw(rs.getString("BusinessPsw"));
				business.setBusinessAddress("BusinessAddress");
				list.add(business);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	
	public int addBusiness(Business business) {
		
		int result = 0 ;
		
		String sql1="select * from business where BusinessPhone='"+business.getBusinessPhone()+"';";
		ResultSet rs1;
		rs1=dbutil.executeQuery(sql1);
		List<Business> list1=new ArrayList<Business>();
		try {
			while(rs1.next()) {
				Business business1=new Business();
				business1.setBusinessID(rs1.getString("BusinessID"));
				business1.setBusinessName(rs1.getString("BusinessName"));
				business1.setBusinessPhone(rs1.getString("BusinessPhone"));
				business1.setBusinessPsw(rs1.getString("BusinessPsw"));
				business1.setBusinessAddress("BusinessAddress");
				list1.add(business1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(list1.size()==0) {
			String sql = "INSERT INTO business (BusinessID,BusinessName,BusinessPhone,BusinessPsw,BusinessAddress) "
				+ "VALUES (?,?,?,?,?)";
			PreparedStatement ps = dbutil.executePreparedStatement(sql);
			try {
				ps.setString(1,business.getBusinessID());
				ps.setString(2,business.getBusinessName());
				ps.setString(3,business.getBusinessPhone());
				ps.setString(4,business.getBusinessPsw());
				ps.setString(5,business.getBusinessAddress());
				result = ps.executeUpdate();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(list1.size()>0)
			result=3;
		return result;
	}
	
	public int deleteBusiness(String ID) {
		String sql="delete from business where BusinessID = '"+ID+"';";
		int result = 0 ;
		result = dbutil.executeUpdate(sql);
		String sql1="delete from stock where  BusinessID = '"+ID+"';";
		result = dbutil.executeUpdate(sql1)+result;
		dbutil.close();
		return result;
	}

	
	public int updateBusiness(Business business) {
		
		/**婵″倹鐏夋穱顔芥暭婢惰精瑙﹂敍瀹篹sult=0閿涘苯顩ч弸婊呮暩鐠囨繂褰块惍浣稿嚒缂佸繐鐡ㄩ崷顭掔礉result=3閿涘奔鎱ㄩ弨瑙勫灇閸旂喎鍨痳esult=1*/
		
		int result = 0 ;
		
		String sql1="select * from business where BusinessPhone='"+business.getBusinessPhone()+"' and BusinessID !='"+business.getBusinessID()+"';";
		ResultSet rs1;
		rs1=dbutil.executeQuery(sql1);
		List<Business> list1=new ArrayList<Business>();
		try {
			while(rs1.next()) {
				Business business1=new Business();
				business1.setBusinessID(rs1.getString("BusinessID"));
				business1.setBusinessName(rs1.getString("BusinessName"));
				business1.setBusinessPhone(rs1.getString("BusinessPhone"));
				business1.setBusinessPsw(rs1.getString("BusinessPsw"));
				business1.setBusinessAddress("BusinessAddress");
				list1.add(business1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(list1.size()==0) {
			String sql = "update business set BusinessPhone=?,BusinessPsw=?,BusinessAddress=? WHERE BusinessID=? and BusinessName=?;";
			PreparedStatement ps = dbutil.executePreparedStatement(sql);
			try {
				ps.setString(1,business.getBusinessPhone());
				ps.setString(2,business.getBusinessPsw());
				ps.setString(3,business.getBusinessAddress());
				ps.setString(4,business.getBusinessID());
				ps.setString(5,business.getBusinessName());
			
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(list1.size()>0)
			result=3;
	return result;	
	}	
}
