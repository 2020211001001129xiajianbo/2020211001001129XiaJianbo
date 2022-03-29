package com._2020211001001129xiajianbo.week5.demo.servlet;

import com._2020211001001129xiajianbo.week5.demo.entity.userEntity;
import com._2020211001001129xiajianbo.week5.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class UserLoginServlet extends HttpServlet {
    UserService userService= new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =req.getParameter("name");
        String pass =req.getParameter("pass");

        userEntity userEntity=new userEntity();
        userEntity.setName(name);
        userEntity.setPass(pass);

        PrintWriter pw=null;

        try {
            pw=resp.getWriter();
            pw.print(userService.login(userEntity));
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            if(pw!=null)
            pw.close();
        }



    }
}
