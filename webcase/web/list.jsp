<%@page language="java" pageEncoding="UTF-8" contentType="text/html;" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id){
            if(confirm("您确定要删除吗")){
                location.href="DeleteUserServlet?id="+id;
            }
        }

        window.onload = function (){
            document.getElementById("deleteSelected").onclick = function () {
                var cbs = document.getElementsByName("uid");
                var flag = false;
                for(var i=0; i<cbs.length; i++){
                    if(cbs.checked){
                        flag = true
                    }
                }
                if(confirm("确定删除?") && flag){
                    document.getElementById("userList").submit();
                }
            };
            document.getElementById("firstCb").onclick = function () {
                var cbList = document.getElementsByName("uid");

                for(var i=0; i<cbList.length; i++){
                    cbList[i].checked = this.checked;
                }
            };
        }
    </script>
</head>
<body>
<div class="container">
    <p class="alert" style="color: red">${msg}</p>
    <h3 style="text-align: center">用户信息列表</h3>
    <div class="row" style="margin: 0 8px">
        <form  class="form-inline">
            <span class="form-group">
                <label>姓名</label>
                <input class="form-control" type="text">
            </span>
            <span class="form-group">
                <label>籍贯</label>
                <input class="form-control" type="text">
            </span>
            <span class="form-group">
                <label>邮箱</label>
                <input class="form-control" type="text">
            </span>
            <button class="btn btn-default">查询</button>
            <div class="pull-right">
                <a class="btn bg-primary text-right" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
                <a class="btn bg-primary text-right" href="javascript:void(0);" id="deleteSelected">删除选中</a>
            </div>
        </form>
    </div>
    <form id="userList" action="${pageContext.request.contextPath}/DeleteSelectedServlet" method="post">

        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input id="firstCb" type="checkbox" ></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="UpdateUserServlet?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="javaScript:deleteUser(${user.id});">删除</a></td>
                </tr>
            </c:forEach>

        </table>
    </form>
    <div class="row">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
