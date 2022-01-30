<%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/15/2021
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .row.content {
            height: 1500px
        }

        {
            background-color: #f1f1f1
        ;
            height: 100%
        ;
        }
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        @media screen and (max-width: 767px) { {
            height: auto;
            padding: 15px;
        }

            .row.content {
                height: auto;
            }
        }
    </style>
    <fmt:bundle basename="page_content">
        <fmt:message key="order.client.profile.complaint" var="complaint"/>
        <fmt:message key="order.client.profile.taxi" var="taxi"/>
        <fmt:message key="order.client.profile.txt" var="txt"/>
        <fmt:message key="order.client.profile.name" var="name"/>
        <fmt:message key="order.client.profile.L_name" var="lname"/>
        <fmt:message key="order.client.profile.email" var="email"/>
        <fmt:message key="order.client.profile.password" var="passw"/>
        <fmt:message key="order.client.profile.phone" var="phone"/>
        <fmt:message key="order.client.profile.welcome" var="welcome"/>
        <fmt:message key="order.client.profile.taxiM" var="txim"/>
        <fmt:message key="order.client.profile.wish" var="wish"/>

    </fmt:bundle>
</head>
<body style="background-color: gold">

<div class="container-fluid">
    <div class="row content">
        <tag:userMenu/>

        <div class="col-sm-9">
            <h1><small>${pageScope.complaint}</small></h1>
            <p>${pageScope.taxi}<br>
                ${pageScope.txt}</p>
            <br><br>

            <h4><small>Taxi.....</small></h4>
            <hr>
            <div class="container" action="${pageContext.request.contextPath}/controller">
                <ul class="list-group" id="myList">
                    <li class="list-group-item">${pageScope.nam} :${sessionScope.client.name}</li>
                    <li class="list-group-item">${pageScope.lname} :${sessionScope.client.lastName}</li>
                    <li class="list-group-item">${pageScope.email} :${sessionScope.client.email}</li>
                    <li class="list-group-item">${pageScope.passw} :${sessionScope.client.password}</li>
                    <li class="list-group-item">${pageScope.phone}:${sessionScope.client.phoneNumber}</li>
                </ul>
            </div>
            <hr>

            <h4>${pageScope.welcome}:</h4>
            <form role="form">

                <div class="container">
                    <h2>${pageScope.txiM}</h2>
                    <p>${pageScope.wish} </p>

                    <div class="row">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <a>
                                    <img src="${pageContext.request.contextPath}/img/pexels-photo-5746988.jpeg"
                                         alt="Lights" style="width:100%">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <a>
                                    <img src="${pageContext.request.contextPath}/img/pexels-photo-70441.jpeg"
                                         alt="Nature" style="width:100%">

                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <a>
                                    <img src="${pageContext.request.contextPath}/img/photo-1597462658709-b2616ae8f2ce.jpg"
                                         alt="Nature" style="width:100%">

                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        </div>
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
