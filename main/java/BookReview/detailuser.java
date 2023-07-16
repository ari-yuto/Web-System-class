package BookReview;

import java.sql.Date;

public class detailuser {
	/** ID */
	private int id;
	/** 本のタイトル */
	private String book_title;
	/** 著者 */
	private String author;
	/** 出版日 */
	private Date created_at;
	/** userのID */
	private int user_id;
	/** レビューのタイトル */
	private String reviews_title;
	/** 本の紹介 */
	private String comment;
	
	/** コンストラクタ */
	public detailuser(int id, String book_title, String author, Date created_at, int user_id, String reviews_title, String comment) {
		this.id = id;
		this.book_title= book_title;
		this.author= author;
		this.created_at = created_at;
		this.user_id = user_id;
		this.reviews_title = reviews_title;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}
	
	public String getBook_title() {
		return book_title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Date getCreated_at() {
		return created_at;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public String getReviews_title() {
		return reviews_title;
	}
	
	public String getComment() {
		return comment;
	}
}


