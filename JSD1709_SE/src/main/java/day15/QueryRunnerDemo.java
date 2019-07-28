package day15;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;



/**
 * 使用queryrunner类, 实现对数据库的
 * insert delete update
 * @author HNL
 *
 */
public class QueryRunnerDemo {
	public static void main(String[] args) {
		try {
			insert();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert() throws SQLException {
		QueryRunner qu = new QueryRunner();
		String sql = "insert into sort(sname, sprice, sdesc) values (?,?,?)";
		Object[] params = {"医疗用品", 5000, "购买医疗用品"};
		
		int result = qu.execute(JDBCUtilsConfig.getConnection(), sql, params);
		System.out.println("returned:"+result+"rows");
		
	}
}
