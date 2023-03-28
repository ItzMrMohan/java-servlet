
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/userRoles")
public class Login extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        Boolean isValid = false;
        String usr_name = req.getParameter("uname");
        String password_by_user = req.getParameter("psw");
        String sql = "select e_pass from employeetable where e_name='"+usr_name+"'";
        try {
            String password_from_db = Database.createSingleResultSet(sql);
            
            if(password_from_db.equals(password_by_user)){
                isValid = true;
                String forID = "select role_id from employeetable where e_name='"+usr_name+"'";
                String roleID = Database.createSingleResultSet(forID);
                
                
//                
//                
//                
                String forName="Select role_name from roles where role_id='"+roleID+"'";
                String roleName =Database.createSingleResultSet(forName);
                
//                if(roleName.equals(usr_name)){
                req.getRequestDispatcher("/WEB-INF/Addition/"+roleName+".jsp").forward(req, resp);
                
//                }
                
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(!isValid){
            req.setAttribute("error", "Username/Password is not valid.Please enter the valid user");
            req.getRequestDispatcher("/WEB-INF/Addition/login.jsp").forward(req, resp);
        }
    }
}