package com.hnl.cookie;

import org.junit.Test;

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
import java.util.Date;



@WebServlet("/CookieServlet")

public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置header
        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();

        boolean flag = false;
        if(cookies != null && cookies.length >0){
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                if ("lastLogin".equals(name)){
                    //cookie存在 输出cookie中的时间
                    String time = cookie.getValue();
                    time = URLDecoder.decode(time, "utf-8");
                    response.getWriter().write("欢迎回来,上次访问时间:"+time);
                    flag = true;
                    break;
                }
            }
        }else if (cookies == null || cookies.length ==0 || flag == false){
            response.getWriter().write("你好, 欢迎首次访问");
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String time = sdf.format(date);
        time = URLEncoder.encode(time, "utf-8");
        Cookie cookie = new Cookie("lastLogin", time);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
