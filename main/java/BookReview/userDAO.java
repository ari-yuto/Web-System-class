package BookReview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDAO {
	/** プログラム起動時に一度だけ実行される */
	static {
		try {
			Class.forName("org.h2.Driver"); // JDBC Driverの読み込み
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** 1件のデータを追加する．成功ならtrueを返す． */
	public boolean insert(String name, String passwd, String biography) {
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "INSERT INTO users( name, passwd, biography ) VALUES(?,?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,name);
			pre.setString(2, passwd);
			pre.setString(3, biography);
			int result = pre.executeUpdate();
			if (result == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public users findUser(String Name, String Passwd) {
		users result = null;
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from users where name='" +Name+"'and passwd='"+Passwd+"';";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String name = rs.getString("name");
				String passwd = rs.getString("passwd");
				String biography = rs.getString("biography");
				result = new users(ID, name, passwd, biography);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public List<users> searchUser(int user_id){
		List<users> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from users where ID = "+user_id+";";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String name = rs.getString("name");
				String passwd = rs.getString("passwd");
				String biography = rs.getString("biography");
				users p = new users(ID,name, passwd, biography);
				list.add(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return list;
	}

}
