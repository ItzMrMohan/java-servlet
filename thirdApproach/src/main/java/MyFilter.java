
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {

        PrintWriter out = resp.getWriter();
        
        if (userLogin.validUser) {
            System.out.println("Valid User");
            chain.doFilter(req, resp);//sends request to next resource  
        } else {
            System.out.println("Not a valid User");
            req.setAttribute("unauth", "Please login to view that page");
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/Views/login.jsp");
            rd.include(req, resp);
        }

    }

    public void destroy() {
    }
}
