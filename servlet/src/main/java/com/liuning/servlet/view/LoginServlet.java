package com.liuning.servlet.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();

        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='images/1.GIF'/>");
        out.println("<h3>用户登陆</h3>");
        out.println("<form action='/loginSuccessServlet' method='post'>");
        out.println("用户id：<input type='text' name='id'/><br/>");
        out.println("密&nbsp&nbsp&nbsp码：<input type='password' name='password'/><br/>");
        out.println("<input type='submit' value='登陆'/><br/>");
        out.println("</form>");
        out.println("<img src='images/mylogo.gif'/>");
        out.println("</body>");
        out.println("</html>");

        if((String)request.getAttribute("err")!=null){
            out.println(request.getAttribute("err").toString());
        }

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
