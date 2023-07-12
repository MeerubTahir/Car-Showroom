

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;




public class UserSign_up extends HttpServlet {
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    
		// get PrintWriter object
		PrintWriter out = response.getWriter();

	    String name=request.getParameter("name");
	   
	    String password=request.getParameter("password");
	    
	    String email=request.getParameter("email");


	    out.println("<html>");
	    out.println("<head><title>Response</title></head>");
	    out.println("<body>");


	    try{

	    Class.forName("com.mysql.jdbc.Driver");

	    String url = "jdbc:mysql://127.0.0.1/usertest";

	    Connection con=(Connection) DriverManager.getConnection(url, "root", "root");

	    Statement st=con.createStatement();

	     
	     String query = "INSERT INTO usersignup(name,password,email)VALUES('"+ name + "','"+password+"','"+email+"') ";

	     System.out.println(query);
	     

	      int rs = st.executeUpdate( query );
	      
	      query = "INSERT INTO userlogin(name,password)VALUES('"+ name + "','"+password+"') ";
	      st.executeUpdate( query );

	     if(rs==1){	out.println("<h1>Insertion successful</h1>"); 		}
		else{	out.println("<h1>Record could not be inserted.</h1>"); 		}

	     out.println("</body></html>");

	           st.close();
	           con.close();

	    }catch(Exception e){

	      out.println(e);
	    }
		
	}



}

