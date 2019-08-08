package com.hnl.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1.获取所有的请求头
        Enumeration<String> headerNames = request.getHeaderNames();

        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.print(s);
            System.out.println(":"+request.getHeader(s)+"\n");
        }
    }
}
