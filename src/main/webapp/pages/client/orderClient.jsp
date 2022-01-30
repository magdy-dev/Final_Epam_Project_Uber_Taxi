<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.magdy.taxiwebappliction.entity.Client" %><%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/13/2021
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <fmt:bundle basename="page_content">
        <fmt:message key="order.client.F_town" var="ftown"/>
        <fmt:message key="order.client.F_street" var="fstreet"/>
        <fmt:message key="order.client.T_town" var="ttown"/>
        <fmt:message key="order.client.T_street" var="tstreet"/>
        <fmt:message key="order.client.book" var="book"/>
        <fmt:message key="order.client.my_order" var="myorder"/>

    </fmt:bundle>

    <title>Title</title>
</head>
<body style="background: gold">
<tag:userMenu/>
<div class="container">
    <div class="container">
        <br>

        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/controller"><c:if
                            test="${sessionScope.message != null}">${sessionScope.message}</c:if>
                        <fieldset class="form-group">
                            <label>${pageScope.ftown}</label> <input type="text" class="form-control" name="from_town"
                                                                     required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>${pageScope.fstreet} </label> <input type="text" class="form-control"
                                                                        name="from_street" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>${pageScope.ttown}</label> <input type="text" class="form-control" name="to_town">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>${pageScope.tstreet}</label> <input type="text" class="form-control"
                                                                       name="to_street">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>cash</label> <input type="checkbox" name="isCash"
                                                       aria-label="Checkbox for following text input">
                        </fieldset>
                        <input type="hidden" name="command" value="requestDriver">

                        <button type="submit" class="btn btn-success">${pageScope.book}</button>
                    </form>
                    <hr class="my-10">
                    <hr class="my-10">
                    <div class="jumbotron">
                        <h1 class="display-4">${pageScope.myorder}</h1>
                        <hr class="my-4">
                        <h3 class="lead">Time: <%= (new java.util.Date()).toLocaleString()%>
                        </h3>
                        <h3 class="lead">Cash:<c:if
                                test="${sessionScope.isCash != null}">${sessionScope.isCash}</c:if></h3>
                        <h3 class="lead">From Where:<c:if
                                test="${sessionScope.from != null}">${sessionScope.from}</c:if></h3>
                        <h3 class="lead">To Where:<c:if test="${sessionScope.to != null}">${sessionScope.to}</c:if></h3>


                        </p>
                    </div>

                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<footer class="container-fluid">
    <p>TAXI</p>
</footer>

</body>
</html>
