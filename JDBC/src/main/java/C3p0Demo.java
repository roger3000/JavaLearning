import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        for (int i=0;i<10;i++){
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        }
    }
}
