
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = "/print")
public class PrintUserData extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            String username = (String) session.getAttribute("name");
            String role = (String)session.getAttribute("role");
            Integer e_id = (Integer)session.getAttribute("e_id");
            String mail = DataBase.getStringFromDB("select e_email from user_table where e_id="+e_id+";");
            Long mob = DataBase.getIntegerFromDB_("select e_mob from user_table where e_id="+e_id+";");
            request.setAttribute("e_mob", mob);
            request.setAttribute("e_email", mail);
            request.setAttribute("user", username);
            request.setAttribute("e_name", username);
            request.setAttribute("role", role);
            request.setAttribute("e_id", e_id);
            request.getRequestDispatcher("WEB-INF/Views/PrintUserData.jsp").
                    forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PrintUserData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrintUserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
