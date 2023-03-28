

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author johns
 */
@WebServlet(urlPatterns = "/createUser")
public class createUser extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/Views/CreateNewUser.jsp").
                forward(request, response);
    }
    
     protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("usrNamefromUI");
        String mobile = request.getParameter("mobNofromUI");
        String email = request.getParameter("emailfromUI");
        String pass = request.getParameter("passfromUI");
        User user = new User();
        user.setUsername(username);
        user.setMobile(Long.parseLong(mobile));
        user.setEmail(email);
        user.setPass(pass);
        
        
        System.out.println(username+mobile+email+pass);
        
         Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
         SessionFactory sf = con.buildSessionFactory();
         Session session = sf.openSession();
         Transaction tx = session.beginTransaction();
         session.save(user);
         tx.commit();
         request.setAttribute("usrcrt", "User Created, Please login with your credentials");
         request.getRequestDispatcher("WEB-INF/Views/login.jsp").
                forward(request, response);
     }

}
