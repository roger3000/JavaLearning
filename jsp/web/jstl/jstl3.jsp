<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HNL
  Date: 2019/8/12
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        list.add("dddd");

        pageContext.setAttribute("list", list);
    %>
</body>
    <c:forEach begin="1" end="10" var="i" step="1">
        ${i}
    </c:forEach>
    <table border="1px" >
        <tr>
            <td>i</td>
            <td>index</td>
            <td>count</td>
        </tr>
        <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">

                <tr>
                    <td>
                        ${i}
                    </td>
                    <td>
                        ${s.index}
                    </td>
                    <td>
                        ${s.count}
                    </td>
                </tr>
        </c:forEach>
    </table>
<c:forEach var="s" items="${list}">
    ${s}
    <br>
</c:forEach>
</html>
