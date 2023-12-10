package com.company;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public int ID = -1;
    public int P_ID;
    public int U_ID;
    public int A_ID;
    public String price;
    public String time;
    public String state;
    private AllOperation ap;
    private List<String> list;
    private Map<Integer,List<String>> map;

    public Orders(){
        ap = new AllOperation();
    }

    public Boolean selectOrders(){

        map = ap.Select(EventName.Orders,null);
        for(int k : map.keySet()){
            this.ID = k;
            return true;
        }
        System.out.println("空空如也");
        return false;
    }
    public void show(){
        for(int k : map.keySet()){
            list = map.get(k);
            Map<Integer,List<String>> _map;
            System.out.println("ID :"+ID);

            _map = ap.Select(EventName.Product,Integer.parseInt(list.get(1)));
            String name =_map.get(Integer.parseInt(list.get(1))).get(2);
            System.out.println("商品名 :"+name);

            _map = ap.Select(EventName.Seller,Integer.parseInt(list.get(2)));
            String buyer = _map.get(Integer.parseInt(list.get(2))).get(1);
            System.out.println("收件人 :"+buyer);

            _map = ap.Select(EventName.Address,Integer.parseInt(list.get(3)));
            String address = _map.get(Integer.parseInt(list.get(3))).get(2);
            System.out.println("地址 :"+address);

            System.out.println("价格 :" +list.get(4));
            System.out.println("下单时间 :"+list.get(5));
            System.out.println("状态 :"+list.get(6));
        }
    }

}
