package com.hnl.cookie;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/CookieServlet2")
public class CookieServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        ServletOutputStream outputStream = response.getOutputStream();
        Calendar instance = Calendar.getInstance();
        Date date = instance.getTime();
        String newTime = date.toString();
        newTime = URLEncoder.encode(newTime, "utf-8");
        if(cookies != null && cookies.length > 0){
            boolean flag = false;
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String time = cookie.getValue();
                time = URLDecoder.decode(time, "utf-8");
                if("time".equals(name)){
                    outputStream.write(("欢迎回来,上次访问时间:"+time).getBytes());
                    flag = true;
                }
            }

            if(!flag){
                outputStream.write(("你好, 欢迎你首次访问").getBytes());
            }
        }
        System.out.println(date);
        Cookie cookie = new Cookie("time", newTime);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
