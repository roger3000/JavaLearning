package com.hnl.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo1被访问了");

        /*resp.setStatus(302);
        resp.setHeader("location", "ResponseDemo2");*/

        System.out.println(req.getServletPath());
        System.out.println(req.getContextPath());
        //有更简单的重定向方法
        resp.sendRedirect("ResponseDemo2");
//        resp.sendRedirect("http://www.baidu.com");
    }
}



