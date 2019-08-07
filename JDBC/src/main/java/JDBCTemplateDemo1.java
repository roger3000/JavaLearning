import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            JdbcTemplate template = new JdbcTemplate(ds);
            String sql =   "update account set balance = 5000 where id = ?";
            int update = template.update(sql, 3);
            System.out.println(update);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
