package com.hnl.web;

import com.hnl.dao.Imp.UserDaoImp;
import com.hnl.dao.UserDao;
import com.hnl.service.Imp.UserServiceImp;
import com.hnl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //调用userService的删除方法
        UserService userService = new UserServiceImp();
        boolean success = userService.deleteUser(id);
        if(success){
            request.getSession().setAttribute("msg","删除成功");
            response.sendRedirect("UserListServlet");
        }else {
            request.getSession().setAttribute("msg","删除失败");
            response.sendRedirect("UserListServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
