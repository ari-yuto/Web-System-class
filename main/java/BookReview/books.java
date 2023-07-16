package BookReview;

import java.sql.Date;

public class books {
	/** ID */
	private int id;
	/** タイトル */
	private String title;
	/** 著者 */
	private String author;
	/** 出版日 */
	private Date created_at;
	
	/** コンストラクタ */
	public books(int id, String title, String author, Date created_at) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.created_at = created_at;
	}
	
	public int getId() {
		return id;
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
