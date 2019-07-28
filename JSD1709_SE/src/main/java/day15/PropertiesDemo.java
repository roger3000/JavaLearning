package day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * 	加载properties配置文件
 * 	IO读取文件, 键值对储存到集合
 * 	从几何中以键值对的方式获取数据库的连接信息,完成数据库的连接
 */
public class PropertiesDemo {
	public static void main(String[] args) throws Exception {
//		FileInputStream fis = new FileInputStream("./database.properties");
//		System.out.println(fis);
		InputStream in = PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
//		System.out.println(in);
		
		Properties pro = new Properties();
		pro.load(in);
		
		String driverClass = pro.getProperty("dirverClass");
		String url = pro.getProperty("url");
		String username= pro.getProperty("username");
		String password= pro.getProperty("password");
		
		System.out.println(driverClass);
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		
		conn.close();
	}
}
