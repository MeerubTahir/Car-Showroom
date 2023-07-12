

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class BookCar extends HttpServlet {
	
        


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

            HttpSession sess2 = request.getSession(false);
             
                if(sess2.getAttribute("client") == null)
            {
                response.sendRedirect("usersignin.html");
            }

	    // get PrintWriter object
	    PrintWriter out = response.getWriter();

	    String companyName = request.getParameter("companyName");
	    String carName = request.getParameter("carName");

	    out.println("<html>");
	    out.println("<head><title>Response</title></head>");
	    out.println("<body >");

	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        String url = "jdbc:mysql://127.0.0.1/car";

	        Connection con = DriverManager.getConnection(url, "root", "root");

	        Statement st = con.createStatement();

	        String query = "SELECT * FROM carinfo  WHERE companyName='" + companyName+ "' AND carName='" + carName + "'";

	        ResultSet rs = st.executeQuery(query);

	        if (rs.next()) {
                    String price = rs.getString("price");
	            out.println("<h1> Your Car has been booked </h1>" );
                      String u = "jdbc:mysql://127.0.0.1/car";

	        Connection c = DriverManager.getConnection(u, "root", "root");

	        Statement s = c.createStatement();
                String q = "DELETE FROM carinfo where companyName = '"+companyName+"' AND carName='"+carName +"'";

	     System.out.println(query);
	     

	      int r = st.executeUpdate( q );
              s.close();
              c.close();

	        } else {
	            out.println("<h1>Sorry! Car is not Available </h1>");
	        }
              out.println("<br>");
              out.println("<br>");
              out.println("<h1> Thank You for visiting us <h1>");

	        out.println("</body></html>");

	        st.close();
	        con.close();

         

           

	    } catch (Exception e) {

	        out.println(e);
	    }
		
	}

}
