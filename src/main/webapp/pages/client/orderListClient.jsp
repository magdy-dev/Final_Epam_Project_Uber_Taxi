<%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/14/2021
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <title>order</title>
</head>
<body style="background-color: gold">

<tag:userMenu/>

<div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
    <h3 class="text-center">List of Order</h3>

    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>Data</th>
        <th>DriverId</th>
        <th>DriverName</th>
        <th>DriverPhone</th>
        <th>DriverCarNumber</th>
        <th>From</th>
        <th>To</th>
      </tr>
      </thead>
      <tbody>
      <!--   for (Todo todo: todos) {  -->
      <c:forEach var="user" items="${listUser}">

        <tr>
          <td>
            <c:out value="${user.id}"/>
          </td>
          <td>
            <%= (new java.util.Date()).toLocaleString()%>
          </td>
          <td>
            <c:out value="${user.email}"/>
          </td>
          <td>
            <c:out value="${user.password}"/>
          </td>
          <td>
            <c:out value="${user.phoneNumber}"/>
          </td>
          <td>
            <c:out value="${user.phoneNumber}"/>
          </td>
          <td>
            <c:out value="${user.phoneNumber}"/>
          </td>

      </c:forEach>
      <!-- } -->
      </tbody>

    </table>
  </div>
</div>


</body>
</html>
