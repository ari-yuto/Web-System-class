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

/**
 * Servlet implementation class FavoriteListServlet
 */
@WebServlet("/FavoriteListServlet")
public class FavoriteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FavoriteListServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		HttpSession session = request.getSession();
		int user_id = (int)session.getAttribute("user_id");
		favoritelist(request, response, user_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FavoriteList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		doGet(request, response);
	}
	
	void favoritelist(HttpServletRequest request, HttpServletResponse response, int user_id) throws 
	ServletException, IOException {
		FavoriteDAO favoriteDAO = new FavoriteDAO();
		List<favoritesbooks> list = favoriteDAO.FindFavoritebooks(user_id);
		request.setAttribute("listfavorite", list);
	}

}
