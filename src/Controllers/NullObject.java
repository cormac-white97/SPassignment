package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class NullObject {
	
	public NullObject() {
		
	}
	
	public void redirect(HttpServletResponse response) {
	      PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Snip

        out.write("<html>");
        out.write("<head/>");
        out.write("<body>");
        out.write("<title>ERROR</title>");
        out.write("An error occured when attempting to fill the request");
        out.write("</body>");
        out.write("</html>");
    }
	

}
