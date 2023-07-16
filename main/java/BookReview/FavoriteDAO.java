package BookReview;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDAO {
	/** プログラム起動時に一度だけ実行される */
	static {
		try {
			Class.forName("org.h2.Driver"); // JDBC Driverの読み込み
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean FavoriteInsert(int book_id, int user_id) {
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "insert into favorites(book_id, user_id) VALUES(?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, book_id);
			pre.setInt(2, user_id);
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
	
	public boolean FavoriteDelete(int book_id, int user_id) {
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "delete from favorites where book_id = (?) and user_id = (?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, book_id);
			pre.setInt(2, user_id);
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
	
	public boolean FindFavorite(int book_id, int user_id) {
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from favorites where book_id = (?) and user_id = (?);";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, book_id);
			pre.setInt(2, user_id);
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
	
	public List<favoritesbooks> FindFavoritebooks(int User_id) {
		List<favoritesbooks> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/./s2132008";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from favorites LEFT OUTER JOIN books ON favorites.book_id = books.id where user_id ="+User_id+";";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				int book_id = rs.getInt("book_id");
				int user_id = rs.getInt("user_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				Date created_at = rs.getDate("created_at");
				favoritesbooks p = new favoritesbooks(ID, book_id, user_id, title, author, created_at);
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
