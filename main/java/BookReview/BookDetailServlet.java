package BookReview;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public BookDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String name = request.getParameter("name");
		request.setAttribute("Name", name);
		if( name != null) {
			int User_id = Integer.parseInt(user_id);
			DetailList(request, response, User_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDetail.jsp");
			dispatcher.forward(request, response);
		}
			
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BookDetail.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		doGet(request, response);
	}

		void DetailList(HttpServletRequest request, HttpServletResponse response, int User_id) throws 
		ServletException, IOException {
			detailDAO DetailDAO = new detailDAO();
			List<detailuser> list = DetailDAO.FindDetailUser(User_id);
			request.setAttribute("listdetailuser", list);
		}

}
