package com.revature.bankapp;

import java.util.*;

public class Menu{
    private static String[] menuText = {
        "Welcome to JubyBank!",
        "",
        "~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~",
        "1)Create a new account",
        "2)Request account balance",
        "3)Make a deposit",
        "4)Make a withdrawl",
        "5)Change name on account",
        "~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~",
        ""
    };

    public static void printMenu(){
        for(String line : Menu.menuText) System.out.println(line);
    }

    public static int getResponse(){
        Scanner in = new Scanner(System.in);
        boolean err = false;
        int ret = 0;

        while(true){
            System.out.print("Enter your selection: ");
            try {
                ret = in.nextInt();
            } catch (InputMismatchException e) {
                err = true;
            } finally {
                in.nextLine();

                if(ret < 1 || ret > 5 || err){
                    System.out.println("Invalid selection. Try again.\n");
                    err = false;
                }
                else return ret;
            }
        }
    }

    public static void parseResponse(int i){
        if(i == 1){
            System.out.println(generateAccount());
        }
    }

    private static Account generateAccount(){
        String name, balance;
        int dollars = 0, cents = 0;
        long accountNumber;
        boolean valid = false;
        Scanner in = new Scanner(System.in);
        String[] spl;

        System.out.print("\nEnter your name:");
        name = in.nextLine();

        while(!valid){
            System.out.print("Enter your starting balance (e.g. 105.82): $");
            balance = in.nextLine();
            spl = balance.split(".");
            if((spl.length > 2) || (spl.length == 2 && spl[1].length() != 2)){
                System.out.println("Invalid format. Try again.");
            } else {
                dollars = Integer.parseInt(spl[0]);
                cents = Integer.parseInt(spl[1]);
                valid = true;
            }
        }
        accountNumber = new Random().nextLong();

        return new Account(dollars, cents, accountNumber, name);
    }
}