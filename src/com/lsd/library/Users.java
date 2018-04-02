package com.lsd.library;

// this is the class user, where we define all the feature, that a ''user'' of the library should have
public class Users {
    Users(String name, String address, String phoneNumber){ //  here we initialize the constructor of the class
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        long first = System.currentTimeMillis();
        cardNumber = (int) first;
    }

    // Here we are declaring the main features, variables that identify the user
    String name;
    String address;
    String phoneNumber;
    int cardNumber;

    // Method to return the card number of the user
    public int getCardNumber() {
        return cardNumber;
    }

    // Method to get the name of the user
    public String getName() {
        return name;
    }
}
