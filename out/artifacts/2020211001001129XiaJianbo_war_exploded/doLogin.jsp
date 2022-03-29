<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: bobo
  Date: 2022/3/30
  Time: 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username=request.getParameter("act");
    String password=request.getParameter("pwd");
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
        Statement stmt = conn.createStatement();
        // 判断 数据库连接是否为空
        if(conn != null){
            String sql="select * from sys_user where name='"+username+"' and pass='"+ password + "'";
            ResultSet rs = null;
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(rs.next()){
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else{
                out.print("用户名或密码错误，请重新输入！");
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
