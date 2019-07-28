package servlets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

public class RegServlet extends HttpServlet {
	public void service(HttpRequest request, HttpResponse response) {
	
		System.out.println("开始注册");
		/*
		 * 首先获取用户输入的注册信息
		 */
		String username = 
				request.getParameter("username");
		String pwd = 
				request.getParameter("password");
		String nickname = 
				request.getParameter("nickname");
		System.out.println(username+","+pwd+","+nickname);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream("user.txt",true)
							)
					);
			pw.println(username+","+pwd+","+nickname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pw!=null){
				pw.close();
			}
		}
		System.out.println("注册成功");
		forward("/myweb/reg_success.html", request, response);
	}
	
			
	
}
