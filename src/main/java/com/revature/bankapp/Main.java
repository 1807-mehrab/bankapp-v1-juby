package com.revature.bankapp;

class Main{
    public static void main(String[] args){
        Menu.printMenu();
        int response = Menu.getResponse();
        Menu.parseResponse(response);
    }
}