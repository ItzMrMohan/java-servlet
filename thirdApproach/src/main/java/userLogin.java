
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author johns
 */
@WebServlet(urlPatterns = "/dbvalidate")
public class userLogin extends HttpServlet {
    static Boolean validUser = false;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        try {

            String username = (String) session.getAttribute("SessID");
            if (username == null) {
                request.setAttribute("unauth", "Please login");
                request.getRequestDispatcher("WEB-INF/Views/login.jsp").
                        forward(request, response);
            } else {
                System.out.println("Got a previous Session");
                request.getRequestDispatcher("login").
                        forward(request, response);
            }

        } catch (Exception e) {
            System.out.println("Didn't get a new Session");
            request.setAttribute("unauth", "Please login");
            request.getRequestDispatcher("WEB-INF/Views/login.jsp").
                    forward(request, response);
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String name;
        String pwd;
        Integer otp;
        Integer emailver;
        Integer e_id = null;
        String SessID;
        Integer newGuy = 0;
        String password;
        
        Boolean valid = false;

        name = request.getParameter("username");
        pwd = request.getParameter("password");
        String sql = "select e_pass from user_table where e_name = '" + name + "'";
        String e_idQuery = "select e_id from user_table where e_name = '" + name + "'";
        try {
            e_id = DataBase.getIntegerFromDB(e_idQuery);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            password = DataBase.getStringFromDB(sql);

            if (password.equals(pwd)) {
                String soquel = "select login_time from thirdApproachSession where e_id =" + e_id + "";
                Timestamp login = DataBase.getTimeStampFromDB(soquel);
                if (login == null) { // Checking if the user is new to the Site
                    newGuy = 1;
                }
                String sequel = "select logout_time from thirdApproachSession where e_id =" + e_id + "";
                Timestamp logout = DataBase.getTimeStampFromDB(sequel);
                if (logout == null && newGuy == 0) {
                    response.setContentType("text/html");
                    valid = true;
                    String query = "SELECT User_Agent FROM thirdApproachSession WHERE e_id="+ e_id + " and logout_time IS NULL";
                    String lastBrowser = DataBase.getStringFromDB(query);
                    request.setAttribute("oldSession", "Please log out of previous Session in "+lastBrowser);
                    request.getRequestDispatcher("WEB-INF/Views/login.jsp").
                            forward(request, response);
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("e_id", e_id);
                    session.setAttribute("name", name);
                    SessID = session.getId();
                    session.setAttribute("SessID", SessID);
                    long now = System.currentTimeMillis();
                    Timestamp sqlTimestamp = new Timestamp(now);
                    String userAgent = request.getHeader("user-agent");
                    String browserName = "";
                    if (userAgent.contains("Edg")) { //checking if Chrome
                        browserName = "MicroSoft Edge";
                    } else if (userAgent.contains("Chrom")) {  //Checking if Firefox
                        browserName = "Google Chrome";
                    }

                    DataBase.insertSession(SessID, e_id, sqlTimestamp, browserName);

                    String ver = "select emailver from user_table where e_name = '" + name + "'";
                    emailver = DataBase.getIntegerFromDB(ver);
                    session.setAttribute("emailver", emailver);
                    if (emailver.equals(0)) {
                        String emailQuery = "select e_email from user_table where e_name = '" + name + "'";
                        String email = DataBase.getStringFromDB(emailQuery);
                        valid = true;
                        request.setAttribute("email", email.replaceAll("(?<=.{3}).(?=[^@]+@)", "*"));
                        Random rand = new Random();
                        otp = rand.nextInt(10000);
                        session.setAttribute("otp", otp);
                        Play.send("tempnjayaraj@gmail.com", "prkstr@2022", email, "OTP for Authentication", otp);
                        request.getRequestDispatcher("WEB-INF/Views/emailOTP.jsp").
                                forward(request, response);
                        validUser = true;
                        session.setAttribute("validUser", validUser);
                        newGuy = 0;
                    } else {
                        request.getRequestDispatcher("login").
                                forward(request, response);
                        validUser = true;
                        session.setAttribute("validUser", validUser);
                        newGuy = 0;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (!valid) {
            request.setAttribute("error", "Please provide valid credentials");
            request.getRequestDispatcher("WEB-INF/Views/login.jsp").
                    forward(request, response);
        }
    }
}
