

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;




public class Remove extends HttpServlet {
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    
		// get PrintWriter object

             HttpSession sess2 = request.getSession(false);
             
                if(sess2.getAttribute("client") == null)
            {
                response.sendRedirect("sign.html");
            }
		PrintWriter out = response.getWriter();

	    String companyName=request.getParameter("companyName");
	   
	    String carName=request.getParameter("carName");
            
            String price = request.getParameter("price");
	    
	   


	    out.println("<html>");
	    out.println("<head><title>Response</title></head>");
	    out.println("<body>");


	    try{

	    Class.forName("com.mysql.jdbc.Driver");

	    String url = "jdbc:mysql://127.0.0.1/car";

	    Connection con=(Connection) DriverManager.getConnection(url, "root", "root");

	    Statement st=con.createStatement();

	     
	     String query = "DELETE FROM carinfo where companyName = '"+companyName+"' AND carName='"+carName +"'";

	     System.out.println(query);
	     

	      int rs = st.executeUpdate( query );
 
              out.println("<h1>  Thank You  </h1> ");
	      
	      

	         out.println("</body></html>");

	           st.close();
	           con.close();

               
	    }catch(Exception e){

	      out.println(e);
	    }
		
	}



}

