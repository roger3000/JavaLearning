package day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JDBCDemo {
	public static void main(String[] args) throws Exception {
//		DriverManager.registerDriver(new Driver());
		//使用反射加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		/*
		 * 获得数据库连接 DriverManager类中静态方法
		 * static Connection getConnection(String url, String user, String pwd)
		 * 返回值是Connection接口的实现类, 在mysql驱动程序
		 */
		String url = "jdbc:mysql://localhost:3306/day22_jdbc?serverTimezone=GMT";
		String user = "root";
		String psssword = "root";
		
		Connection con = DriverManager.getConnection(url, user, psssword);
		
//		System.out.println(con);
		/*
		 * 获得语句执行平台
		 * 通过数据库连接对象, 获取到SQL语句的执行者对象
		 *Connection对象调用方法 Statment createStateMent() 获取Statement对象, 将Sql语句发送到数据库
		 */
		Statement stat = con.createStatement();
		
		String sql = "insert into sort(sname, sprice, sdesc) values('汽车', 5000,'疯狂涨价')";
		
		stat.execute(sql);
		
		
	}
}
