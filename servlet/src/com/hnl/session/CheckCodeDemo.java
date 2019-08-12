package com.hnl.session;

import com.hnl.dao.UserDao;
import com.hnl.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/CheckCodeDemo")
public class CheckCodeDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkCode;

        response.setContentType("text/html; charset=utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        checkCode = request.getParameter("checkCode");
        String trueCode = (String) request.getSession().getAttribute("checkCode");
        System.out.println(checkCode+","+trueCode);
        request.getSession().removeAttribute("checkCode");
        request.setAttribute("user", user);

        if (checkCode.equalsIgnoreCase(trueCode)){
            System.out.println("验证码正确");
//      验证码正确
            //验证用户
            User login = UserDao.login(user);
            if (login != null){
                request.getRequestDispatcher("successServlet").forward(request,response);
            }else {
                request.getRequestDispatcher("failServlet").forward(request,response);
            }
        }else {
//      验证码错误
            System.out.println("验证码错误");
            request.setAttribute("msg", "验证码错误");
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
