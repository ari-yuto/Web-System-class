package BookReview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewLoginservlet")
public class NewLoginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public NewLoginservlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/NewLogin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("newname");
		String passwd = request.getParameter("newpasswd");
		String biography = request.getParameter("newbiography");
		System.out.printf("\n%s:%s:%s:\n", name, passwd, biography);
		insert(name, passwd, biography);
		doGet(request, response);
	}

	void insert(String name, String passwd, String biography) {
		try {
			userDAO UserDAO = new userDAO();
			boolean result = UserDAO.insert(name, passwd, biography);
		}catch (NumberFormatException e) {
			System.out.println("不正な値が入力されました"+e.getMessage());
		}
	}

}
