package cn.tedu.http;
/**
 * 表示一个http响应
 * @author HNL
 *
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import cn.tedu.core.HttpContext;

public class HttpResponse {
	private File entity;
	private OutputStream out;
	private Map<String,String> headers = new HashMap<String,String>();
	
	//状态响应码
	private int statusCode = HttpContext.STATUS_CODE_OK;
	
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
		String line ="HTTP/1.1"+statusCode+HttpContext.getCode_reason_mapping(statusCode);
		println(line);
	}
	
	//发送响应头
	public void sendResponseHead() {
		Set<Entry<String,String>> headerSet 
		= headers.entrySet();
		for(Entry<String,String> header : headerSet){
			String line = header.getKey()+":"+header.getValue();
			println(line);//发送每一个头信息
		}
		println("");//单独发送CRLF表示头发送完毕
	}
	
	//发送正文
	public void sendContent() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(entity);
			int len = -1;
			byte[] data = new byte[1024*10];
			while((len = fis.read(data))!=-1){
				out.write(data,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//响应输出方法
	private void println(String line){
		try {
			out.write(line.getBytes("ISO8859-1"));
			out.write(HttpContext.CR);
			out.write(HttpContext.LF);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获取输出介质
	public String getMimeTypeByEntity() {
		String name = entity.getName().substring(
				entity.getName().lastIndexOf(".")+1
			);
		return HttpContext.getMineMap(name);
	}

	/**
	 * 设置头信息Content-Type对应的值
	 * @param contentType
	 */
	public void setContentType(String contentType){
		this.headers.put("Content-Type", contentType);
	}
	/**
	 * 设置头信息Content-Length
	 * @param length
	 */
	public void setContentLength(int length){
		this.headers.put("Content-Length", length+"");
	}

	public File getEntity() {
		return entity;
	}

	public void setEntity(File entity) {
		this.entity = entity;
	}

	public void setStatusCode(int code) {
		this.statusCode = code;
	}
	
}
