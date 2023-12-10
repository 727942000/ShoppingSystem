package com.company;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Product {
    public int ID = -1;
    public int T_ID;
    public String type = " ";
    public String name;
    public String time;
    public String price;
    public String info;
    public String popularity;
    private List<String> list;
    private Map<Integer,List<String>> map;
    private AllOperation ap;

    public Product(){
        ap = new AllOperation();
    }
    public boolean selectProduct(){
            System.out.println("用商品编号或商品名搜索");
            Scanner scanner = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            //scanner.nextLine();
            sb.append(scanner.nextLine());
            map = ap.Select(EventName.Product,sb.toString());
            for(int k : map.keySet()){
                this.ID = k;
                return true;
            }
            System.out.println("不存在这个商品");
            return false;
    }
    public void productInit(){
        if(ID == -1){
            System.out.println("初始化失败");
        }
        list = map.get(ID);
        this.T_ID =Integer.parseInt(list.get(1));
        this.name = list.get(2);
        this.time = list.get(3);
        this.price = list.get(4);
        this.info = list.get(5);
        this.popularity = list.get(6);
    }

    public void Show(){
        System.out.println("ID :"+ID);
        System.out.println("品类 :"+ type);
        System.out.println("商品名 :"+name);
        System.out.println("商品信息 :"+ info);
        System.out.println("价格 :"+ price);
        System.out.println("受欢迎程度 :"+ popularity);
    }
}
