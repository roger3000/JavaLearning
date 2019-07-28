package servlets;

import java.io.File;

import cn.tedu.core.HttpContext;
import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

public abstract class HttpServlet {
	public void service(HttpRequest request, HttpResponse response) {

	}

	public void forward(String path, HttpRequest request, HttpResponse response) {
		try {
			File file = new File("webapps" + path);
			String name = file.getName().substring(file.getName().lastIndexOf(".") + 1);
			String contentType = HttpContext.getMineMap(name);
			response.setContentType(contentType);
			response.setContentLength((int) file.length());
			response.setEntity(file);
			response.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
