package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbutil;
import database.Goods;


public class manager_goodsDaoImpl implements manager_goodsDao{

	//
	public List<Goods> findAll() {
		String sql="select * from goods;";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Goods> list=new ArrayList<Goods>();
		try {
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setGoodsID(rs.getString("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsType(rs.getString("GoodsType"));
				goods.setImage(rs.getString("Image"));
				goods.setIntroduction(rs.getString("Introduction"));
				list.add(goods);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}
	
	public List<Goods> findGoodsID(String ID){
		String sql="select * from goods where GoodsID='"+ID+"';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Goods> list=new ArrayList<Goods>();
		try {
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setGoodsID(ID);
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsType(rs.getString("GoodsType"));
				goods.setImage(rs.getString("Image"));
				goods.setIntroduction(rs.getString("Introduction"));
				list.add(goods);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return null;
	}

	//
	public List<Goods> findGoodsName_type(String goodsname, String goodstype) {
		String sql="select * from goods where GoodsType like'%"+goodstype+"%' and GoodsName like'%"+goodsname+"%';";
		ResultSet rs;
		rs=dbutil.executeQuery(sql);
		List<Goods> list=new ArrayList<Goods>();
		try {
			while(rs.next()) {
				Goods goods=new Goods();
				goods.setGoodsID(rs.getString("GoodsID"));
				goods.setGoodsName(rs.getString("GoodsName"));
				goods.setGoodsType(rs.getString("GoodsType"));
				goods.setImage(rs.getString("Image"));
				goods.setIntroduction(rs.getString("Introduction"));
				list.add(goods);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbutil.close();
		return list;
	}

	//
	public int addGoods(Goods good) {
		String sql = "INSERT INTO goods (GoodsID,GoodsName,GoodsType,Image,Introduction) "
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement ps = dbutil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1,good.getGoodsID());
			ps.setString(2,good.getGoodsName());
			ps.setString(3,good.getGoodsType());
			ps.setString(4,good.getImage());
			ps.setString(5,good.getIntroduction());
			result = ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	//
	public int deleteGoods(String ID) {
		String sql="delete from goods where GoodsID = '"+ID+"';";
		int result = 0 ;
		result = dbutil.executeUpdate(sql);
		dbutil.close();
		return result;
	}

	//
	public int updateGoods(Goods good) {
		String sql = "update goods set GoodsName=?,GoodsType=?,Image=?,Introduction=? WHERE GoodsID=?;";
		PreparedStatement ps = dbutil.executePreparedStatement(sql);
		
		int result = 0 ;
		try {
			ps.setString(1,good.getGoodsName());
			ps.setString(2,good.getGoodsType());
			ps.setString(3,good.getImage());
			ps.setString(4,good.getIntroduction());
			ps.setString(5,good.getGoodsID());
		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
