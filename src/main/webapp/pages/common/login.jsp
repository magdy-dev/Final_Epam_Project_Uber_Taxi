 <%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/13/2021
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent"><br>
        <a class="inactive underlineHover" href="registerClient.jsp">Register Client </a><br>
        <a class="inactive underlineHover" href="registerDriver.jsp">Register Driver </a>
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="text" id="login" class="fadeIn second" name="username" placeholder="login">
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="hidden" name="command" value="login">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>
        <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password?</a>
        </div>
    </div>
</div>
<footer class="container-fluid">
    <p>TAXI</p>
</footer>
</body>
</html>
