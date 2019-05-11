package servlets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

public class RegWebServlet extends HttpServlet {
	

	@Override
	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("开始注册");
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		try {
			RandomAccessFile raf = new RandomAccessFile("user.txt", "rw");
			writeRaf(raf, name, 10);
			writeRaf(raf, password, 20);
			writeRaf(raf, email, 30);
			writeRaf(raf, phone, 13);
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
	
	private void writeRaf(RandomAccessFile raf, String str, int len) {
		byte[] b = str.getBytes();
		b = Arrays.copyOf(b, len);
		try {
			raf.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
