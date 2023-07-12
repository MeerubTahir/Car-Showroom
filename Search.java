

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Search extends HttpServlet {
	
        


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

            HttpSession sess1 = request.getSession(false);
             
                if(sess1.getAttribute("client") == null)
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
	            out.println("<h1> Car is Available and Price of the car is Rs: </h1>" + price);
                     
                 
	        } else {
	            out.println("<h1>Sorry! Car is not Available </h1>");
	        }

	        out.println("</body></html>");

	        st.close();
	        con.close();

         

           

	    } catch (Exception e) {

	        out.println(e);
	    }
		
	}

}
