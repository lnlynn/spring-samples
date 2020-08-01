package com.liuning.servlet.controller;

import com.liuning.servlet.model.User;
import com.liuning.servlet.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginSuccessServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //接收用户提交的用户名和密码
        String id=request.getParameter("id");
        String password=request.getParameter("password");

        //创建userService对象，完成到数据库的验证
        UserService userSer=new UserService();
        User user=new User();
        user.setId(Integer.parseInt(id));
        user.setPwd(password);

        if(userSer.checkUser(user)){
            request.getRequestDispatcher("/mainFrame").forward(request, response);
            //response.sendRedirect("/myServlet/mainFrame");
        }else{
            request.setAttribute("err", "用户名或者密码有误！");
            request.getRequestDispatcher("/loginServlet").forward(request, response);
            //response.sendRedirect("/myServlet/loginServlet");
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

