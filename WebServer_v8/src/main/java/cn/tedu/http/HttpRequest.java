package cn.tedu.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cn.tedu.core.HttpContext;

/**
 * 该类的每一个实例用于表示客户端发送过来的一次HTTP请求内容
 * 这里包含: 请求行信息 消息头 消息正文
 * @author 许皓泉
 *
 */
public class HttpRequest {
	/*
	 * 请求行中的内容
	 */
	private String method;
	private String uri;
	private String protocol;
	
	//请求信息
	private String requestLine;
	//请求附带的所有参数
	private Map<String,String> params = new HashMap<String, String>();
	/*
	 * 消息头中的内容
	 * 
	 */
	private Map<String, String> headers =
			new HashMap<String, String>();
	/**
	 * 构造方法,通过给定的输入流读取客户端发送过来的Http请求
	 * @param in
	 */
	public HttpRequest(InputStream in) {
		/*
		 * 解析分为三部
		 * 1. 解析请求行
		 * 2. 解析消息头
		 * 3. 解析消息正文
		 */
		parseRequestLine(in);
		parseHeaders(in);
		parseUri();
	}
	/**
	 * 解析请求行
	 */
	private void parseRequestLine(InputStream in){
		/*
		 * 解析请求行的大致步骤
		 * 1. 通过输入流读取一行字符串
		 * 	以CRLF结尾
		 * 	CR:回车 ASC编码对应13
		 * 	LF:换行 ASC编码对应10
		 * 2. 将读取的请求行内容按照空格拆分
		 * 3. 将拆出来的字符串保存到对应设置上
		 */
			String line = readLine(in);
			String[] str = line.trim().split("\\s");
			
			if(str != null && str.length > 1 ) {
				method = str[0];
				uri = str[1];
				protocol = str[2];
			}
		
	}
	
	/*
	 * 解析uri
	 */
	public void parseUri() {
		if(uri != null && uri.contains("?")) {
			requestLine = uri.substring(0, uri.indexOf("?"));
			parseGet(uri.substring(uri.indexOf("?")+1));
			
		}else if(uri != null) {
			requestLine = uri;
		}
	}
	
	public void parseGet(String input) {
		String[] strs = input.split("&");
		for (int i = 0; i < strs.length; i++) {
			String key = strs[i].substring(0, strs[i].indexOf("="));
			String value = strs[i].substring(strs[i].indexOf("=")+1);
			params.put(key, value);
		}
	}
	
	/**
	 * 解析消息头
	 * @return
	 */
	private void parseHeaders(InputStream in) {
		while(true) {
			String line = readLine(in);
			if("".equals(line)) {
				break;
			}
			String name = line.substring(0, line.indexOf(":")).trim();
			String value = line.substring(line.indexOf(":")+1).trim();
			
			this.headers.put(name, value);
		}
	}
	
	public String readLine(InputStream in) {
		StringBuilder sb = new StringBuilder();
		char c1=0,c2=0;
		int d = -1;
		
		try {
			while((d =  in.read()) != -1) {
				c2 = (char)d;
				if(c1 == HttpContext.CR && c2 == HttpContext.LF) {
					break;
				}
				sb.append(c2);
				c1 = c2;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString().trim();
	}
	
	/**
	 * 根据给定的参数名获取参数值
	 * @param name
	 * @return
	 */
	public String getParameter(String name) {
		return params.get(name);
	}
	
	public String getMethod() {
		return method;
	}
	public String getUri() {
		return uri;
	}
	public String getProtocol() {
		return protocol;
	}
	public Map<String, String> getHeaders() {
		return headers;
	}
	public String getRequestLine() {
		return requestLine;
	}
	
	
}
