<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hnl.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: HNL
  Date: 2019/8/12
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add(new User("张三", 24, new Date()));
    list.add(new User("李四", 25, new Date()));
    list.add(new User("王五", 27, new Date()));

    request.setAttribute("list", list);
%>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birStr}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
