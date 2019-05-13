package day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *  	Java 实现用户名密码登陆, 数据库检测
 *    	防止注入攻击
 *  	Statement接口实现类, 作用执行sql语句, 返回结果集
 *  	有一个子接口 PreparedStatement (sql预编译接口)
 * @author HNL
 *
 */
public class JDBCDemo02 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String user = "root";
		String password = "root";
		
		Scanner sc = new Scanner(System.in);
		String sname = sc.nextLine();
		String sprice = sc.nextLine();
		String url = "jdbc:mysql://localhost:3306/day22_jdbc?serverTimezone=GMT";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		String sql = "select * from sort where sname=? AND sprice=?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sname);
		pst.setObject(2, sprice);
		
	}
}
