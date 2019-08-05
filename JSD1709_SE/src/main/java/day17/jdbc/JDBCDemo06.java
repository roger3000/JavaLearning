package day17.jdbc;

import java.sql.*;

public class JDBCDemo06 {
    public static void main(String[] args) {
//        注册驱动 略过
//        链接数据库，获取Connection对象
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT", "root", "root")){
//            定义sql
            String sql = "select * from account";
//            获取执行sql 的对象
            try(Statement statement = conn.createStatement()){
//                执行sql
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        double balance = resultSet.getDouble("balance");
                        System.out.println("id:" + id + "-----name:" + name + "-----balance:" + balance);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
