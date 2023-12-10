package com.company;

import java.sql.*;

public class Connectsql {


    //以下代码将获取数据库连接操作封装为一个接口，可通过给定用户名和密码来连接数据库。
    public Connection getConnect(String username, String passwd)
    {

        //驱动类。
        String driver = Operation.driver;
        String sourceURL = Operation.sourceURL;
        Connection conn = null;

        try
        {
            //加载驱动。
            Class.forName(driver);
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return null;
        }

        try
        {
            //创建连接。
            System.out.println("创建连接中");
            conn = DriverManager.getConnection(sourceURL, username, passwd);
            System.out.println("Connection succeed!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return conn;
    };
//    public static void main(String[] args) {
//        getConnect("root","123456");
//    }

}