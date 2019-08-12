<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HNL
  Date: 2019/8/12
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl1</title>
</head>
<body>
<%--    c:if标签
        test:   必须属性, 接受boolean表达式
--%>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");

    request.setAttribute("list", list);
%>
    <c:if test="${empty list}">
        <h1>为空</h1>
    </c:if>
    <c:if test="${not empty list}">
        <h1>不为空</h1>
    </c:if>
</body>
</html>
