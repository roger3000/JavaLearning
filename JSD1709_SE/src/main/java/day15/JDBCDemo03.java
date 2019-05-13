package day15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * jdbc 读取数据表sort 每行数据封装到Sort类的对象中
 * 
 * @author HNL
 *
 */
public class JDBCDemo03 {
	public static void main(String[] args) throws Exception {
		Connection conn = JDBCUtils.getConnectoin();

		String sql = "select * from sort";
		PreparedStatement pst = conn.prepareStatement(sql);

		ResultSet rs = pst.executeQuery();

		List<Sort> list = new ArrayList<Sort>();

		while (rs.next()) {
			Sort sort = new Sort(rs.getInt("sid"), rs.getString("sname"), rs.getDouble("sprice"),
					rs.getString("sdesc"));
			list.add(sort);
		}

		JDBCUtils.close(conn, pst, rs);

		for (Sort sort : list) {
			System.out.println(sort);
		}
	}
}
