
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johns
 */
@WebServlet(urlPatterns="/printSession")
public class PrintUserSessionDetails extends HttpServlet {
     protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
         try {
             HttpSession session = request.getSession(false);
             String username = (String) session.getAttribute("name");
             String role = (String)session.getAttribute("role");
             Integer e_id = (Integer) session.getAttribute("e_id");
             List<ArrayList<String>> sessionDetails = new ArrayList<>();
             sessionDetails = DataBase.createMultipleResultSet("select * from thirdApproachSession where e_id="+e_id+";");
             request.setAttribute("sessions",sessionDetails);
             request.setAttribute("user", username);
             request.setAttribute("role", role);
             request.getRequestDispatcher("WEB-INF/Views/PrintUserSessionDetails.jsp").
                     forward(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(PrintUserSessionDetails.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(PrintUserSessionDetails.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}

