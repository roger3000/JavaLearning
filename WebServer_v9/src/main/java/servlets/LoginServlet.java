package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

public class LoginServlet extends HttpServlet {
	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("处理登陆");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+","+password);
		
		BufferedReader br;
		boolean login = false;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("user.txt"), "utf-8"));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] infos = line.split(",");
				String user = infos[0];
				String pwd = infos[1];
				if(user.equals(username) && pwd.equals(password)) {
					login = true;
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(login) {
			System.out.println("登陆成功");
			forward("/myweb/login_success.html", request, response);
		}else {
			System.out.println("登陆失败");
			forward("/myweb/login_error.html", request, response);
		}
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
//	}
}
