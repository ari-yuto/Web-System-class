package BookReview;

public class users {
	/** ID */
	private int id;
	/** 名前 */
	private String name;
	/** パスワード */
	private String passwd;
	/** 自己紹介 */
	private String biography;
	
	/** コンストラクタ */
	public users(int id, String name, String passwd, String biography) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.biography = biography;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public String getBiography() {
		return biography;
	}
}
