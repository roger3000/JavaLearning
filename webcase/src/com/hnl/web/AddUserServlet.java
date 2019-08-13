package com.hnl.web;

import com.hnl.dao.Imp.UserDaoImp;
import com.hnl.dao.UserDao;
import com.hnl.domain.User;
import com.hnl.service.Imp.UserServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从request中读取数据装载到user bean中
        request.setCharacterEncoding("utf-8");
        User user = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用dao层将user添加到数据库
        UserServiceImp imp = new UserServiceImp();
        boolean success = imp.addUser(user);

        if(success){
            request.setAttribute("msg", "添加成功");
            request.getRequestDispatcher("UserListServlet").forward(request, response);
        }else{
            request.setAttribute("msg", "添加失败");
            request.getRequestDispatcher("UserListServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
