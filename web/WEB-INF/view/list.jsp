<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 05.12.18
  Time: 5:17
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users list</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Users</h2>
        </div>



        <c:if test="${requestScope.user != null && !requestScope.user.isEmpty()}">
            <ul class="w3-ul">
                <c:forEach var="mail" items="${requestScope.user}">
                    <li class="w3-hover-sand"><c:out value="${mail}"></c:out></li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${requestScope.user == null || requestScope.user.isEmpty()}">
            <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
            <span onclick="this.parentElement.style.display='none'"
                  class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
                <h5>There are no users yet!</h5>
            </div>
        </c:if>



    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="history.back()">Previous page</button>
    <button class="w3-btn w3-round-large" onclick="location.href='..'">Back to main</button>
</div>
</body>
</html>
