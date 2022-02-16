<%@ page import="model.Task" %><% Task task = new Task(); %><%--
  Created by IntelliJ IDEA.
  User: Gohar
  Date: 14.02.2022
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add User</title>
</head>
<body>
Add User:
<form action="/addUser" method="post">
    name:<input type="text" name="name"><br>
    surname:<input type="text" name="surname"><br>
    email:<input type="email" name="email"><br>
    password:<input type="password" name="password"><br>
    user Type:<select name="user_type">
    <option value="USER">USER</option>
    <option value="MANAGER">MANAGER</option>
</select><br>
    <input type="submit" value="ok">
</form>


Add Task:
<form action="/addTask" method="post">
    name: <input type="text" name="name"><br>
    description:<input type="text" name="description"><br>
    deadline:<input type="date" name="deadline"><br>
    userid:<input type="text" name="user_id"><br>
    status: <select name="status">
    <option value="TODO">TODO</option>
    <option value="IN_PROGRESS">IN_PROGRESS</option>
    <option value="DONE">DONE</option>
</select><br>
    <input type="submit" value="ok">

</form>


</body>
</html>
