package day15;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilsConfig {
	public static Connection conn;
	private static String driverName;
	private static String url;
	private static String username;
	private static String password;

	static {
		try {
			InputStream in = PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
			Properties pro = new Properties();
			pro.load(in);
			String driverName = pro.getProperty("dirverClass");
			String url = pro.getProperty("url");
			String username= pro.getProperty("username");
			String password= pro.getProperty("password");
			
			
			System.out.println(driverName);
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}
	

}
