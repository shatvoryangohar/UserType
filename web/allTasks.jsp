<%@ page import="java.util.List" %>
<%@ page import="model.Task" %><%--
  Created by IntelliJ IDEA.
  User: Gohar
  Date: 16.02.2022
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllTasks</title>
</head>
<body>
<%
    List<Task> allTasks = (List<Task>) request.getAttribute("allTasks");
%>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>status</th>
        <th>deadline</th>
        <th>user_id</th>

    </tr>

    <%
        for (Task task : allTasks) {%>

    <tr>
        <td><%=task.getId()%>
        </td>
        <td><%=task.getName()%>
        </td>
        <td><%=task.getDescription()%>
        </td>
        <td><%=task.getStatus()%>
        </td>
        <td><%=task.getDeadLine()%>
        </td>
        <td><%=task.getUserId()%>
        </td>


    </tr>

    <%
        }
    %>


</table>


</body>
</html>
