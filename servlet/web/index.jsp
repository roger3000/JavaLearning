<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: HNL
  Date: 2019/8/8
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
  //设置header
  Cookie[] cookies = request.getCookies();

  boolean flag = false;
  if(cookies != null && cookies.length >0){
    for(Cookie cookie : cookies){
      String name = cookie.getName();
      if ("lastLogin".equals(name)){
        //cookie存在 输出cookie中的时间
        String time = cookie.getValue();
        time = URLDecoder.decode(time, "utf-8");
        out.write("欢迎回来,上次访问时间:"+time);
        flag = true;
        break;
      }
    }
  }else if (cookies == null || cookies.length ==0 || flag == false){
   out.write("你好, 欢迎首次访问");
  }

  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
  String time = sdf.format(date);
  time = URLEncoder.encode(time, "utf-8");
  Cookie cookie = new Cookie("lastLogin", time);
  cookie.setMaxAge(60 * 60 * 24 * 30);
  response.addCookie(cookie);
%>
</body>
</html>
