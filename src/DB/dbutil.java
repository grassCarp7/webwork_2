package DB;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

import org.omg.CORBA.portable.InputStream;

public class dbutil {
	private static String driver;	//鏁版嵁搴撻┍鍔�
	private static String url;	//鏁版嵁搴搖rl
	private static String username;	//鏁版嵁搴撶櫥褰曠敤鎴峰悕
	private static String password;	//鏁版嵁搴撶櫥褰曞瘑鐮�
	protected  static Connection conn;
	protected  static Statement s;
	protected  static ResultSet rs;
	static {
		//properties鏂囦欢
		Properties prop = new Properties();
		Reader in;
		//鍔犺浇config.properties鏂囦欢
		try {
			
			in = new FileReader("D:/Java/webwork/src/config.properties");
			prop.load(in);
		} catch (Exception e) {
			// TODO 鑷姩鐢熸垚鐨� catch 鍧�
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");	//鑾峰彇鏁版嵁搴撻┍鍔�
		System.out.println(driver+"-------->");
		url = prop.getProperty("url");	//鑾峰彇鏁版嵁搴搖rl
		username = prop.getProperty("username");	//鑾峰彇鏁版嵁搴撶櫥褰曠敤鎴峰悕
		password = prop.getProperty("password");	//鑾峰彇鏁版嵁搴撶櫥褰曞瘑鐮�
		System.out.println(username+"-------->");
		System.out.println(password+"-------->");
	}
	
	//涓庢暟鎹簱寤虹珛杩炴帴
	public static Connection getConnection()
	{
	
		try {
			//鍔犺浇椹卞姩
			Class.forName(driver);
			//涓庢暟鎹簱寤虹珛杩炴帴
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("杩炴帴鎴愬姛锛侊紒");
			
		} catch (Exception e) {
			System.out.println("杩炴帴澶辫触!!");
			// TODO 鑷姩鐢熸垚鐨� catch 鍧�
			e.printStackTrace();
		}
		return conn;
		
	}
	
	/**
	 * 鎵цSELECT SQL璇彞
	 * @param sql SQL璇彞锛屽瓧绗︿覆绫诲瀷
	 * @return ResultSet缁撴灉闆�
	 */
	public static ResultSet executeQuery(String sql)
	{
		try {
			s=getConnection().createStatement();
			rs=s.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 鎵цINSERT/UPDATE/DELETE SQL璇彞
	 * @param sql SQL璇彞锛屽瓧绗︿覆绫诲瀷
	 * @return 鎵ц缁撴灉锛宨nt绫诲瀷
	 */
	public static int executeUpdate(String sql)
	{
		int result = 0;
		try {
			s = getConnection().createStatement();
			result = s.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 鎵ц鍔ㄦ�丼QL璇彞
	 * @param sql 鍚湁鍙傛暟鐨勫姩鎬丼QL璇彞銆� 
	 * @return 杩斿洖PreparedStatement瀵硅薄
	 */
	public static PreparedStatement executePreparedStatement(String sql)
	{
		PreparedStatement ps = null;
		System.out.println("鏁版嵁搴�---->");
		
		try
		{
			ps = getConnection().prepareStatement(sql);
			System.out.println("鏁版嵁搴�2---->");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ps;
	}
	/**
	 * 浜嬪姟鍥炴粴
	 */
	public static void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//鍏抽棴鏁版嵁搴�
		public static void close()
		{
			try {
				if(rs!=null)
					rs.close();
				if(s!=null)
					s.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
					// TODO 鑷姩鐢熸垚鐨� catch 鍧�
					e.printStackTrace();
				}
			}
}
