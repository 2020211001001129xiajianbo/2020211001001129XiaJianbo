package com._2020211001001129xiajianbo.week5.demo.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig config=getServletConfig();
        String driver =config.getInitParameter("driver");
        String url =config.getInitParameter("url");
        String username= config.getInitParameter("username");
        String password =config.getInitParameter("password");
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("666666");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Game Over");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            String sql = "select * from userdb where username = '"+username+
                    "' and password = '"+password+"'";
            ResultSet stm = con.createStatement().executeQuery(sql);
            if(stm.next()){
                req.setAttribute("username",stm.getString("username"));
                req.setAttribute("password",stm.getString("password"));
                req.setAttribute("email",stm.getString("email"));
                req.setAttribute("gender",stm.getString("gender"));
                req.setAttribute("Birthdate",stm.getString("Birthdate"));
                req.getRequestDispatcher("userinfo.jsp").forward(req,resp);
            }
            else {
                req.setAttribute("message","Username or Password Error");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

//            Statement stmt = con.createStatement();
//            ResultSet selected = stmt.executeQuery("select username,password from HeZhihaotable");
//            boolean ave = false;
//            PrintWriter writer = resp.getWriter();
//            while(selected.next()){
//
//                String use = selected.getString("username");
//                String pas = selected.getString("password");
//                System.out.println(username+"  hhhhlou11111  "+use);
//                System.out.println(password+"  hhhhlou22222  "+pas);
//                if(Objects.equals(username, use) && Objects.equals(pas, password)){
//                    writer.println("Congratulations! </br>");
//                    writer.println("Welcome! " + username +"</br>");
//                    ave = true;
//                    writer.println("<a href=\"ConfigDemoServlet\">check</a>");
//                    break;
//                }
//            }
//            if(!ave){
//                writer.println("Sorry!!!Login fail!!");
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}