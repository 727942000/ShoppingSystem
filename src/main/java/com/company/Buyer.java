package com.company;

import java.util.Scanner;

public class Buyer extends Person{
    public Buyer(EventName en){
        this.en = en;
    }
    @Override
    public void Operate(){
        boolean flag = true;
        while(flag){
            System.out.println("请输入你的操作");
            System.out.println("1.搜买家");
            System.out.println("2.搜卖家");
            System.out.println("3.搜商品");
            System.out.println("4.更改个人信息");
            System.out.println("5.购物车");
            System.out.println("6.我的订单");
            System.out.println("7.退出");
            Scanner sc = new Scanner(System.in);
            int operation = sc.nextInt();
            boolean _flag = true;
            switch (operation){
                case 1:
                    caseBuyer();
                    break;
                case 2:
                    caseSeller();
                    break;
                case 3:
                    caseProduct();
                    break;
                case 4:
                    break;
                case 5:
                    Cart cart = new Cart();
                    if(cart.cartSelect()){
                        cart.show();
                    }
                    break;
                case 6:
                    Orders orders = new Orders();
                    if(orders.selectOrders()){
                        orders.show();
                    }
                    break;
                default:
                    flag = false;
            }
        }
    }
}
