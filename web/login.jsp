<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: bobo
  Date: 2022/3/29
  Time: 7:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
Login. <br>
<%
    if((request.getAttribute("message") != null)) {
        PrintWriter ps = response.getWriter();
        out.println("<h3>" + request.getAttribute("message") + "</h3>");
    }
%>
<form action="login" method="post">
    <table border="1">
        <tr>
        <td>账号：</td>
        <td><input type="text"  name="act"/> </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
            <input type="submit" value="Login"></td>
        </tr>
    </table>
</form>


    <%@include file="footer.jsp"%>
