package BookReview;

public class detail {
	/** ID */
	private int id;
	/** userのID */
	private int user_id;
	/** 名前 */
	private String name;
	/** 自己紹介 */
	private String biography;
	/** 本のID */
	private int book_id;
	/** 自己紹介 */
	private String title;
	/** 自己紹介 */
	private String comment;
	
	/** コンストラクタ */
	public detail(int id, int user_id, String name, String biography, int book_id, String title, String comment) {
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.biography = biography;
		this.book_id = book_id;
		this.title = title;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBiography() {
		return biography;
	}
	
	public int getBook_id() {
		return book_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getComment() {
		return comment;
	}
}


