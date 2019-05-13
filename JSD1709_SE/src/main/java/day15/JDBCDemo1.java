package day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.net.ssl.SSLEngineResult.Status;

public class JDBCDemo1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/day22_jdbc?serverTimezone=GMT";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);

		Statement stat = conn.createStatement();

		String sql = "select  * from sort";

		ResultSet set = stat.executeQuery(sql);

		while (set.next()) {
			System.out.println(set.getString("sname") + "," + set.getInt("sprice") + "," + set.getString("sdesc"));
		}
	}
}
