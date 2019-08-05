package day17.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo04 {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT", "root", "root")) {
            try (Statement statement = connection.createStatement()) {
                String sql = "delete from account where id = 3";
                int i = statement.executeUpdate(sql);
                System.out.println(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
