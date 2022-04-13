package com._2020211001001129xiajianbo.week5.demo.servlet;

import com.Xiajianbo.Dao.UserDao;
import com.Xiajianbo.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet" ,value = "/login")
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
            //System.out.println("666666");
        }
        catch (Exception e){
            e.printStackTrace();
           // System.out.println("Game Over");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(req, resp);
        request.getRequestDispatcher("WEB-INF/views/login.jsp" ).forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            String sql = "select * from userdb where username = '"+username+
                    "' and password = '"+password+"'";
            ResultSet stm = con.createStatement().executeQuery(sql);
            if(stm.next()){
                request.setAttribute("username",stm.getString("username"));
                request.setAttribute("password",stm.getString("password"));
                request.setAttribute("email",stm.getString("email"));
                request.setAttribute("gender",stm.getString("gender"));
                request.setAttribute("Birthdate",stm.getString("Birthdate"));
                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
            }
            else {
                request.setAttribute("message","Username or Password Error");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }

//            Statement stmt = con.createStatement();
//            ResultSet selected = stmt.executeQuery("select username,password from HeZhihaotable");
//            boolean ave = false;
//            PrintWriter writer = resp.getWriter();
//            while(selected.next()){
//
//                String use = selected.getString("username");
//                String pas = selected.getString("password");
//
//
//                System.out.println(username+"  zz  "+use);
//                System.out.println(password+"  zzz  "+pas);
//                if(Objects.equals(username, use) && Objects.equals(pas, password)){
//                    writer.println("Congratulations! </br>");
//                    writer.println("Welcome! " + username +"</br>");
//                    ave = true;
//                    writer.println("<a href=\"ConfigDemoServlet\">check</a>");
//                    break;
//                }
//            }
//            if(!ave){
//                writer.println("Login fail");
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
       String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }
            else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}