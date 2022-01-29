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
        /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
        .row.content {
            height: 1500px
        }

        /* Set gray background color and 100% height */
        .sidenav {
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }

            .row.content {
                height: auto;
            }
        }
    </style>
    <title>Title</title>
    <fmt:bundle basename="page_content">
        <fmt:message key="D_profile.taxi" var="taxi"/>
        <fmt:message key="D_profile.bec" var="bec"/>
        <fmt:message key="D_profile.txt" var="txt"/>
        <fmt:message key="D_profile.name" var="name"/>
        <fmt:message key="D_profile.Last_name" var="lname"/>
        <fmt:message key="D_profile.email" var="email"/>
        <fmt:message key="D_profile.password" var="password"/>
        <fmt:message key="D_profile.Phone_numbr" var="number"/>
        <fmt:message key="D_profile.Car_number" var="Carnumber"/>




    </fmt:bundle>
</head>
<body style="background-color: gold">

<div class="container-fluid">
    <div class="row content">
        <tag:userMenu/>

        <div class="col-sm-9">
            <h1><small>${pageScope.taxi}</small></h1>
            <p> ${pageScope.bec}<br>${pageScope.txt}
            </p>
            <br><br>

            <h4><small>Taxi.....</small></h4>
            <hr>
            <div class="container" action="${pageContext.request.contextPath}/controller">
                <ul class="list-group" id="myList">
                    <li class="list-group-item">${pageScope.name}   : ${sessionScope.driver.name}</li>
                    <li class="list-group-item">${pageScope.lname}   : ${sessionScope.driver.lastName}</li>
                    <li class="list-group-item">${pageScope.email}       : ${sessionScope.driver.email}</li>
                    <li class="list-group-item">${pageScope.password}     : ${sessionScope.driver.password}</li>
                    <li class="list-group-item">${pageScope.number} : ${sessionScope.driver.phoneNumber}</li>
                    <li class="list-group-item">${pageScope.Carnumber}   : ${sessionScope.driver.carNumber}</li>
                </ul>
            </div>
            <hr>

            <h4>......................:</h4>
            <form role="form">
                <div class="form-group">
                    <textarea class="form-control" rows="7" required></textarea>

                </div>
                <button type="submit" class="btn btn-success">Submit</button>
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
