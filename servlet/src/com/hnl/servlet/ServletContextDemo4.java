package com.hnl.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();

        String realPath = context.getRealPath("druid.properties");
        String realPath1 = context.getRealPath("/WEB-INF/register.html");
        String realPath2 = context.getRealPath("/WEB-INF/classes/com/hnl/domain/User");

        System.out.println(realPath);
        System.out.println(realPath1);
        System.out.println(realPath2);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
