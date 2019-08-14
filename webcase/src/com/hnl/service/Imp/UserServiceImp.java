package com.hnl.service.Imp;

import com.hnl.dao.Imp.UserDaoImp;
import com.hnl.domain.User;
import com.hnl.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {
    private UserDaoImp dao = new UserDaoImp();
    @Override
    public List<User> findAll() {
//        调用dao完成查询
        return dao.findAll();
    }

    @Override
    public User findUser(String id) {
        //调用Dao完成查询
        return dao.findOne(id);
    }

    @Override
    public boolean addUser(User user) {

        return  dao.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.update(user);
    }

    @Override
    public boolean deleteUser(String id) {
       return dao.delete(id);
    }
}
