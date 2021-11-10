
<%@ page import ="java.util.*" %>
<%@ page import="javax.naming.ldap.Control" %>
<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Available Brands
    </h1>
        <%
        // its make web not allowed to go back  for the page after u make logout
        response.setHeader("Cache-Control","no-cache,no-stone,must-revalidate");

List result= (List) request.getAttribute("brands");
Iterator it = result.iterator();
out.println("<br>We have <br><br>");
while(it.hasNext()){
out.println(it.next()+"<br>");
}
%>
</body>
</html>
