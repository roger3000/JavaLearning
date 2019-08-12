package com.hnl.dao;

import com.hnl.domain.User;
import com.hnl.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 */
public class UserDao {
    //声明JDBCTemplate对象共用
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 登陆方法
     * @param user 只有用户名和密码
     * @return  user包含用户全部数据
     */
    public static User login(User user){
        try {
            //编写sql
            String sql = "select * from user where username = ? and password = ?";
            //调用query方法
            User query = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(),
                    user.getPassword());

            return query;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
