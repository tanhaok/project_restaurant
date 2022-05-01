package connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DdUtil {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/restaurant_db";
    private static String user = "root";
    private static String password = "12345";
    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void main(String[] args) {
        try (Connection con = DdUtil.getConnection() ) {
            System.out.println("Connected to MySql Server.");
        } catch (SQLException ex) {
            System.out.println("Connection Error!");
        }
    }

}
