<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 19.12.18
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin menu</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-center">       <!-- content -->
    <div class="w3-bar w3-padding-large w3-padding-24">    <!-- buttons holder -->
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/list'">List users</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/add'">Add user</button>
        <button class="w3-btn w3-hover-red w3-round-large" onclick="location.href='/delete'">Delete user</button>
        <button class="w3-btn w3-hover-light-gray w3-round-large" onclick="location.href='/update'">Update user</button>
    </div>
</div>
</body>
</html>
