<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 28.08.2017
  Time: 23.33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>vis resultat</title>
</head>
<body>
    <%

        if((boolean)request.getAttribute("gyldig") && request.getAttribute("tempVal").equals("celsius")) {
    %>      <p>${tempen} &#8451; = ${omregning} &#8457; </p><%
        }else if((boolean)request.getAttribute("gyldig") && request.getAttribute("tempVal").equals("fahrenheit")){
    %>      <<p>${tempen} &#8457; = ${omregning} &#8451; </p> <%
        }else {
            %> <p>du har søkt feil</p><%
        }
    %>

</body>
</html>
