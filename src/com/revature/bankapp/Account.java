package com.revature.bankapp;
import java.io.*;

public class Account implements Serializable{
    private int dollars, cents;
    private long accountNumber;
    private String name;

    public Account(){
        dollars = 0;
        cents = 0;
        accountNumber = 0;
        name = null;
    }

    public Account(int dollars, int cents, int accountNumber, String name){
        this.dollars = dollars;
        this.cents = cents;
        this.accountNumber = accountNumber;
        this.name = name;
    }
}