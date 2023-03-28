package webapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/create")
public class CreateUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("WEB-INF/Views/CreateNewUser.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException{
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		

			// JDBC driver name and database URL
		      final String DB_URL="jdbc:mysql://localhost:3306/archi?autoReconnect=true&useSSL=false";
		      
		      //  Database credentials
		      final String USER = "root";
		      final String PASS = "Prkstr@9112";

		      try {
		         // Register JDBC driver
		         Class.forName("com.mysql.cj.jdbc.Driver");

		         // Open a connection
		         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

		         // Execute SQL query
		         Statement stmt = conn.createStatement();
		         String sql;

		         sql = "insert into users values('"+name+"',"+phone+",'"+email+"',"+"'"+address+"',"+"'"+password+"')";
		         stmt.executeUpdate(sql);
		         System.out.println("Created a new User -"+ name);
		         // Clean-up environment
		         stmt.close();
		         conn.close();
		      } catch(SQLException se) {
		         //Handle errors for JDBC
		         se.printStackTrace();
		      } catch(Exception e) {
		         //Handle errors for Class.forName
		         e.printStackTrace();
		      }
		      finally {
		    	  request.getRequestDispatcher("WEB-INF/Views/login.jsp").forward(request,response);
		      }

		}
	
}
