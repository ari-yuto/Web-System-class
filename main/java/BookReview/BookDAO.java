package BookReview;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	/** プログラム起動時に一度だけ実行される */
	static {
		try {
			Class.forName("org.h2.Driver"); // JDBC Driverの読み込み
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  List<books> BookList() {
		List<books> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from  books;";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date created_at = rs.getDate("created_at");
				books p = new books(ID,title, author, created_at);
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

	public static List<books> BookDisplay(int id) {
		List<books> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from  books where ID ="+id+";";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date created_at = rs.getDate("created_at");
				books p = new books(ID,title, author, created_at);
				list.add(p);
			}
			//System.out.println(list);
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
