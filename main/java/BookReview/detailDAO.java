package BookReview;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class detailDAO {
	/** プログラム起動時に一度だけ実行される */
	static {
		try {
			Class.forName("org.h2.Driver"); // JDBC Driverの読み込み
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<detail> FindDetail(int Book_id) {
		List<detail> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from users left outer join reviews on users.ID = reviews.user_id where book_id = "+Book_id+";";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				int user_id = rs.getInt("user_id");
				String name = rs.getString("name");
				String biography= rs.getString("biography");
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String comment = rs.getString("comment");
				detail p = new detail(ID, user_id, name, biography, book_id, title, comment);
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
	
	public List<detailuser> FindDetailUser(int User_id) {
		List<detailuser> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from books left outer join reviews on books.ID = reviews.book_id where user_id = "+User_id+";";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String book_title = rs.getString("title");
				String author = rs.getString("author");
				Date created_at = rs.getDate("created_at");
				int user_id = rs.getInt("user_id");
				String review_title = rs.getString("title");
				String comment = rs.getString("comment");
				detailuser p = new detailuser(ID, book_title, author, created_at, user_id, review_title, comment);
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
