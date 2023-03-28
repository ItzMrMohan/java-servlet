package com.archimedis;



import com.archimedis.Database;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author mohan
 */
@WebServlet(urlPatterns = "/home")
public class Login extends HttpServlet{
    
    String username;
    String pass;
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        
        req.getRequestDispatcher("Home.jsp").forward(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
        
        
        Boolean bhai= false;
        try {
            System.out.println("Welcome");
            
            username = req.getParameter("uname");
            pass = req.getParameter("psw");
            
            String sql="select emailId from userDetails where emailId="+"'"+username+"'"+";";
            System.out.println(sql);
            
            String valid= Database.createSingleResult(sql);
            System.out.println(valid);
            
            
            String id= "select uid from userDetails where emailId="+"'"+username+"'"+";";
            String UUID = Database.createSingleResult(id);
            System.out.println(UUID);
            
            
            String name = "Select firstName from userDetails where uid="+"'"+UUID+"'"+";";
            String profileName = Database.createSingleResult(name);
            req.setAttribute("profileName", profileName);
            
            
            
            HttpSession session = req.getSession();
            session.setAttribute("UUID", UUID);
            
            req.setAttribute("ProfileID",UUID);
            
            
            if(valid.equals("")){
                
                System.out.println("Signup First");
                req.setAttribute("signup","You are not able to Login...Please Signup First!!!!");
                req.getRequestDispatcher("Login.jsp").forward(req, res);
                
            }
            
            if(valid!=""){
                
                bhai=true;
                
                String sql2="select pass from userDetails where emailId="+"'"+valid+"'"+";";
                System.out.println(sql2);
                
                String validUser = Database.createSingleResult(sql2);
                System.out.println(validUser);
                
                if(validUser.equals(pass)){
                    System.out.println("Inside");
                    req.getRequestDispatcher("Home.jsp").forward(req, res);

                }else{
                    System.out.println("Please Enter the Valid Password");
                    req.setAttribute("validPass","Please Enter the Valid Password First!!!!");
                    req.getRequestDispatcher("Login.jsp").forward(req, res);
                }
                
            }
              
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
