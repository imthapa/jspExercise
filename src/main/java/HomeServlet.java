import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ishwar on 14/4/17.
 */
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession(false);
        if (httpSession == null) {
            response.sendRedirect("/login");
        } else {
            String userName = (String) httpSession.getAttribute("userName");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false) == null) {
            response.sendRedirect("/login");
        } else {
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        }
    }
}
