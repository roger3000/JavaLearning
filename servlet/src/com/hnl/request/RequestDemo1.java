package com.hnl.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getMethod();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        String protocol = request.getProtocol();
        String remoteAddr = request.getRemoteAddr();

        System.out.println(method);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(queryString);
        System.out.println(requestURI);
        System.out.println(requestURL);
        System.out.println(protocol);
        System.out.println(remoteAddr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getMethod();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        String protocol = request.getProtocol();
        String remoteAddr = request.getRemoteAddr();

        System.out.println(method);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(queryString);
        System.out.println(requestURI);
        System.out.println(requestURL);
        System.out.println(protocol);
        System.out.println(remoteAddr);
    }
}
