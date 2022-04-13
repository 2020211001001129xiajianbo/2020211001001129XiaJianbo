<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();

%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%@include file="header.jsp"%>

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
--%>
<h2>Welcome to My Online Shop Home Page.</h2>
<%--<form method="get"  action="SearchServlet">
 <input type="text" name="txt" size=30/ >
 <select name="search">
   <option value="baidu">Baidu</option>
   <option value="bing">Bing</option>
   <option value="googLe">Google</option>
   <input type="submit" value="search"/>
 </form>
 </select>--%>
<h1><%="WELCOME TO MY HOME PAGE"%></h1>
<br/>
<a href ="helo-servlet">Hello Servlet</a>
<%@include file="footer.jsp"%>
...
</body>
</html>

