<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: magdy
  Date: 11/19/2021
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:bundle basename="page_content">
        <fmt:message key="common.about.welcome" var="welcome"/>
        <fmt:message key="common.about.save" var="save"/>
        <fmt:message key="common.about.world" var="world"/>
        <fmt:message key="common.about.why" var="why"/>
        <fmt:message key="common.about.if" var="if"/>
        <fmt:message key="common.about.it" var="it"/>
        <fmt:message key="common.about.is" var="is"/>

        <fmt:message key="common.about.tit1" var="tit1"/>
        <fmt:message key="common.about.txt1" var="txt1"/>

        <fmt:message key="common.about.tit2" var="tit2"/>
        <fmt:message key="common.about.txt2" var="txt2"/>
        <fmt:message key="common.about.tit3" var="tit3"/>


        <fmt:message key="common.about.txt3" var="txt3"/>
        <fmt:message key="common.about.tit4" var="tit4"/>
        <fmt:message key="common.about.txt4" var="txt4"/>




    </fmt:bundle>
    <title>about</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background: gold">


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="https://training.by/">Epam</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/pages/client/profileClient.jsp">Profile </a></li>
        </ul>
    </div>
</nav>


<div class="container">
    <h1>${pageScope.welcome} </h1>
    <div class="progress">
        <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"
             style="width:70%">
            70%
        </div>
    </div>


    <h3><h1>${pageScope.save}</h1><br><h4>

       ${pageScope.world}</h4>

        <h1>${pageScope.why}</h1><br><h4>
            ${pageScope.if}
        </h4>
        <h1>${pageScope.it}:</h1><br>
        <h4>
           ${pageScope.is}
        </h4>
        <h1>${pageScope.tit1}</h1><br>
        <h4>
            ${pageScope.txt1}
        </h4>
        <h1> ${pageScope.tit2}</h1><br>
        <h4>
           ${pageScope.txt2}
        </h4>
        <h1>${pageScope.tit3}</h1><br>
        <h4>
           ${pageScope.txt3}
        </h4>
        <h1>${tit4}</h1><br>
        <h4>
           <h3>${pageScope.txt4}</h3>
    </h4>
</div>

</body>
</html>