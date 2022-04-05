package com._2020211001001129xiajianbo.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String txt = request.getParameter("txt");
        String select = request.getParameter("search");
        if(txt == ""){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else {
            if(select.equals("baidu")) response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            else
                if(Objects.equals(select,"bing")) response.sendRedirect("https://cn.bing.com/search?q="+txt);
            else
                if(select == "google") response.sendRedirect("https://www.google.com/search?q="+txt);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        doGet(request,response);
    }
}