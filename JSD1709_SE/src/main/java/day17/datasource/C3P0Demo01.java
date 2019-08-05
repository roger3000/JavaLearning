package day17.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo01 {
    public static void main(String[] args) {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection conn = null;
        try {
            conn = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(conn);
    }
}
