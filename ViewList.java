

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;




public class ViewList extends HttpServlet {
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    
		// get PrintWriter object
		PrintWriter out = response.getWriter();

	    
            
	    
	   


	    out.println("<html>");
	    out.println("<head><title>Response</title></head>");
	    out.println("<body>");


	    try{

	    Class.forName("com.mysql.jdbc.Driver");

	    String url = "jdbc:mysql://127.0.0.1/car";

	    Connection con=(Connection) DriverManager.getConnection(url, "root", "root");

	    Statement st=con.createStatement();
          
            HttpSession sess4 = request.getSession(false);
            if(sess4.getAttribute("client") == null)
{           response.sendRedirect("usersignin.html")   ;   }

	     
	     String query = "SELECT * FROM carinfo ";

	     System.out.println(query);
	     

	      ResultSet rs = st.executeQuery( query );
              
	      while(rs.next())
{
            String n = rs.getString("carName");
            out.println(n + ",");
}



	         out.println("</body></html>");

	           st.close();
	           con.close();

                
	    }catch(Exception e){

	      out.println(e);
	    }
		
	}



}

