<%--
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
    <title>Registration</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>

<body class="w3-black">

<div align="center">

<div class="w3-container w3-quarter w3-margin-top w3-gray">

    <c:if test="${requestScope.successData!=null}">
        <div class="w3-panel w3-green w3-display-container w3-card-4 w3-round">
                <span onclick="this.parentElement.style.display='none'"
                      class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey" >×</span>
            <h5><c:out value="Success !"/></h5>

        </div>
    </c:if>
    <c:if test="${requestScope.wrongData!=null}">
        <div class="w3-panel w3-green w3-display-container w3-card-4 w3-round">
                <span onclick="this.parentElement.style.display='none'"
                      class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey" >×</span>
            <h5><c:out value="${requestScope.wrongData}"/></h5>

        </div>
    </c:if>
    <c:if test="${requestScope.wrongAge!=null}">
        <div class="w3-panel w3-green w3-display-container w3-card-4 w3-round">
                <span onclick="this.parentElement.style.display='none'"
                      class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey" >×</span>
            <h5><c:out value="${requestScope.wrongAge}"/></h5>

        </div>
    </c:if>

    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Registration</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Mail:
                <input type="text" name="mail" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Password:
                <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Age:
                <input type="number" name="age" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-quarter w3-padding">
    <button class="w3-btn w3-round-large" onclick="history.back()">Previous page</button>
    <button class="w3-btn w3-round-large" onclick="location.href='..'">Back to main</button>
</div>
</div>
</body>
</html>
