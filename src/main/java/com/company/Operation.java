package com.company;

import java.util.List;
import java.util.Map;

public interface Operation {
    String driver = "com.mysql.cj.jdbc.Driver";
    String sourceURL = "jdbc:mysql://8.130.28.117:3306/Shop?useSSL=false";
    String userName = "root";
    String userPassWd ="123456";
    String BuyerAddr = ""; //买家表地址
    String SellerAddr = ""; //卖家表地址
    String Administrator = "D:\\Java\\ideaIC-2021.3.1.win\\购物系统--数据库大作业\\src\\main\\java\\com\\company\\Administrator.txt";//管理员表地址
    String GoodsAddr = "";//商品表地址

    //信息搜索
    Map<Integer, List<String>> Select(EventName en,String _name);
    //ID方式
    Map<Integer, List<String>> Select(EventName en,int ID);


    //三个参数分别为操作对象(买家/卖家/管理员)，对象id和更改内容
    //Boolean Update(EventName en,int ID,List<String> list);
    // 增

    Boolean insertCart(int u_id,int p_id,float c_count,int c_num);
    //Boolean Add(EventName en,int ID,List<String> list);
    //删除只需两个参数
    Boolean deleteCart(int ID);

    Boolean updateCart(int c_id,int u_id,int p_id,float c_count,int c_num);
}
