
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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
@WebServlet(urlPatterns="/logout")
public class userLogout extends HttpServlet{
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        long now = System.currentTimeMillis();
                Timestamp sqlTimestamp = new Timestamp(now);
        try {
            HttpSession session = request.getSession(false);
            String sid =(String)session.getAttribute("SessID");
            session.invalidate();
            userLogin.validUser = false;
            DataBase.updateDB("update thirdApproachSession set logout_time='"+
                    sqlTimestamp+"' where s_id_Created='"+sid+"'");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userLogout.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userLogout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        request.getRequestDispatcher("WEB-INF/Views/login.jsp").
                forward(request, response);
    }
}
