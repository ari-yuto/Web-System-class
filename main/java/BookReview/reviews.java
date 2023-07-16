package BookReview;

public class reviews {
	/** ID */
	private int id;
	/** 本のID */
	private int book_id;
	/** userのID */
	private int user_id;
	/** タイトル */
	private String title;
	/** コメント */
	private String comment;
	
	/** コンストラクタ */
	public reviews(int id, int book_id, int user_id, String title, String comment) {
		this.id = id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.title = title;
		this.comment = comment;
	}
	
	public int getId() {
		return id;
	}
	
	public int getBook_id() {
		return book_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getComment() {
		return comment;
	}
}
