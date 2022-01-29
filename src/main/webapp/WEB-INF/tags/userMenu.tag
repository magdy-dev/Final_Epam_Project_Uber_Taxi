<%@ tag import="com.magdy.taxiwebappliction.entity.Client" %>
<%@ tag import="com.magdy.taxiwebappliction.entity.Driver" %>
<%@ tag import="com.magdy.taxiwebappliction.entity.Owner" %>
<%@tag pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<header class="header">
    <fmt:bundle basename="page_content">
        <fmt:message key="main.home" var="homes"/>
        <fmt:message key="main.about" var="ab"/>
        <fmt:message key="main.list" var="listd"/>
        <fmt:message key="main.listO" var="listo"/>
        <fmt:message key="main.profil" var="profil"/>
        <fmt:message key="main.listC" var="listC"/>
        <fmt:message key="main.listD" var="listD"/>
        <fmt:message key="main.Logout" var="logout"/>


    </fmt:bundle>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <nav class="navbar navbar-inverse">
        <%
            Client client = (Client) session.getAttribute("client");
            Driver driver = (Driver) session.getAttribute("driver");
            Owner owner = (Owner) session.getAttribute("owner");
            if (null == client && null == driver && owner == null) {
                session.setAttribute("errorMessage", "Login Failed ");
                response.sendRedirect("/taxiwebappliction/index.jsp");
            }
        %>
        <c:if test="${ sessionScope.client != null || sessionScope.driver != null || sessionScope.owner != null}">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <c:choose>
                        <c:when test="${sessionScope.client != null }">
                            <li><a
                                    href="${pageContext.request.contextPath}/pages/common/about.jsp">${pageScope.ab}</a>
                            </li>
                            <li><a
                                    href="${pageContext.request.contextPath}/pages/client/orderClient.jsp">${pageScope.homes}</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/controller?command=reloadClientHistory">${pageScope.listo}</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/pages/client/profileClient.jsp">My
                                Profile</a></li>
                        </c:when>
                        <c:when test="${sessionScope.driver != null}">
                            <li><a
                                    href="${pageContext.request.contextPath}/pages/driver/ordersDriver.jsp">${pageScope.homes}</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/controller?command=reloadDriverHistory">${pageScope.listd}</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/pages/driver/profileDriver.jsp">${pageScope.profil}</a>
                            </li>
                        </c:when>
                        <c:when test="${sessionScope.owner != null}">
                            <li><a
                                    href="${pageContext.request.contextPath}/pages/owner/ownerHomePage.jsp">${pageScope.listC}</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/pages/owner/ownerDriverList.jsp">${pageScope.listD}</a>
                            </li>

                        </c:when>
                    </c:choose>
                    <li><a href="${pageContext.request.contextPath}/controller?command=logout">${pageScope.logout}</a>
                    </li>
                </ul>
            </div>
        </c:if>
        <div class="change_level">
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=common_change_language&locale=ru">RU</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=common_change_language&locale=by">BY</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=common_change_language&locale=en">EN</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
