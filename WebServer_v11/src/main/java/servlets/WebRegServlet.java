package servlets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

public class WebRegServlet extends HttpServlet {

	@Override
	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("开始注册");
		
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		String result = name+","+password+","+email+","+phone;
		
		try {
			@SuppressWarnings("resource")
			FileOutputStream fos = new FileOutputStream("user.txt",true);
			byte[] b = result.getBytes();
			fos.write(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("注册成功");
		
		forward("/web/web/reg_success.html", request, response);
	}
	
}
