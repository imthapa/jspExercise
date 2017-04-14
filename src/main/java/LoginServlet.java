import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();

        if (userName == "" || password == "") {
            req.setAttribute("error", "All fields are required!!");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            return;
        }

        try {
            Connection connection = MysqlUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT name from users WHERE username=? AND password=?");

            statement.setString(1, userName);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            } else {
                req.setAttribute("error", "Invalid Credentials! Try Again....");
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
                return;
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Failed!! Please try again.");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.getSession().setAttribute("username", userName);
        resp.sendRedirect("/home");
    }
}
