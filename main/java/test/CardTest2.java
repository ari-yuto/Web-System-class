package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CardTest2
 */
@WebServlet("/CardTest2")
public class CardTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				//doGet(request, response);
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");

	String suit = request.getParameter("suit");
	String number[] = request.getParameterValues("number");
	String color = request.getParameter("color");
	String query = request.getParameter("query");

	System.out.println("--------");
	List<String> numberlist = null;
	if (number == null) {
		numberlist = new ArrayList<>();
	} else {
		numberlist = Arrays.asList(number);
	}
	System.out.println(numberlist);
	System.out.println("color=" + color);
	System.out.println("query=" + query);

	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println(suit);
	out.println("<hr>");
	out.println(numberlist);
	out.println("<hr>");
	out.println(color);
	out.println("<hr>");
	out.println(query);
	
	out.println("<hr>");
	boolean suitFlag[] = new boolean[53];
	boolean numberFlag[] = new boolean[53];

	// 記号による選別
	if (suit.equals("all")) {
		for (int i=1; i<=52; i++) {
			suitFlag[i] = true;
		}
	} else if (suit.equals("spade")) {
		for (int i=1; i<=13; i++) {
			suitFlag[i] = true;
		}
	} else if (suit.equals("heart")) {
		for (int i=14; i<=26; i++) {
			suitFlag[i] = true;
		}
	} else if (suit.equals("diamond")) {
		for (int i=26; i<=39; i++) {
			suitFlag[i] = true;
		}
	} else if (suit.equals("club")) {
		for (int i=39; i<=52; i++) {
			suitFlag[i] = true;
		}
	}
	

	// 数字による選別
	if(numberlist.contains("0")) {
		for(int i=1; i<52;i++) {
			numberFlag[i]=true;
		}
		out.println(0);
	}
	else if(numberlist.contains("1")) {
		for(int i=1; i<4;i++) {
			numberFlag[1+13*(i-1)]=true;
		}
		out.println(1);
	}
	else if(numberlist.contains("2")) {
		for(int i=1; i<4;i++) {
			numberFlag[2+13*(i-1)]=true;
		}
		out.println(2);
	}
	else if(numberlist.contains("3")) {
		for(int i=1; i<4;i++) {
			numberFlag[3+13*(i-1)]=true;
		}
		out.println(3);
	}
	else if(numberlist.contains("4")) {
		for(int i=1; i<4;i++) {
			numberFlag[4+13*(i-1)]=true;
		}
		out.println(4);
	}
	else if(numberlist.contains("5")) {
		for(int i=1; i<4;i++) {
			numberFlag[5+13*(i-1)]=true;
		}
		out.println(5);
	}
	else if(numberlist.contains("6")) {
		for(int i=1; i<4;i++) {
			numberFlag[6+13*(i-1)]=true;
		}
		out.println(6);
	}
	else if(numberlist.contains("7")) {
		for(int i=1; i<4;i++) {
			numberFlag[7+13*(i-1)]=true;
		}
		out.println(7);
	}
	else if(numberlist.contains("8")) {
		for(int i=1; i<4;i++) {
			numberFlag[8+13*(i-1)]=true;
		}
		out.println(8);
	}
	else if(numberlist.contains("9")) {
		for(int i=1; i<4;i++) {
			numberFlag[9+13*(i-1)]=true;
		}
		out.println(9);
	}
	else if(numberlist.contains("10")) {
		for(int i=1; i<4;i++) {
			numberFlag[10+13*(i-1)]=true;
		}
		out.println(10);
	}
	else if(numberlist.contains("11")) {
		for(int i=1; i<4;i++) {
			numberFlag[11+13*(i-1)]=true;
		}
		out.println(11);
	}
	else if(numberlist.contains("12")) {
		for(int i=1; i<4;i++) {
			numberFlag[12+13*(i-1)]=true;
		}
		out.println(12);
	}
	else if(numberlist.contains("13")) {
		for(int i=1; i<4;i++) {
			numberFlag[i+13*(i-1)]=true;
		}
		out.println(13);
	}
	
	
	out.println("<br>");

	// 色による選別
	
	// カードの表示
	for (int i=1; i<=52; i++) {
		if (suitFlag[i]==true) {
			if (numberFlag[i]==true) {
				String filename = "cards/" + i + ".png";
				out.printf("<img src=\"%s\" width=\"100\" height=\"150\">\n", filename);
			}
		}
	}
	
	out.println("</html>");
	}
}

	
