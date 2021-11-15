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
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
        </ul>
        <form class="navbar-form navbar-left" action="/action_page.php">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search" name="search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</nav>

<div class="container">
    <div class="container">
        <br>

        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${user != null}">

                    <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                        <form action="insert" method="post">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${user != null}">
                                        Edit User
                                    </c:if>
                                    <c:if test="${user == null}">
                                        Add New User
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${user != null}">
                                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                            </c:if>


                            <div>
                                <fieldset class="form-group">
                                    <label>User Name</label> <input type="text" value="<c:out value='${user.name}' />"
                                                                    class="form-control" name="name"
                                                                    required="required">
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>User Email</label> <input type="text" value="<c:out value='${user.email}' />"
                                                                     class="form-control" name="email">
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>User Phone</label> <input type="text" value="<c:out value='${user.phone}' />"
                                                                     class="form-control" name="phone">
                                </fieldset>

                                <button type="submit" class="btn btn-success">Save</button>
                            </div>

                        </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
