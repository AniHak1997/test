<%@ page import="am.basic.jdbcStart.model.User" %>
<%@ page import="static am.basic.jdbcStart.util.constants.ParameterKeys.USER_ATTRIBUTE_KEY" %><%--
  Created by IntelliJ IDEA.
  User: Comp
  Date: 05.06.2020
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) session.getAttribute(USER_ATTRIBUTE_KEY);
%>

<form method="post" action="/note">
    <input type="hidden" name="username" value="<%=user.getUsername()%>">
    <textarea placeholder="write your text here" type="text" name="note"></textarea>
    <input type="submit" name="submit" value="Resend code"><br>
</form>


</body>
</html>
