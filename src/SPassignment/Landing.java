package SPassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WebappClass
 */
@WebServlet("/Landing")
public class Landing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SQLConnection sql = new SQLConnection();
	String username;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Landing() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	      
		try{
	          response.setContentType("text/html");
	          PrintWriter pwriter = response.getWriter();
	          HttpSession session=request.getSession(false);
		      String myName=(String)session.getAttribute("email");
	          pwriter.print("Name: "+myName);
	          username = myName;
	          pwriter.close();
	      }catch(Exception exp){
	          System.out.println(exp);
	       }
		
		
		request.getRequestDispatcher("/WEB-INF/report.jsp").forward(request, response);
    
	}

	public String getUsername() {
		return username;
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
