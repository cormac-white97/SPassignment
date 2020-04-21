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
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/View/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession(false);

		DaoFacade i = new DaoFacade();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String manu = request.getParameter("manu");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		int stock = Integer.parseInt(request.getParameter("stock"));
		String image_path = request.getParameter("image");

		i.update("item", id, name, "", "", manu, price, category, stock, image_path, response, session, null);

		response.sendRedirect(request.getContextPath() + "/View/productSearch.jsp");

	}

}
