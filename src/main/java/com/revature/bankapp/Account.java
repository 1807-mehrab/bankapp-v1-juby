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

    public Account(int dollars, int cents, long accountNumber, String name){
        this.dollars = dollars;
        this.cents = cents;
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public int[] getBalance(){
        int[] ary = {dollars, cents};
        return ary;
    }

    public void deposit(int dollars, int cents){
        this.dollars += dollars;
        if(this.cents + cents > 100){
            this.dollars++;
        }
        this.cents = (this.cents + cents) % 100;
    }

    public boolean withdraw(int dollars, int cents){
        if(this.dollars < dollars || 
            (this.dollars == dollars && this.cents < cents))
            return false;
        else{
            this.dollars -= dollars;
            if(cents > this.cents){
                this.dollars--;
                this.cents = 100 + this.cents - cents;  
            } else {
                this.cents -= cents;
            }
            return true;
        }
    }

    public void setAccountNumber(long accountNumber){
        this.accountNumber = accountNumber;
    }

    public long getAccountNumber(){
        return accountNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}