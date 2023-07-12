

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Clientlogout extends HttpServlet {
	
        


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

            response.sendRedirect("usersignin.html");
}
}