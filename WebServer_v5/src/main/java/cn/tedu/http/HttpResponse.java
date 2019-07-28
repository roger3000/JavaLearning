package cn.tedu.http;
/**
 * 表示一个http响应
 * @author HNL
 *
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class HttpResponse {
	private File entity;
	private OutputStream out;
	
	public HttpResponse(OutputStream out) {
		this.out = out;
	}
	
	public void flush() {
		sendStatusLine();
		sendResponseHead();
		sendContent();
	}
	
	//发送状态行
	public void sendStatusLine() {
		println("HTTP/1.1 200 OK");
	}
	
	//发送响应头
	public void sendResponseHead() {
		setContentType(getMimeTypeByEntity());
		setContentLength((int)entity.length());
		println("");
	}
	
	//发送正文
	public void sendContent() {
		BufferedInputStream bis = null;
		try {
			 bis = new BufferedInputStream(new FileInputStream(entity));
			
			int len = -1;
			while((len = bis.read()) != -1) {
				out.write(len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//获取输出介质
	public String getMimeTypeByEntity() {
		String[] str = entity.getName().split("\\.");
		String end = str[str.length-1];
		return HttpContext.getMineMap(end);
	}
	
	//响应输出方法
	public void println(String input) {
		try {
			out.write(input.getBytes("ISO8859-1"));
			out.write(13);
			out.write(10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setContentType(String contentType) {
		println("Content-Type:"+getMimeTypeByEntity());
	}
	
	public void setContentLength(int length) {
		println("Content-Length:"+length);
	}

	public File getEntity() {
		return entity;
	}

	public void setEntity(File entity) {
		this.entity = entity;
	}
	
}
