package com.hnl.Test;

import com.hnl.dao.UserDao;
import com.hnl.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void TestLogin(){
        User user = new User();
        user.setUsername("superboy");
        user.setPassword("123");

        UserDao userDao = new UserDao();
        User login = userDao.login(user);

        System.out.println(login);
    }
}
