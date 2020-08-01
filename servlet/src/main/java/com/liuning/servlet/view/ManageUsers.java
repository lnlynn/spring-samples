package com.liuning.servlet.view;

import com.liuning.servlet.model.User;
import com.liuning.servlet.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/manageUsers")
public class ManageUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ManageUsers() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //定义分页需要的变量
        int pageNow = 1;//当前页
        final int pageSize = 5;//指定每页显示3条记录
        int pageCount = 1;

        //接收用户的pageNow
        String spageNow = request.getParameter("pageNow");
        if(spageNow!=null){
            pageNow = Integer.parseInt(spageNow);
        }
        try {
            UserService us=new UserService();
            //算出共有多少页
            pageCount = us.getPageCount(pageSize);
            //得到每一个数据
            ArrayList<User> userList=us.getUsersByPage(pageNow, pageSize);

            out.println("<!DOCTYPE HTML>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<title>武汉大学教务系统</title>");
            out.println("<script type='text/javascript' language='javascript'>");
            out.println("function gotopageNow(){ var pageNow=document.getElementById('pageNow');"
                    + "window.open('/manageUsers?pageNow='+pageNow.value,'_self');"
                    + " }");
            out.println("");
            out.println("");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>管理用户</h1>");
            out.println("<img src='images/1.GIF'/>");
            out.println("<table border=1 bordercolor=green width=500px cellspacing=0>");
            out.println("<tr><th>id</th><th>用户名</th><th>email</th><th>级别</th><th>删除用户</th><th>更改用户</th></tr>");
            for(User u:userList){
                out.println("<tr>"
                        + "<td>"+u.getId()	  +"</td>"
                        + "<td>"+u.getName()  +"</td>"
                        + "<td>"+u.getEmail() +"</td>"
                        + "<td>"+u.getGrade() +"</td>"
                        + "<td><a href='/deleteServlet?id='>删除用户</a></td>"
                        + "<td><a href='/changeServlet?id='>更改用户</a></td>"
                        + "</tr>");
            }

            out.println("</table>");
            //显示分页
            if(pageNow!=1){
                out.println("<a href='/manageUsers?pageNow="+(pageNow-1)+"'>上一页</a>");
            }
            for(int i=1;i<=pageCount;i++){
                out.println("<a href='/manageUsers?pageNow="+i+"'><"+i+"></a>");
            }
            if(pageNow!=pageCount){
                out.println("<a href='/manageUsers?pageNow="+(pageNow+1)+"'>下一页</a>");
            }

            //显示分页信息
            out.println("<b>&nbsp;&nbsp;&nbsp;&nbsp;当前页"+pageNow+"/总页数"+pageCount+"</b><br/>");
            out.println("跳转到<input type='text' id='pageNow' name='pageNow'/><input type='button' onclick='gotopageNow()' value='确定'/>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
