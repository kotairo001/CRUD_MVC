<%--
  Created by IntelliJ IDEA.
  User: My PC
  Date: 5/8/2023
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Edit Customer</h1>
<form method="post">
    <table border="1" style="width: 100%">
        <tr>
            <th>NAME</th>
            <th>EMAIl</th>
            <th>ADDRESS</th>
        </tr>
        <tr>
            <td><input style="width: 100%; border: none" type="text" value="${requestScope["editCustomer"].getName()}"
                       name="editName"/></td>
            <td><input style="width: 100%; border: none" type="text" value="${requestScope["editCustomer"].getEmail()}"
                       name="editEmail"/></td>
            <td><input style="width: 100%; border: none" type="text"
                       value="${requestScope["editCustomer"].getAddress()}" name="editAddress"/></td>
        </tr>
    </table>
    <button type="submit">Edit</button>
</form>
</body>
</html>
