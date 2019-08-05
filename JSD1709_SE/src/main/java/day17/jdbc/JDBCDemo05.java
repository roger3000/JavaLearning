package day17.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo05 {
    public static void main(String[] args) {
//        注册驱动 略过
//        链接数据库，获取Connection对象
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT", "root", "root")){
//            定义sql
            String sql = "create table student(id int primary key auto_increment, name varchar (30))";
//            获取执行sql 的对象
            try(Statement statement = conn.createStatement()){
//                执行sql
                int i = statement.executeUpdate(sql);
                System.out.println(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
