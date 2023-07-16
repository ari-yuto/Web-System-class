package BookReview;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookListServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("ID");
		HttpSession session = request.getSession();
		bookslist(request, response);
		if( ID != null) {
			int id = Integer.parseInt(ID);
			session.setAttribute("book_id", id);
			bookDisplay(request, response, id);
			findReview(request, response, id);
			DetailList(request, response, id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BookDetailServlet");
			dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BookList.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String submit = request.getParameter("submit");
		String favorite = request.getParameter("favorite");
		if(submit != null) {
			if(submit.equals("ログイン画面に戻る")){
				session.removeAttribute("user_id");
				session.removeAttribute("name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}
		if(favorite != null) {
			if(favorite.equals("登録")) {
				int book_id = (int)session.getAttribute("book_id");
				int user_id = (int)session.getAttribute("user_id");
				if(findFavorite(request, response, book_id, user_id) == false) {
					registerFavorite(request, response, book_id, user_id);
				}
			}
			else if(favorite.equals("解除")) {
				int book_id = (int)session.getAttribute("book_id");
				int user_id = (int)session.getAttribute("user_id");
				if(findFavorite(request, response, book_id, user_id) == false) {
					deleteFavorite(request, response, book_id, user_id);
				}
			}
		}
	
		doGet(request, response);
	}

	void bookslist(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		List<books> list = BookDAO.BookList();
		request.setAttribute("listbook", list);
	}

	void bookDisplay(HttpServletRequest request, HttpServletResponse response, int ID) throws
	ServletException, IOException {
		List<books> list = BookDAO.BookDisplay(ID);
		request.setAttribute("listbook", list);
	}

	void findReview(HttpServletRequest request, HttpServletResponse response, int book_id) throws
	ServletException, IOException {
		ReviewsDAO reviewsDAO = new ReviewsDAO();
		List<reviews> list = reviewsDAO.FindReview(book_id);
		request.setAttribute("listreview", list);
	}

	void registerFavorite(HttpServletRequest request, HttpServletResponse response, int book_id, int user_id) throws
	ServletException, IOException {
		try {
			FavoriteDAO favoriteDAO = new FavoriteDAO();
			boolean resalt = favoriteDAO.FavoriteInsert(book_id, user_id);
			System.out.println(resalt);
		} catch (NumberFormatException e) {
			System.out.println("不正な値が入力されました"+e.getMessage());
		}
	}
	
	void deleteFavorite(HttpServletRequest request, HttpServletResponse response, int book_id, int user_id) throws
	ServletException, IOException {
		try {
			FavoriteDAO favoriteDAO = new FavoriteDAO();
			boolean resalt = favoriteDAO.FavoriteDelete(book_id, user_id);
			System.out.println(resalt);
		} catch (NumberFormatException e) {
			System.out.println("不正な値が入力されました"+e.getMessage());
		}
	}
	
	public boolean findFavorite(HttpServletRequest request, HttpServletResponse response, int book_id, int user_id) throws
	ServletException, IOException {
		FavoriteDAO favoriteDAO = new FavoriteDAO();
		boolean result = favoriteDAO.FindFavorite(book_id, user_id);
		System.out.println(result+"1");
		return result;
	}
	
	void DetailList(HttpServletRequest request, HttpServletResponse response, int book_id) throws 
	ServletException, IOException {
		detailDAO DetailDAO = new detailDAO();
		List<detail> list = DetailDAO.FindDetail(book_id);
		request.setAttribute("listdetail", list);
	}
	
}
