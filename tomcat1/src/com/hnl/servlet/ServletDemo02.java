package com.hnl.servlet;

import javax.servlet.*;
import java.io.IOException;


public class ServletDemo02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.........");
    }

    /**
     *获取servletConfig对象
     * servletConfig: servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次servlet被访问时执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service......");
    }

    /**
     * 获取servlet的一些信息, 版本, 作者等等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时, 执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}
