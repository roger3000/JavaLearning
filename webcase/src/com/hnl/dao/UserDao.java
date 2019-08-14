package com.hnl.dao;

import com.hnl.domain.User;

import java.util.List;

/**
 * 用户操作的dao
 */
public interface UserDao {

    //查询所有
    public List<User> findAll();

    //查询一个
    public User findOne(String id);
    //新增user

    public boolean add(User user);
    //修改user

    public boolean update(User user);
    //删除user

    public boolean delete(String id);
}
