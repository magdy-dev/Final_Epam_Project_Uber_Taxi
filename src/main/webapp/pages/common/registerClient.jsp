<%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/13/2021
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Registration </title>
  <link rel="stylesheet" href="login.css">
</head>
<body >

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <a class="active" href="login.jsp">logIn</a><br>

    <!-- Login Form -->
    <form action="${pageContext.request.contextPath}/controller" method="post">

      <input type="text" id="name" class="fadeIn second" name="firstname" placeholder="Name">
      <input type="text" id="lastname" class="fadeIn third" name="lastname" placeholder="LastName">
      <input type="text" id="phoneNumber" class="fadeIn second" name="phoneNumber" placeholder="phoneNumber">
      <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email">
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="Password">

      <input type="hidden" name="command" value="register" >
      <input type="submit" class="fadeIn fourth" value="Register">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" >Client</a>
    </div>

  </div>
</div>
<footer class="container-fluid">
  <p>TAXI</p>
</footer>

</body>
</html>
