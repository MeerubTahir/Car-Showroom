

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Update extends HttpServlet {
	
        


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

            HttpSession ses3 = request.getSession(false);
             
                if(ses3.getAttribute("client") == null)
            {
                response.sendRedirect("sign.html");
            }

	    // get PrintWriter object
	    PrintWriter out = response.getWriter();

	    String companyName = request.getParameter("companyName");
	    String carName = request.getParameter("carName");
            String oldprice=request.getParameter("oldprice");
             String newprice=request.getParameter("newprice");

	    out.println("<html>");
	    out.println("<head><title>Response</title></head>");
	    out.println("<body >");

	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        String url = "jdbc:mysql://127.0.0.1/car";

	        Connection con = DriverManager.getConnection(url, "root", "root");

	        Statement st = con.createStatement();

	        String query = "UPDATE carinfo SET price = '"+newprice+"' WHERE companyName='" + companyName+ "' AND carName='" + carName + "' AND price = '"+ oldprice +"'";

	        int rs = st.executeUpdate(query);

	        
                    
	            out.println("<h1> Car's Price has been updated </h1>" );
                     
                 
	        

	        out.println("</body></html>");

	        st.close();
	        con.close();

         

           

	    } catch (Exception e) {

	        out.println(e);
	    }
		
	}

}
