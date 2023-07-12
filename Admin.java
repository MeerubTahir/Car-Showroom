
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Admin extends HttpServlet {
	

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
	    response.setContentType("text/html");
		Class.forName("com.mysql.jdbc.Driver");
	    String url = "jdbc:mysql://127.0.0.1/Book";
	    Connection con=DriverManager.getConnection(url,"root","root");
	    Statement st=con.createStatement();
	    
	    
	    String ID = request.getParameter("Book ID");
	    String Title = request.getParameter("Book Title");
	    String Author = request.getParameter("Book Author");
	    String ISSN= request.getParameter("Book ISSN");
	    
	     String query="insert into Add(ID,Title,Author,ISSN) values('"+ID+"', '"+Title+"', '"+Author+"', '"+ISSN+"' )";

	 
	     int rs = st.executeUpdate( query );

		 System.out.println(rs);
	   
	     if(rs > 0){
		    System.out.println("Record inserted successfully.");
		  }
	     
	     else{
	    	 System.out.println("Record could not inserted.");
	         }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
