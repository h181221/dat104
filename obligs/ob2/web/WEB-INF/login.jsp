<%--
  Created by IntelliJ IDEA.
  User: Peder
  Date: 29.09.2017
  Time: 17.04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static no.pederyo.controller.UrlMappings.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<jsp:include page="./partials/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${flash == 'Error'}">
    <p style="color:red;">${melding}</p>
    <c:remove var="flash" scope="session" />
</c:if>
<h3>Logg inn</h3>
<p>Det er kun registrerte deltagere som f�r se deltagerlisten.
    Logg inn ved � gi mobil-nummeret ditt.</p>
<form action=<%=LOGIN%> method="POST">
    <fieldset>
        <p>Mobil: <input type="password" name="mobil" placeholder="90123456" /></p>
        <p><input type="submit" value="Logg inn" /></p>
    </fieldset>
</form>
<a href=<%=PAAMELDING_URL%>>Meld det p� her!</a> &emsp; <a href=<%=LOGGINNKASSERER%>>LoggInnKasserer</a>
<jsp:include page="./partials/footer.jsp"/>
