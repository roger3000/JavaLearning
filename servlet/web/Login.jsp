<%--
  Created by IntelliJ IDEA.
  User: HNL
  Date: 2019/8/12
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "CheckCodeServlet?time="+Math.random();
            }
        }
    </script>
</head>
<body>
    <div style="color: red"><%=request.getAttribute("msg")==null? "":request.getAttribute("msg")%></div>
    <form action="CheckCodeDemo" method="post">
        <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="CheckCodeServlet"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登陆"></td>
        </tr>
        </table>
    </form>
</body>
</html>
