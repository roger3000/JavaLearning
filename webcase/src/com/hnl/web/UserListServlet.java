package com.hnl.web;

import com.hnl.domain.User;
import com.hnl.service.Imp.UserServiceImp;
import com.hnl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用UserService完成查询
        UserService service = new UserServiceImp();
        List<User> users = service.findAll();
        //2.将查询到的信息储存到request 转发到list.jsp
        request.setAttribute("users", users);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
