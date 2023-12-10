package com.company;

import java.sql.Connection;
import java.util.*;
import java.util.List;
import java.util.Map;

public class Person {
    public int ID;
    public String password;
    public String name;
    public String sex;
    public String email;
    public String status;
    public String figure;
    public EventName en;
    public String pathname;
    private Map<Integer,List<String>> map;
    private List<String> list;
    private Connection conn;
    public AllOperation ap;

    public Person(){
        ap = new AllOperation();
    }
    public Person(EventName en){
        this.en = en;
        ap = new AllOperation();
    }

    public boolean Verify(){
        while(true) {
            System.out.println("输入您的账号");
            Scanner sc = new Scanner(System.in);
            this.ID = sc.nextInt();
            this.map = ap.Select(EventName.ID,ID);
            if(map.containsKey(ID)){
                break;
            }
            System.out.println("没有这个账号\n\n");
        }

        while(true) {
            System.out.println("输入您的密码");
            Scanner sc = new Scanner(System.in);
            this.password = sc.next();
            this.list = map.get(ID);
            if(list.get(2).compareTo(password)==0){
                break;
            }
            System.out.println("密码错误\n\n");
        }
        return true;
    }

    public void Init(){

        name = list.get(1);
        password = list.get(2);
        email = list.get(3);
        sex = list.get(4);
        status = list.get(5);
        switch (en) {
            case Buyer:
                figure = "买家";
                break;
            case Seller:
                figure = "卖家";
                break;
            default:
                figure = "管理员";
        }
    }
    public void Show(){
        System.out.println("ID :"+ID);
        System.out.println("密码 :"+password);
        System.out.println("账户名 :"+name);
        System.out.println("性别 :"+ sex);
        System.out.println("邮箱 :"+email);
        System.out.println("身份 :"+figure);

    }
    public void Operate(){
        boolean flag = true;
        while(flag){
            System.out.println("请输入你的操作");
            System.out.println("1.搜买家");
            System.out.println("2.搜卖家");
            System.out.println("3.搜商品");
            System.out.println("4.更改个人信息");
            System.out.println("5.退出");
            Scanner sc = new Scanner(System.in);
            int operation = sc.nextInt();
            switch (operation){
                case 1:
                    var buyInfo = sc.next();
                    if(buyInfo.charAt(0) > 47 && buyInfo.charAt(0) < 50){
                        //Select(EventName.Buyer,Integer.valueOf(buyInfo));
                    }
                    else{
                        //Select(EventName.Buyer,buyInfo);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    flag = false;
            }
        }
    }

}
