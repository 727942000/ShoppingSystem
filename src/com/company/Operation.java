package com.company;

import java.util.List;
import java.util.Map;

public interface Operation {
    String BuyerAddr = ""; //买家表地址
    String SellerAddr = ""; //卖家表地址
    String Administrator = "D:\\Java\\ideaIC-2021.3.1.win\\购物系统--数据库大作业\\src\\com\\company\\Administrator.txt"; //管理员表地址
    String GoodsAddr = "";//商品表地址

    //信息搜索
    //字符串方式
    void SayHello(String hello);

    Map<Integer, List<String>> Select(EventName en,String str);
    //ID方式
    Map<Integer, List<String>> Select(EventName en,int ID);

    //登录时账号/密码搜索 第一个参数为 Operation.ID 第二个参数为操作对象(买家/卖家/管理员),返回值代表ID是否在表中
    Boolean Select(EventName en1,EventName en2,int ID);

    //三个参数分别为操作对象(买家/卖家/管理员)，对象id和更改内容
    Boolean Update(EventName en,int ID,List<String> list);

    Boolean Add(EventName en,int ID,List<String> list);
    //删除只需两个参数
    Boolean Delect(EventName en,int ID);
}
