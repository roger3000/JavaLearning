package day17.jdbc;

import java.sql.*;
import java.util.List;

public class JDBCDemo08 {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = null;
        List<Emp> all = new JDBCDemo07().findAll();
        try {
            statement = connection.createStatement();
            String sql = "select * from emp";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                String ename = rs.getString("ename");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                all.add(new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(all);
    }
}
