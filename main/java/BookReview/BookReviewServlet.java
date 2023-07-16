package BookReview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookReviewServlet")
public class BookReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookReviewServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookReview.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("ID");
		String title = request.getParameter("newtitle");
		String comment = request.getParameter("newreview");
		HttpSession session = request.getSession();
		int book_id = (int)session.getAttribute("book_id");
		int user_id = (int)session.getAttribute("user_id");
		System.out.printf("\n%s:%s:%s:%s:%s:\n", ID, book_id, user_id, title, comment);
		bookReview(request, response, book_id, user_id, title, comment);
		doGet(request, response);
	}
	
	void bookReview(HttpServletRequest request, HttpServletResponse response, int book_id, int user_id, String title, String comment) {
		try{
			ReviewsDAO reviews = new ReviewsDAO();
			boolean result = reviews.ReviewInsert(book_id, user_id, title, comment);
			System.out.println(result);
		}catch (NumberFormatException e) {
			System.out.println("不正な値が入力されました"+e.getMessage());
		}
	}
	
}
