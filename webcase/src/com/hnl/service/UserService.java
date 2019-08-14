package com.hnl.service;

import com.hnl.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    public User findUser(String id);

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(String id);
}
