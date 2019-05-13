package day15;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/**
 * 	queryrunner的 update方法, delete方法 query方法
 * @author HNL
 *
 */
public class QueryRunnerDemo02 {
	private static QueryRunner qr;
	private static Connection conn;
	
	public static void main(String[] args) {
		conn = JDBCUtilsConfig.getConnection();
//		update();
//		delete();
		query();
	}
	
	private static void update() {
		qr = new QueryRunner();
		String sql = "update sort set sname=?, sprice=?, sdesc=? where sid=?";
		Object[] obj = {"花卉", 500.4, "情人节", 4};
		
		try {
			int result = qr.update(conn,sql, obj);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void delete() {
		qr = new QueryRunner();
		String sql = "delete from sort where sid = ?";
		Object[] params = {4};
		
		try {
			int result = qr.execute(conn, sql, params);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void query() {
		qr = new QueryRunner();
		String sql = "select * from sort";
		
		try {
//			Object[] obj= qr.query(conn, sql, new ArrayHandler());
			List<Object[]> obj = qr.query(conn, sql, new ArrayListHandler());
			for (Object[] objects : obj) {
				for (Object object : objects) {
					System.out.print(object);
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
