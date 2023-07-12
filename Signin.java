

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Signin extends HttpServlet {
	
        


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

	    // get PrintWriter object
	    PrintWriter out = response.getWriter();

	    String userName = request.getParameter("username");
	    String password = request.getParameter("password");

	    out.println("<html>");
	    out.println("<head><title>Response</title></head>");
	    out.println("<body >");

	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        String url = "jdbc:mysql://127.0.0.1/test";

	        Connection con = DriverManager.getConnection(url, "root", "root");

	        Statement st = con.createStatement();

	        String query = "SELECT * FROM login  WHERE name='" + userName+ "' AND password='" + password + "'";

	        ResultSet rs = st.executeQuery(query);

                
             
                

	        if (rs.next()) {
	            out.println("<h1>Login Successful</h1>");

                    HttpSession sess = request.getSession(true);
                sess.setAttribute("client","userName");

                    String names = rs.getString("name");
                    String passwords = rs.getString("password");
                   if(names.equals("Meerub") && passwords.equals("123"))
{
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/admindirect.html");
                    rd.forward(request,response);

}

                    else
{
                    RequestDispatcher rd = request.getRequestDispatcher("/direct.html");
                    rd.forward(request,response);
}


                   
	        } else {
	            out.println("<h1>Invalid name or password</h1>");
	        }

	        out.println("</body></html>");

	        st.close();
	        con.close();

                
	    } catch (Exception e) {

	        out.println(e);
	    }
		
	}

}
