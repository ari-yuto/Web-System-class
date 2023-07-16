package BookReview;

import java.sql.Date;

public class favoritesbooks {
	/** ID */
	private int id;
	/** 本のID */
	private int book_id;
	/** userのID */
	private int user_id;
	/** タイトル */
	private String title;
	/** 著者 */
	private String author;
	/** 出版日 */
	private Date created_at;
	
	/** コンストラクタ */
	public favoritesbooks(int id, int book_id, int user_id, String title, String author, Date created_at) {
		this.id = id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.title = title;
		this.author = author;
		this.created_at = created_at;
	}
	
	public int getId() {
		return id;
	}
	
	public int getBook_id() {
		return book_id;
	}
	
	public int getUook_id() {
		return user_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

}
