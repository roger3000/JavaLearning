package day17.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo07 {
    private Emp emp;

    public List<Emp> findAll(){
        Connection connection = null;
        String sql = "select * from emp";
        ArrayList<Emp> emps = new ArrayList<Emp>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT", "root", "root");
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String ename = resultSet.getString("ename");
                        int job_id = resultSet.getInt("job_id");
                        int mgr = resultSet.getInt("mgr");
                        Date joindate = resultSet.getDate("joindate");
                        double salary = resultSet.getDouble("salary");
                        double bounds = resultSet.getDouble("bonus");
                        int dept_id = resultSet.getInt("dept_id");

                        emps.add(new Emp(id, ename, job_id, mgr, joindate, salary, bounds, dept_id));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return emps;
    }

    public static void main(String[] args) {
        List<Emp> all = new JDBCDemo07().findAll();
        System.out.println(all);
    }
}
