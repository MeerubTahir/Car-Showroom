

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

public class Login extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
	     String Username= request.getParameter("Username");
	     String Password = request.getParameter("Password");
	     if(Username.equals("Ahmad") && 	Password.equals("123"))
	     {
	    	 HttpSession session = request.getSession();
	         session.setAttribute("msg", "loginsuccessful");
	         response.sendRedirect("Admin.html");
	         
	    	 
	     }
	}

}
