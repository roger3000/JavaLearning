package cn.tedu.http;

import java.io.IOException;
import java.io.InputStream;

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
		int d = -1;
		char c1=0,c2=0;
		StringBuilder sb = 
				new StringBuilder();
		try {
			while((d = in.read()) != -1){
				c2 = (char)d;
				if(c1 == 13 && c2 == 10) {
					break;
				}
				sb.append((char)d);
				c1 = c2;
			}
			
			String[] str = sb.toString().trim().split("\\s");
			
			if(str != null && str.length > 1 ) {
				method = str[0];
				uri = str[1];
				protocol = str[2];
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	
}
