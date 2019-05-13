package day15;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/**
 * 连接池jar包中, 定义好一个类BasicDataSource 实现数据源的规范接口 javax.sql.DataSource
 * 
 * @author 许皓泉
 *
 */
public class DataSourceDemo {
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;

	public static void main(String[] args) {

		// 创建一个datasource接口的实现类

		BasicDataSource bds = new BasicDataSource();
		getDataBaseProperties();
		System.out.println(driverClassName);
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);

		try {
			Connection conn = bds.getConnection();
			System.out.println(conn);
			
			QueryRunner qr = new QueryRunner();
			String sql = "select * from sort";
			
			List<Object[]> list = qr.query(conn, sql, new ArrayListHandler());
			for (Object[] objects : list) {
				for(Object object : objects) {
					System.out.print(object);
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getDataBaseProperties() {
		InputStream in = DataSourceDemo.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pr = new Properties();
		try {
			pr.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driverClassName = pr.getProperty("dirverClass");
		url = pr.getProperty("url");
		username = pr.getProperty("username");
		password = pr.getProperty("password");
	}
}
