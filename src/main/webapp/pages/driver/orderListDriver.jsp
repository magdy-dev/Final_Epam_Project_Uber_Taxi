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

  <title>order</title>
  <fmt:bundle basename="page_content">
    <fmt:message key="main.title" var="online"/>
    <fmt:message key="main.id" var="id"/>
    <fmt:message key="main.data" var="data"/>
    <fmt:message key="main.Cname" var="name"/>
    <fmt:message key="main.numberP" var="number"/>
    <fmt:message key="main.from" var="from"/>
    <fmt:message key="main.to" var="to"/>

  </fmt:bundle>
</head>


<body style="background-color: gold">

<tag:userMenu/>

<div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
    <h3 class="text-center">${pageScope.list}</h3>
    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>${pageScope.id}</th>
        <th>${pageScope.data}</th>
        <th>${pageScope.name}</th>
        <th>${pageScope.number}</th>
        <th>${pageScope.from}</th>
        <th>${pageScope.to}</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="ride"  items="${sessionScope.ridesDriverHistory}">
        <tr>
          <td><c:out value="${ride.order.id}"/></td>
          <td><c:out value="${ride.order.data}"/></td>
          <td><c:out value="${ride.order.client.name } / ${ride.order.client.lastName}"/></td>
          <td><c:out value="${ride.order.client.phoneNumber }"/></td>
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
