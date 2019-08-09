package com.hnl.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext context = this.getServletContext();
        String mimeType = context.getMimeType(filename);
        String realPath = context.getRealPath("/img/" + filename);

        response.setHeader("content-disposition", "attachment;filename="+filename);
        response.setContentType(mimeType);

        ServletOutputStream outputStream = response.getOutputStream();

        try (FileInputStream in = new FileInputStream(realPath)) {

            byte[] data = new byte[1024 * 8];
//            int len = 0;
            while ((in.read(data)) != -1) {

                outputStream.write(data);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
