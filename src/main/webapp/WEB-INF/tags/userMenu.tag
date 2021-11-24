<%@ tag import="com.magdy.taxiwebappliction.entity.Client" %>
<%@ tag import="com.magdy.taxiwebappliction.entity.Driver" %>
<%@tag pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>


<header class="header">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <nav class="navbar navbar-inverse">
        <%
            Client client = (Client) session.getAttribute("client");
            Driver driver = (Driver) session.getAttribute("driver");
            if (null == client && null == driver) {
                session.setAttribute("errorMessage", "Login Failed ");
                response.sendRedirect("/taxiwebappliction/index.jsp");
            }
        %>
        <c:if test="${ sessionScope.client != null || sessionScope.driver != null}">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <c:choose>
                        <c:when test="${sessionScope.client != null }">
                            <li ><a
                                    href="${pageContext.request.contextPath}/pages/common/about.jsp">About</a></li>
                            <li ><a
                                    href="${pageContext.request.contextPath}/pages/client/orderClient.jsp">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/controller?command=reloadClientHistory">Order Lise
                                History</a></li>
                            <li><a href="${pageContext.request.contextPath}/pages/client/profileClient.jsp">My
                                Profile</a></li>
                        </c:when>
                        <c:when test="${sessionScope.driver != null}">
                            <li ><a
                                    href="${pageContext.request.contextPath}/pages/driver/ordersDriver.jsp">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/controller?command=reloadDriverHistory">Order Lise
                                History</a></li>
                            <li><a href="${pageContext.request.contextPath}/pages/driver/profileDriver.jsp">My
                                Profile</a></li>
                        </c:when>
                    </c:choose>
                    <li><a href="${pageContext.request.contextPath}/controller?command=logout">Logout</a></li>
                </ul>
            </div>
        </c:if>
    </nav>
</header>
