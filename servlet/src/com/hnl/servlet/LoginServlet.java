package com.hnl.servlet;

import com.hnl.dao.UserDao;
import com.hnl.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        /*//获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //封装user对象
        User user = new User(username, password);*/

        //获取所有请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        //创建user对象
        User user = new User();
        //使用beanUtils封装
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用userdao的login方法
        UserDao userDao = new UserDao();
        User login = userDao.login(user);

        //将user对象传入request域
        req.setAttribute("user", user);

        if(login == null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }
}
