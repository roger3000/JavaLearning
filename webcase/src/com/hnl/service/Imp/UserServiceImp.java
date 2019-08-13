package com.hnl.service.Imp;

import com.hnl.dao.Imp.UserDaoImp;
import com.hnl.domain.User;
import com.hnl.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {
    @Override
    public List<User> findAll() {
//        调用dao完成查询
        UserDaoImp udi = new UserDaoImp();
        return udi.findAll();
    }

    @Override
    public boolean addUser(User user) {
        UserDaoImp imp = new UserDaoImp();
        return  imp.add(user);
    }
}
