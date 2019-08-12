package com.hnl.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int height = 50;
        //1.创建一个对象, 在内存中画图
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1 填充背景色
        Graphics graphics = image.getGraphics();//画笔对象
        graphics.setColor(Color.pink);  //画笔颜色
        graphics.fillRect(0,0,width, height);

        //2.2画边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width-1, height-1);


        //2.3写验证码
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=1; i<=4; i++){
            int index = random.nextInt(str.length());
            //获取字符
            char c = str.charAt(index);
            sb.append(c);
            graphics.drawString(c+"", width/5*i, height/2);
        }
        String checkCode = sb.toString();
        System.out.println(checkCode);
        request.getSession().setAttribute("checkCode", checkCode);

        //2.4画干扰线
        graphics.setColor(Color.green);
        //随机生成坐标点
        for(int i=1; i<=10; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(width);
            graphics.drawLine(x1,y1,x2,y2);
        }

        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
