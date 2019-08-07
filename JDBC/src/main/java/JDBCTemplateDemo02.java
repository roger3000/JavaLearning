import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sound.midi.Soundbank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo02 {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void test() {

        String sql="update emp set salary = 10000 where id = ?";
        int update = template.update(sql, "1001");

        System.out.println(update);

        String sql2 = "insert into emp values(?,?,?,?,?,?,?,?)";

        int update1 = template.update(sql2, 1015, "草泥马", 4, 1007, "2003-10-23", 12000.00, null, 20);
        System.out.println(update1);

        String sql3 = "delete from emp where id = ?";
        int update2 = template.update(sql3, 1015);
        System.out.println(update2);

        String query = "select * from emp where id = ?";
        Map<String, Object> queryForMap = template.queryForMap(query,1011);
        for (Map.Entry<String, Object> entry : queryForMap.entrySet()) {
            System.out.println("key"+entry.getKey()+": "+entry.getValue());
        }
    }
    @Test
    public void test02(){
        String sql = "select * from emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for(Map<String, Object> emp : maps){
            for (Map.Entry<String, Object> entry : emp.entrySet()) {
                System.out.print(entry);
            }
            System.out.println("");
        }
    }

    @Test
    public void test03(){
        String sql = "select * from emp";
        List<Emp> emps = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Emp(resultSet.getInt("id"),
                        resultSet.getString("ename"),
                        resultSet.getInt("job_id"),
                        resultSet.getInt("mgr"),
                        resultSet.getDate("joindate"),
                        resultSet.getDouble("salary"),
                        resultSet.getDouble("bonus"),
                        resultSet.getInt("dept_id"));
            }
        });
        for (Emp e : emps){
            System.out.println(e);
        }
    }

    @Test
    public void test04(){
        String sql = "select * from emp";
        List<Emp> query = template.query(sql,  new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : query) {
            System.out.println(emp);
        }

    }

    @Test
    public void test05(){
        String sql = "select count(id) from emp";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
}
