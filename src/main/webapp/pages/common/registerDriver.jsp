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

      <input type="text" id="name" class="fadeIn second" name="username" placeholder="Name">
      <input type="text" id="lastname" class="fadeIn third" name="lastname" placeholder="LastName">
      <input type="text" id="phoneNumber" class="fadeIn second" name="phoneNumber" placeholder="phoneNumber">
      <input type="text" id="login" class="fadeIn second" name="username" placeholder="Email">
      <input type="password" class="form-control" id="inputPassword" placeholder="Password">
      <input type="text" id="carNumber" class="fadeIn third" name="carNumber" placeholder="carNumber">

      <input type="text" name="command" value="Register" hidden>
      <input type="submit" class="fadeIn fourth" value="Register">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" >Driver Taxi</a>
    </div>

  </div>
</div>


</body>
</html>