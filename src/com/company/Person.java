package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Person {
    public int ID;
    private String password;
    public String name;
    public String sex;
    public String phoneNumber;
    public String address;
    private EventName en;
    private Map<Integer,List<String>> map;
    private List<String> list;

    public Person(){}
    public Person(EventName en){
        this.en = en;
    }

    public Map<Integer, List<String>> Select(EventName en,int id){
        String pathname = "D:\\Java\\ideaIC-2021.3.1.win\\购物系统--数据库大作业\\src\\com\\company\\Administrator.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                //System.out.println(line);
                String[] str = line.split(" ");
                //System.out.println(str.length);
                if(str[0].compareTo(Integer.toString(id))==0){
                    Map<Integer,List<String>> map = new HashMap<>();
                    List<String> list= new ArrayList<>();
                    for (String cell : str){
                        list.add(cell);
                    }
                    map.put(id,list);
                    return map;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    public Map<Integer, List<String>> Select(EventName en,String str){
        return null;
    }
    private boolean Select(EventName en1,EventName en2,int id){
        String pathname = "D:\\Java\\ideaIC-2021.3.1.win\\购物系统--数据库大作业\\src\\com\\company\\Administrator.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                //System.out.println(line);
                String[] str = line.split(" ");
                if(str[0].compareTo(Integer.toString(id))==0){
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Verify(){
        while(true) {
            System.out.println("输入您的账号");
            Scanner sc = new Scanner(System.in);
            this.ID = sc.nextInt();
            if(Select(EventName.ID,en,this.ID)){
                break;
            }
            System.out.println("没有这个账号\n\n");
        }

        while(true) {
            System.out.println("输入您的密码");
            Scanner sc = new Scanner(System.in);
            this.password = sc.next();
            map = Select(en,this.ID);
            list = map.get(this.ID);
            if(list.get(1).compareTo(password)==0){
                break;
            }
            System.out.println("密码错误\n\n");
        }
        return true;
    }

    public void Init(){
        map = Select(this.en,ID);
        list = map.get(ID);
        password = list.get(1);
        name = list.get(2);
        sex = list.get(3);
        phoneNumber = list.get(4);
        address = list.get(5);
    }
    public void Show(){
        System.out.println("ID :"+ID);
        System.out.println("密码 :"+password);
        System.out.println("账户名 :"+name);
        System.out.println("性别 :"+ sex);
        System.out.println("电话 :"+phoneNumber);
        switch (en) {
            case Buyer:
                System.out.println("身份 :" + "买家");
                break;
            case Seller:
                System.out.println("身份 :" + "卖家");
                break;
            default:
                System.out.println("身份 :" + "管理员");
        }
    }

}
