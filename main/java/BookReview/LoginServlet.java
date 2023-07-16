package BookReview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		System.out.printf("\n%s:%s:\n", name, passwd);
		users Result = findUser(request, response, name, passwd);
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("user_id", Result.getId());
		if(Result != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BookListServlet");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}

	public users findUser(HttpServletRequest request, HttpServletResponse response, String name, String passwd){
		userDAO finduser = new userDAO();
		users User = finduser.findUser(name, passwd);
		return User;
	}
}
