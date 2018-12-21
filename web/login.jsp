<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 19.12.18
  Time: 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinema</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-center">       <!-- content -->

    <div class="w3-bar w3-padding-large w3-padding-24">
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Mail:
                <input type="text" name="mail" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Password:
                <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Login</button>
        </form>

    </div>
</div>
</body>
</html>
