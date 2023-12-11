package com.company;

import java.util.List;
import java.util.Map;

public class Cart {
    public int ID;
    private Map<Integer,List<String>> map;
    private List<String> list ;
    private AllOperation ap;

    public Cart(){
        ap = new AllOperation();
    }

    public Boolean cartSelect(){
        map = ap.Select(EventName.cart,null);
        for(int k : map.keySet()){
            this.ID = k;
            return true;
        }
        System.out.println("空空如也");
        return false;
    }

    public void show(){
        Map<Integer,List<String>> _map;
        if(this.ID == -1){
            System.out.println("初始化失败");
        }
        for(int k : map.keySet()){
            list = map.get(k);

            System.out.println("ID :"+k);

            _map = ap.Select(EventName.Buyer,Integer.parseInt(list.get(1)));
            String buyer = _map.get(list.get(1)).get(1);
            System.out.println("收件人 :"+buyer);

            _map = ap.Select(EventName.Product,Integer.parseInt(list.get(2)));
            String name = _map.get(list.get(2)).get(2);
            System.out.println("商品名 :"+name);

            System.out.println("商品金额 :"+ list.get(3));
            System.out.println("商品数量 :"+ list.get(4));
        }

    }
}
