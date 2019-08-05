package day17.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;
    static{

        Properties properties = new Properties();
        try {
//            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
//            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
//            properties.load(resourceAsStream);
            properties.load(new FileReader("C:\\Users\\HNL\\git\\JavaLearning\\JSD1709_SE\\src\\main\\java\\jdbc.properties"));

            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }

    public static void release(Connection conn, Statement stmt){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
