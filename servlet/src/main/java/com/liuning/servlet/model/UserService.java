package com.liuning.servlet.model;

import com.liuning.servlet.utils.SqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {

    //获取paeCount
    public int getPageCount(int pageSize){
        int rowCount = 0;
        String sql = "select count(*) from users";

        ResultSet rs = SqlHelper.executeQuery(sql, null);
        try {
            rs.next();
            rowCount = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SqlHelper.close();
        }
        return rowCount % pageSize == 0 ? rowCount/pageSize : rowCount/pageSize+1;
    }

    //按照分页来获取用户
    //Result -> User对象 -> ArrayList集合
    public ArrayList<User> getUsersByPage(int pageNow,int pageSize){

        ArrayList<User> arr = new ArrayList<User>();

        final String sql = "select * from users order by id limit ?,?";
        String paras[] ={(pageNow-1) * pageSize + "",pageSize + ""};

        ResultSet rs = SqlHelper.executeQuery(sql, paras);

        try {
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setGrade(rs.getInt(4));
                arr.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            SqlHelper.close();
        }
        return arr;
    }

    //写一个验证用户是否合法的函数
    public boolean checkUser(User user) {

        boolean b = false;
        final String sql="select * from users where id =? and password = ?";
        String parameters[]={user.getId()+"", user.getPwd()};

        ResultSet rs = SqlHelper.executeQuery(sql, parameters);
        try {
            if(rs.next()){
                b=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            SqlHelper.close();
        }
        return b;
    }

    //删除用户函数
    public boolean delUser(String id){

        boolean b = true;
        String sql = "delete from users ehere id =?";
        String parameters[] = {id};
        try {
            SqlHelper.executeUpdate(sql,parameters);
        } catch (Exception e) {
            b =false;
        }
        return b;
    }
}

