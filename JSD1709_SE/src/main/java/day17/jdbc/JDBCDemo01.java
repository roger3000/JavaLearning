package day17.jdbc;

import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
//导入驱动jar包
//        注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        获取数据库链接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=GMT", "root", "root");
//        定义sql语句
        String sql = "update account set balance = 500 where id = 1";
//        获取执行sql对象
        Statement statement = connection.createStatement();
//        执行sql
        int i = statement.executeUpdate(sql);

        System.out.println(i);

        statement.close();
        connection.close();

    }
}
