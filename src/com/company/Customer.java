package com.company;

import java.util.ArrayList;

public class Customer {
    private  String name;
    private  ArrayList<Double> transactions;

    public Customer(String name, double oldTransaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(oldTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction){

        transactions.add(transaction);



    }


}
