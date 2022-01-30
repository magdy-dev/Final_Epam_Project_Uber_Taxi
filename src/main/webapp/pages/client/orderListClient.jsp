<%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/14/2021
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <fmt:bundle basename="page_content">
        <fmt:message key="order.client.list" var="orderL"/>
        <fmt:message key="order.client.list.id" var="id"/>
        <fmt:message key="order.client.list.data" var="data"/>
        <fmt:message key="order.client.list.d_Id" var="driverId"/>
        <fmt:message key="order.client.list.d_Name" var="driverName"/>
        <fmt:message key="order.client.list.d_Phone" var="driverPhone"/>
        <fmt:message key="order.client.list.d_CarNumber" var="driverCarNumber"/>
        <fmt:message key="order.client.list.from" var="from"/>
        <fmt:message key="order.client.list.to" var="to"/>
    </fmt:bundle>
    <title>order</title>
</head>
<body style="background-color: gold">

<tag:userMenu/>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">${pageScope.orderL}</h3>

        <br>
        <table class="table table-bordered" action="${pageContext.request.contextPath}/controller">
            <thead>
            <tr>
                <th>${pageScope.id}</th>
                <th>${pageScope.data}</th>
                <th>${pageScope.driverId}</th>
                <th>${pageScope.driverName}</th>
                <th>${pageScope.driverPhone}</th>
                <th>${pageScope.driverCarNumber}</th>
                <th>${pageScope.from}</th>
                <th>${pageScope.to}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ride" items="${sessionScope.ridesClientHistory}">
                <tr>
                    <td><c:out value="${ride.order.id}"/></td>
                    <td><c:out value="${ride.order.data}"/></td>
                    <td><c:out value="${ride.order.driver.id}"/></td>
                    <td><c:out value="${ride.order.driver.name } / ${ride.order.driver.lastName}"/></td>
                    <td><c:out value="${ride.order.driver.phoneNumber }"/></td>
                    <td><c:out value="${ride.order.driver.carNumber }"/></td>
                    <td><c:out value="${ride.addressFrom.town } / ${ride.addressFrom.street}"/></td>
                    <td><c:out value="${ride.addressTo.town  } / ${ride.addressTo.street}"/></td>
                </tr>

            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
