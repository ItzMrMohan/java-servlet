
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mohan
 */
@WebServlet(urlPatterns="/statics")
public class BusinessStatics extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String request=req.getParameter("statics");
        boolean isValid = true;
        
        if(isValid = true){
            req.getRequestDispatcher("/WEB-INF/Addition/BusinessStatics.jsp").forward(req, resp);
        }
       
        
    }
}
