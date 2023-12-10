package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean flag = true;
        while(flag) {
            System.out.println("你的角色是:");
            System.out.println("1.买家");
            System.out.println("2.卖家");
            System.out.println("3.管理员");
            System.out.println("4.退出");
            Scanner sc = new Scanner(System.in);
            int character = sc.nextInt();

            switch (character) {
                case 1:
                    System.out.println("1.买家");
                    Buyer buyer = new Buyer(EventName.Buyer);
                    if (!buyer.Verify()) {
                        break;
                    }
                    buyer.Init();
                    buyer.Show();
                    buyer.Operate();
                    break;
                case 2:
                    System.out.println("2.卖家");
                    Seller seller = new Seller(EventName.Seller);
                    if (!seller.Verify()) {
                        break;
                    }
                    seller.Init();
                    seller.Show();
                    seller.Operate();
                    break;
                case 3:
                    System.out.println("3.管理员");
                    Administrator administrator = new Administrator(EventName.Administrator);
                    administrator.pathname = Operation.Administrator;
                    if (!administrator.Verify()) {
                        break;
                    }
                    administrator.Init();
                    administrator.Show();
                    administrator.Operate();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("输入不正确");
            }
        }
    }
}
