package com.hnl.web;

import com.hnl.domain.User;
import com.hnl.service.Imp.UserServiceImp;
import com.hnl.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取user id
        String id = request.getParameter("id");
        UserService userService = new UserServiceImp();
        //从request获取参数
        if(request.getParameter("action") != null && request.getParameter("action").equals("update")){
            User user = new User();
            try {
                BeanUtils.populate(new User(), request.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            boolean b = userService.updateUser(user);
            response.sendRedirect("UserListServlet");
        }else {
            //调用service层查找user
            User user = userService.findUser(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
