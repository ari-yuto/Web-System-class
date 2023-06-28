package BookReview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewRoginservlet")
public class NewRoginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public NewRoginservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("newname");
		String passwd = request.getParameter("newpasswd");
		String biography = request.getParameter("newbiography");
		String submit = request.getParameter("submit"); 
		System.out.printf("\n%s:%s:%s:%s:\n", name, passwd, biography, submit);
		if (submit != null) {
			if(submit.equals("登録")) {
				insert(name, passwd, biography);
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/NewRogin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		doGet(request, response);
	}
	
	void insert(String name, String passwd, String biography) {
		try {
			userDAO UserDAO = new userDAO();
			boolean result = UserDAO.insert(name, passwd, biography);
			System.out.println(result);
		}catch (NumberFormatException e) {
			System.out.println("不正な値が入力されました"+e.getMessage());
		}
	}

}
