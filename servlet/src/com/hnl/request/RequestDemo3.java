package com.hnl.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ua = request.getHeader("user-agent");
        if(ua.contains("Chrome")){
            System.out.println("Chrome浏览器");
        }else if (ua.contains("fire-fox")){
            System.out.println("火狐浏览器");
        }
    }
}
