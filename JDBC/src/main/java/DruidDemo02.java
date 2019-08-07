import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DruidDemo02 {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into account values(null, ?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,"王五");
            pstm.setDouble(2,3000);
            int i = pstm.executeUpdate();
            System.out.println(i);

            JDBCUtils.release(pstm,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
