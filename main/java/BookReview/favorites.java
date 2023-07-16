package BookReview;

public class favorites {
	/** ID */
	private int id;
	/** 本のID */
	private int book_id;
	/** userのID */
	private int user_id;
	
	/** コンストラクタ */
	public favorites(int id, int book_id, int user_id) {
		this.id = id;
		this.book_id = book_id;
		this.user_id = user_id;
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

}
