<%--
  Created by IntelliJ IDEA.
  User: 卢娅婷
  Date: 2020/4/15
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录界面</title>
  </head>
  <body>
  <form action="LoginServlet" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="重置">
    <input type="submit" value="登录">
  </form>
  </body>
</html>
