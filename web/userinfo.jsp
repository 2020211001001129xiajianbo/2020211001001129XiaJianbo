<%--
  Created by IntelliJ IDEA.
  User: bobo
  Date: 2022/4/5
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table border="1" align="center">
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>Email:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>Gender:</td><td><%=request.getAttribute("gender")%></td></tr>
    <tr><td>Birthdate:</td><td><%=request.getAttribute("Birthdate")%></td></tr>
</table>
<%--</div>--%>
<%@include file="footer.jsp"%>