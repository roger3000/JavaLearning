package day17.jdbc;

import java.sql.*;

public class JDBCDemo03 {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT", "root", "root")) {
            try (Statement statement = connection.createStatement()) {
                String sql = "update account set balance = 1500 where id = 3";
                int i = statement.executeUpdate(sql);
                if (i > 0){
                    System.out.println("执行成功");
                }else {
                    System.out.println("执行失败");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
