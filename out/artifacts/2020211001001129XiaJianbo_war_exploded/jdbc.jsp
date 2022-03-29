<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: bobo
  Date: 2022/3/29
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        out.println("登录");
        String username=new String(request.getParameter("username").getBytes("ISO8859_1"),"GBK");
        String password=new String(request.getParameter("password").getBytes("ISO8859_1"),"GBK");
        try {
            // 加载数据库驱动，注册到驱动管理器
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 数据库连接字符串
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=userdb;encrypt=false";
            // 数据库用户名
            String usename = "sa";
            // 数据库密码
            String psw = "123";
            // 创建Connection连接
            Connection conn = DriverManager.getConnection(url,usename,psw);
            // 判断 数据库连接是否为空
            if(conn != null){
                String sql="select * from user where username='"+username+"' and password='"+ password + "'";
                ResultSet rs;
                try (Statement stmt = conn.createStatement()) {
                    rs = stmt.executeQuery(sql);
                }
                if(rs.next()){
                    response.sendRedirect("success.jsp");
                }else{
                    out.print("用户名或密码错误，请重新输入！");
    %>
   <a href="javascript:history.back()">返回</a>
    <%
                }
                // 输出连接信息
                //out.println("数据库连接成功！");
                // 关闭数据库连接
                conn.close();
            }else{
                // 输出连接信息
                out.println("数据库连接失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
