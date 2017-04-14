import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

     //   System.out.println(req.getAttribute("error"));

        if (name == "" || userName == "" || password == "") {
            req.setAttribute("error", "All fields are required!!");
            req.getRequestDispatcher("/WEB-INF/register.jsp").include(req, resp);
            return;
        }

        try {
            Connection connection = MysqlUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES (?,?,?)");

            statement.setString(1, name);
            statement.setString(2, userName);
            statement.setString(3, password);

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (MySQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            req.setAttribute("error", "User Already Exists!!");
            req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Failed!! Please try again.");
            req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }


        req.setAttribute("success", "You have been successfully registered. Please Login!");
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
