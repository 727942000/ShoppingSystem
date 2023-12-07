package com.company;

import java.util.PriorityQueue;
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
                break;
            case 2:
                System.out.println("2.卖家");
                break;
            case 3:
                System.out.println("3.管理员");
                Person ps = new Person(EventName.Administrator);
                ps.Verify();
                ps.Init();
                ps.Show();
                break;
            default:
                System.out.println("输入不正确");
                return;
        }
    }
}
