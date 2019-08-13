package com.hnl.dao.Imp;

import com.hnl.dao.UserDao;
import com.hnl.domain.User;
import com.hnl.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.List;

public class UserDaoImp implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        try {
            List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return users;
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public boolean add(User user) {
        String sql = "insert into user values(?, ?, ?, ?, ?, ?, ?)";
        int update = jdbcTemplate.update(sql,
                null,
                user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQq(),
                user.getEmail()
        );
        return update != -1;
    }

    @Override
    public boolean update(User user) {
        String sql = "update user set ? = ? where id = ?";
        return false;
    }

    @Override
    public boolean delete(User user) {
        String sql = "delete from user where id = ?";
        int update = jdbcTemplate.update(sql, user.getId());
        return update != -1;
    }
}
