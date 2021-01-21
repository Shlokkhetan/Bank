package com.company;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches =new ArrayList<>();
    }

    public boolean addBranches(String branchName){
        for(int i = 0; i<branches.size(); i++){
            if(branches.get(i).getName().equals(branchName)){
                System.out.println("branch already exists");
                return false;
            }


        }
        branches.add(new Branch(branchName));
        return true;

    }

    public boolean addCustomer(String branchName, String CustomerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.newCustomer(CustomerName,initialAmount);
        }
        return false;


    }

    public boolean addCustomerTransaction(String branchName, String CustomerName, double Amount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomerTransaction(CustomerName, Amount);
        }
        return false;

    }



    private Branch findBranch(String branchName) {
        for(int i=0; i<this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }

        return null;
    }

    public boolean listCustomers(String name, boolean showTransactions){

        Branch branch = findBranch(name);
        if(branch!=null){
            System.out.println("Customer details for branch" + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i = 0; i<branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer name: " + branchCustomer +"["+ i + "]");
                if(showTransactions){
                    ArrayList<Double> transactionList = branchCustomer.getTransactions();
                    for(int j = 0; j<branchCustomers.size();j++){
                        System.out.println("[" + j+1 + "] amount = " + transactionList.get(j));

                    }
                }

            }
            return true;
        }else{
            return false;
        }



    }



}
