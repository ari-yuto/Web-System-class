package BookReview;

import java.util.List;

public class BookReviewMain {
	void insert (String name, String passwd, String biography) {
		userDAO userDAO = new userDAO();
		boolean success = userDAO.insert(name, passwd,biography);
		//System.out.println(success);
	}
	
	void all() {
		userDAO userDAO = new userDAO();
		List<users> list = userDAO.findAll();
		System.out.println("---user table---");
		for (users p: list) {
			int id = p.getId();
			String name = p.getName();
			String passwd = p.getPasswd();
			String biography = p.getBiography();
			System.out.printf("%3d %-10s %-10s %-10s",
					id, name, passwd, biography);
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		BookReviewMain main = new BookReviewMain();
		main.all();
		//main.insert("user1", "1", "I am user1");
		//System.out.println(main);
	}
	
	
}
