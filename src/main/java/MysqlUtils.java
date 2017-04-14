import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ishwar on 27/3/17.
 */
public class MysqlUtils {

    private final static String driver;
    private final static String Db_Url;
    private final static String user_name;
    private final static String password;

    private static Connection connection;

    static {
        driver = "com.mysql.jdbc.Driver";
        Db_Url = "jdbc:mysql://localhost:3306/jsp_exercise";
        user_name = "root";
        password = "root";
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(Db_Url, user_name, password);
        return connection;
    }
}
