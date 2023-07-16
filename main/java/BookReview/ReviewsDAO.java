package BookReview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewsDAO {
	
	/** プログラム起動時に一度だけ実行される */
	static {
		try {
			Class.forName("org.h2.Driver"); // JDBC Driverの読み込み
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean ReviewInsert(int book_id, int user_id, String title, String comment) {
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "insert into reviews(book_id, user_id, title, comment) VALUES(?,?,?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, book_id);
			pre.setInt(2, user_id);
			pre.setString(3, title);
			pre.setString(4, comment);
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
	
	public List<reviews> FindReview(int Book_id) {
		List<reviews> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from reviews where book_id ="+Book_id+";";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				int book_id = rs.getInt("book_id");
				int user_id = rs.getInt("user_id");
				String title = rs.getString("title");
				String comment = rs.getString("comment");
				reviews p = new reviews(ID, book_id, user_id, title, comment);
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
