package com.liuning.servlet.utils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {

    private static PreparedStatement ps=null;
    private static ResultSet rs=null;
    private static Connection ct=null;

    private static final String sqlDriver="com.mysql.jdbc.Driver";
    private static final String url1="jdbc:mysql://localhost:3306/myfirst?serverTimezone=GMT";
    private static final String url2="root";
    private static final String url3="open123";

    public static void ConnectDatabase(){
        try {
            Class.forName(sqlDriver);
            ct=DriverManager.getConnection(url1,url2,url3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //把对数据库的增，删，改写成一个函数
    public static boolean executeUpdate(String sql,String[] paras){

        ConnectDatabase();

        boolean b=true;
        try {
            ps=ct.prepareStatement(sql);
            for(int i=0;i<paras.length;i++)
            {
                ps.setString(i+1, paras[i]);
            }
            ps.executeUpdate();
            //getClass();
        } catch (Exception e) {
            b=false;
            JOptionPane.showMessageDialog(null, "数据源错误或数据库用户名、密码错误",
                    "数据库连接错误提示", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return b;
    }

    //数据库的查询操作
    public static ResultSet executeQuery(String sql,String[] paras){

        ConnectDatabase();

        try {
            ps=ct.prepareStatement(sql);
            if(paras != null) {
                for(int i = 0; i < paras.length; i++){
                    ps.setString(i + 1, paras[i]);
                }
            }
            rs=ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void close(){
        try {
            if(rs!=null){	rs.close();	}
            if(ps!=null){	ps.close();	}
            if(ct!=null){	ct.close();	}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
