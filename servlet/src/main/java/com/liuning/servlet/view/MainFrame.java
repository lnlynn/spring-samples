package com.liuning.servlet.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mainFrame")
public class MainFrame extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainFrame() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
//		//获取登陆名
//		//第一种方法
//		out.println("<h1>主界面</h1>"+myData.name);
//		//第二种方法
//		String username=request.getParameter("uname");
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>武汉大学教务管理系统</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='images/1.GIF'/>");
        out.println("<h1>主界面</h1>");
        out.println("<a href='/loginServlet'>返回重新登陆</a>");
        out.println("<h3>请选择您要进行的操作</h3>");
        out.println("<a href='/manageUsers'>管理用户</a><br/>");
        out.println("<a href=''>添加用户</a><br/>");
        out.println("<a href=''>查找用户</a><br/>");
        out.println("<a href=''>退出系统</a><br/>");

        out.println("<img src='images/mylogo.gif'/>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

