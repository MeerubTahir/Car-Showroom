

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;




public class Logout extends HttpServlet {
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    
		HttpSession sess1 = request.getSession(false);
             
                sess1.getAttribute("client");
               
                sess1.invalidate();
 
                RequestDispatcher rd = request.getRequestDispatcher("/sign.html");
                rd.include(request,response);
		
	}
}




