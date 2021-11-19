<%@ page import="com.magdy.taxiwebappliction.entity.Driver" %><%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/13/2021
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


    <title>Title</title>
</head>
<body style="background: gold">

<nav class="navbar navbar-inverse">
    <%
        Driver driver = (Driver) session.getAttribute("driver");
        if (null == driver) {
            session.setAttribute("errorMessage", "Login Failed ");
            response.sendRedirect("/taxiwebappliction/index.jsp");
        }
    %>
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Taxi...</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="">Sign Out</a></li>
            <li><a href=profileDriver.jsp>Go To My Profile</a></li>
            <li><a href="orderListDriver.jsp">Order List History</a></li>

        </ul>

    </div>
</nav>


<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">All Clients Orders</h3>

        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>From where</th>
                <th>To Where</th>

                <th>Time</th>
                <th>Cash</th>
                <th>Price</th>
                <th>Action</th>

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
                        <c:out value="${user.name}"/>
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
                    </td>
                    <td><a href="edit?id=<c:out value='${user.id}' />">Accept</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="delete?id=<c:out value='${user.id}' />">Cancel</a></td>
                </tr>

            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>

</body>
</html>
