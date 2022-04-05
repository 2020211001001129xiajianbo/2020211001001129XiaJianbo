<%--
  Created by IntelliJ IDEA.
  User: bobo
  Date: 2022/3/23
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path=request.getContextPath();

%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--<%@include file="header.jsp"%>

  <%--<hi><%="Welcome to my home page"%></hi>
  <br/>
  <a href="hello-servlet">Hello Servlet-week1</a>
  <br/>
  <a href="hello">Student Info Servlet-week2</a>
  <br/>
  <a href="life">Life Cycle Servlet-week3</a>
  <br/>
  <a href="register.jsp">Register-getParameter-week3</a>
  <br/>
  <a href="config">Config parameter-week4</a>
  <br/>
  <a href="register.jsp">HRegister JDBC -week4</a>
  <br/>
  <a href="index.jsp">include-week5</a>
  <br/>
  <a href="login.jsp">Login-week5</a>
  <%@include file="footer.jsp"%>--%>
  <h2>Welcome to My Online Shop Home Page.</h2>
  <form method="get"  action="SearchServlet">
  <input type="text" name="txt" size=30/ >
  <select name="search">
    <option value="baidu">Baidu</option>
    <option value="bing">Bing</option>
    <option value="googLe">Google</option>
  </select>
  <input type="submit" value="search"/>
  </form>

  </body>
</html>
