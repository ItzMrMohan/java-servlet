
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author johns
 */
@WebServlet(urlPatterns = "/login")
public class dbValidate extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        System.out.println(session.getAttribute("emailver"));
        if (session.getAttribute("emailver").equals(0)) {
            
            String otpfromUI = request.getParameter("OTP");
            Integer num = (Integer)session.getAttribute("otp");
            String otpfromServlet = num.toString();
            if (otpfromUI.equals(otpfromServlet)) {
                try {
                    DataBase.postintoDB_Query("update user_table set emailver = 1 where e_name='" + session.getAttribute("name") + "'");
                    System.out.println("Email Verified for " + session.getAttribute("name"));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(dbValidate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(dbValidate.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.setAttribute("wrongOTP", "Incorrect OTP provided");
                request.getRequestDispatcher("WEB-INF/Views/login.jsp").
                        forward(request, response);
            }
        }
        String usrName;
        String name = (String) session.getAttribute("name");
        String role = "";
        List<String> perList = new ArrayList<>();
        try {
            
            JSONParser parser = new JSONParser();
            String filePath = getServletContext().getRealPath("/WEB-INF/Files/RolesAndPermissions.json");
            JSONObject jsonObject;
            jsonObject = (JSONObject) parser.parse(new FileReader(filePath));
            JSONArray roleGroup = (JSONArray) jsonObject.get("roleGroup");
            Iterator roleItr = roleGroup.iterator();
            while (roleItr.hasNext()) {
                JSONObject singleRole = (JSONObject) roleItr.next();
                Set roleNameKey = singleRole.keySet();
                Iterator roleName = roleNameKey.iterator();
                while (roleName.hasNext()) {
                    JSONObject singgleRole = (JSONObject) singleRole.get(roleName.next());
                    
                    JSONArray users = (JSONArray) singgleRole.get("users");
                    Iterator usr = users.iterator();
                    usrName = "";
                    while (usr.hasNext()) {
                        usrName = (String) usr.next();
                        if (name.equals(usrName)) {
                            Set set = singleRole.keySet();
                            Iterator us = set.iterator();
                            while (us.hasNext()) {
                                role = (String) us.next();
                                JSONArray permissions = (JSONArray) singgleRole.get("permissions");
                                Iterator prm = permissions.iterator();
                                
                                while (prm.hasNext()) {
                                    String temp = (String) prm.next();
                                    perList.add(temp);
                                }
                                break;
                            }
                        }
                    }
                    
                }
            }
            Date date = new Date();
            System.out.println("User " + name + " has logged in as " + role + " at " + date + ". The user has the following permissions");
            System.out.println(perList);
            session.setAttribute("role", role);
            request.setAttribute("role", role);
            request.setAttribute("user", name);
            request.setAttribute("list", perList);
            request.getRequestDispatcher("WEB-INF/Views/MainPage.jsp").
                    forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(dbValidate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {HttpSession session = request.getSession(false);
        System.out.println(session.getAttribute("emailver"));
        if (session.getAttribute("emailver").equals(0)) {
            
            String otpfromUI = request.getParameter("OTP");
            Integer num = (Integer)session.getAttribute("otp");
            String otpfromServlet = num.toString();
            if (otpfromUI.equals(otpfromServlet)) {
                try {
                    DataBase.postintoDB_Query("update user_table set emailver = 1 where e_name='" + session.getAttribute("name") + "'");
                    System.out.println("Email Verified for " + session.getAttribute("name"));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(dbValidate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(dbValidate.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.setAttribute("wrongOTP", "Incorrect OTP provided");
                request.getRequestDispatcher("WEB-INF/Views/login.jsp").
                        forward(request, response);
            }
        }
        String usrName;
        String name = (String) session.getAttribute("name");
        String role = "";
        List<String> perList = new ArrayList<>();
        try {
            
            JSONParser parser = new JSONParser();
            String filePath = getServletContext().getRealPath("/WEB-INF/Files/RolesAndPermissions.json");
            JSONObject jsonObject;
            jsonObject = (JSONObject) parser.parse(new FileReader(filePath));
            JSONArray roleGroup = (JSONArray) jsonObject.get("roleGroup");
            Iterator roleItr = roleGroup.iterator();
            while (roleItr.hasNext()) {
                JSONObject singleRole = (JSONObject) roleItr.next();
                Set roleNameKey = singleRole.keySet();
                Iterator roleName = roleNameKey.iterator();
                while (roleName.hasNext()) {
                    JSONObject singgleRole = (JSONObject) singleRole.get(roleName.next());
                    
                    JSONArray users = (JSONArray) singgleRole.get("users");
                    Iterator usr = users.iterator();
                    usrName = "";
                    while (usr.hasNext()) {
                        usrName = (String) usr.next();
                        if (name.equals(usrName)) {
                            Set set = singleRole.keySet();
                            Iterator us = set.iterator();
                            while (us.hasNext()) {
                                role = (String) us.next();
                                JSONArray permissions = (JSONArray) singgleRole.get("permissions");
                                Iterator prm = permissions.iterator();
                                
                                while (prm.hasNext()) {
                                    String temp = (String) prm.next();
                                    perList.add(temp);
                                }
                                break;
                            }
                        }
                    }
                    
                }
            }
            Date date = new Date();
            System.out.println("User " + name + " has logged in as " + role + " at " + date + ". The user has the following permissions");
            System.out.println(perList);
            session.setAttribute("role", role);
            request.setAttribute("role", role);
            request.setAttribute("user", name);
            request.setAttribute("list", perList);
            request.getRequestDispatcher("WEB-INF/Views/MainPage.jsp").
                    forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(dbValidate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
