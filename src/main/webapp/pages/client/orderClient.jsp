<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.magdy.taxiwebappliction.entity.Client" %><%--
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
        Client client = (Client) session.getAttribute("client");
        if (null == client) {
            session.setAttribute("errorMessage", "Login Failed ");
            response.sendRedirect("/taxiwebappliction/index.jsp");
        }
    %>
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Taxi...</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="orderListClient.jsp">Order Lise History</a></li>
            <li><a href="profileClient.jsp">My Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=logout">Logout</a></li>
        </ul>

    </div>
</nav>

<div class="container">
    <div class="container">
        <br>

        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/controller">
                        <c:if test="${sessionScope.message != null}">
                            ${sessionScope.message}
                        </c:if>
                        <fieldset class="form-group">
                            <label>From where town</label> <input type="text" class="form-control" name="from_town"
                                                             required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>From where street </label> <input type="text" class="form-control" name="from_street"
                                                             required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>To Where town</label> <input type="text" class="form-control" name="to_town">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>To Where street</label> <input type="text" class="form-control" name="to_street">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>cash</label> <input type="checkbox" name="isCash" aria-label="Checkbox for following text input">
                        </fieldset>
                        <input type="hidden" name="command" value="requestDriver">

                        <button type="submit" class="btn btn-success">Book</button>
                    </form>
                    <hr class="my-10">
                    <hr class="my-10">
                    <div class="jumbotron">
                        <h1 class="display-4">My Order</h1>
                        <hr class="my-4">
                        <h3 class="lead">Time: <%= (new java.util.Date()).toLocaleString()%>
                        </h3>
                        <h3 class="lead">Cash:
                            <c:if test="${sessionScope.isCash != null}">
                                ${sessionScope.isCash}
                            </c:if></h3>
                        <h3 class="lead">From Where:
                            <c:if test="${sessionScope.from != null}">
                                ${sessionScope.from}
                            </c:if></h3>
                        <h3 class="lead">To Where:
                            <c:if test="${sessionScope.to != null}">
                                ${sessionScope.to}
                            </c:if></h3>


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
