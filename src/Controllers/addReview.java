package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.ItemDOM;

/**
 * Servlet implementation class addReview
 */
@WebServlet("/View/addReview")
public class addReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemDOM df = new ItemDOM();
		HttpSession session = request.getSession(false);
		int personId = 10;
		//int personId = (int) session.getAttribute("id");

		String reviewBody = request.getParameter("comment");
		int productId = Integer.parseInt(request.getParameter("id"));

		
		
		df.addReview(productId, personId, reviewBody, response);
		response.sendRedirect(request.getContextPath() + "/View/report.jsp");

	}

}
