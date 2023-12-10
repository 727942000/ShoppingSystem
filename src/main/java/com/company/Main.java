package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("你的角色是:");
        System.out.println("1.买家");
        System.out.println("2.卖家");
        System.out.println("3.管理员");
        Scanner sc = new Scanner(System.in);
        int character = sc.nextInt();

        switch (character) {
            case 1:
                System.out.println("1.买家");
                Buyer buyer = new Buyer(EventName.Buyer);
                buyer.Verify();
                buyer.Init();
                buyer.Show();
                break;
            case 2:
                System.out.println("2.卖家");
                Seller seller = new Seller(EventName.Seller);
                seller.Verify();
                seller.Init();
                seller.Show();
                break;
            case 3:
                System.out.println("3.管理员");
                Administrator administrator = new Administrator(EventName.Administrator);
                administrator.pathname = Operation.Administrator;
                administrator.Verify();
                administrator.Init();
                administrator.Show();
                break;
            default:
                System.out.println("输入不正确");
        }
    }
}
