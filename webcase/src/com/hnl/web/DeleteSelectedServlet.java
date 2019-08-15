package com.hnl.web;

import com.hnl.service.Imp.UserServiceImp;
import com.hnl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/DeleteSelectedServlet")
public class DeleteSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Map<String, String[]> parameterMap = request.getParameterMap();
        String[] uids = parameterMap.get("uid");
        System.out.println(Arrays.toString(uids));*/

        String[] uids = request.getParameterValues("uid");
        assert uids != null;
        UserService userService = new UserServiceImp();
        userService.delUsers(uids);

        //跳转
        response.sendRedirect(request.getContextPath()+"/UserListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
