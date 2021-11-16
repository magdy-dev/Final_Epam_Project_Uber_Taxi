<%--
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
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Taxi...</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Sign Out</a></li>
            <li><a href="orderListClient.jsp">Order Lise History</a></li>
            <li><a href="profileClient.jsp">My Profile</a></li>
        </ul>

    </div>
</nav>

<div class="container">
    <div class="container">
        <br>

        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">


                    <div>
                        <fieldset class="form-group">
                            <label>From where</label> <input type="text" value="<c:out value='${user.name}' />"
                                                             class="form-control" name="name"
                                                             required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>To Where</label> <input type="text" value="<c:out value='${user.email}' />"
                                                           class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Time </label> <input type="text" value="<c:out value='${user.phone}' />"
                                                        class="form-control" name="phone">
                        </fieldset>


                        </fieldset>
                        <fieldset class="form-group">
                            <label>cash</label> <input type="checkbox"
                                                       aria-label="Checkbox for following text input">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Book</button>
                    </div>
                    <hr class="my-10">
                    <hr class="my-10">
                    <div class="jumbotron">
                        <h1 class="display-4">My Order</h1>
                        <h3 class="lead">Price:</h3>
                        <hr class="my-4">
                        <h3 class="lead">Time:</h3>
                        <h3 class="lead">Cash:</h3>
                        <h3 class="lead">From Where:</h3>
                        <h3 class="lead">To Where:</h3>


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
