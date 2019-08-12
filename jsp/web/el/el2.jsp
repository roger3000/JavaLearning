<%--
  Created by IntelliJ IDEA.
  User: HNL
  Date: 2019/8/12
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中的数据</title>
</head>
<body>
    <%
        request.setAttribute("msg", "hello");
        session.setAttribute("msg", "world");
    %>

${requestScope.msg}
${sessionScope.msg}
<br>
${msg}
</body>
</html>
