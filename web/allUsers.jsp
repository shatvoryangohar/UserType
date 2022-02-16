<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Gohar
  Date: 15.02.2022
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllUsers</title>
</head>
<body>
<%
    List<User> allUsers = (List<User>) request.getAttribute("allUsers");

%>

All Users:
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>user Type</th>
    </tr>
    <%
        for (User user : allUsers) {%>
    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getSurname()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td><%=user.getType()%>
        </td>


    </tr>
    <% }
    %>


</table>


</body>
</html>
