package com.company;

public class Goods {
    public int ID;
    public String name;
    public String informationOfGoods;
    public String seller;
    public String buyer;
    public String buyerPhoneNumber;
    public String sellerPhoneNumber;
    public String status;

    public void Show(){
        System.out.println("ID :"+ID);
        System.out.println("商品名 :"+name);
        System.out.println("商品信息 :"+informationOfGoods);
        System.out.println("卖家 :"+ seller);
        System.out.println("买家 :"+buyer);
        System.out.println("卖家电话 :"+sellerPhoneNumber);
        System.out.println("买家电话 :"+buyerPhoneNumber);
        System.out.println("商品状态 :"+status);
    }
}
