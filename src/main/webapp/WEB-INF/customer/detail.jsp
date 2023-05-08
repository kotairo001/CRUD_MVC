<%--
  Created by IntelliJ IDEA.
  User: My PC
  Date: 5/8/2023
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Customer Detail</h1>
<table border="1" style="width: 100%">
    <tr>
        <th>No.</th>
        <th>NAME</th>
        <th>EMAIl</th>
        <th>ADDRESS</th>
    </tr>
    <tr>
        <td>${requestScope["customerDetail"].getId()}</td>
        <td>${requestScope["customerDetail"].getName()}</td>
        <td>${requestScope["customerDetail"].getEmail()}</td>
        <td>${requestScope["customerDetail"].getAddress()}</td>
    </tr>
</table>
</body>
</html>
