<%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/15/2021
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body style="background-color: gold">

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav">
            <h4>Taxi</h4>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#section1">sign Out</a></li>
                <li><a href="#section2">List Of Order</a></li>
                <li><a href="#section3">Order Taxi</a></li>
            </ul>
            <br>
        </div>

        <div class="col-sm-9">
            <h1><small>complaint</small></h1>
            <p>Making a complaint about a taxi service<br>
                If you have a problem with a taxi or taxi driver's behavior, or you believe a vehicle to be unlicensed,
                report it immediately. If the problem involves a criminal act, report it to the Police Service
                Complaints
                If you're unhappy with the fare, quality of vehicle, driving, or behavior of the driver or any other
                issue, make your complaint to the driver or the taxi operator.

                Explain in detail what went wrong, stay calm, and stick to the facts.</p>
            <br><br>

            <h4><small>Taxi.....</small></h4>
            <hr>
            <div class="container">
                <ul class="list-group" id="myList">
                    <li class="list-group-item">First Name</li>
                    <li class="list-group-item">Last Name</li>
                    <li class="list-group-item">Email</li>
                    <li class="list-group-item">Password</li>
                    <li class="list-group-item">Phone Number</li>
                </ul>
            </div>
            <hr>

            <h4>Leave a Comment:</h4>
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
