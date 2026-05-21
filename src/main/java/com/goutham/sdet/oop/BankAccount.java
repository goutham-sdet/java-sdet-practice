package com.goutham.sdet.oop;

public class BankAccount {
    String accountNo;
    double balance;

    public BankAccount(String accountNo , double balance) //Parameterized Constructor
    {
        this.accountNo = accountNo;
        this.balance = balance;
    }
     public void deposit(double amount) // Deposit Method
     {
         balance = balance + amount;
         System.out.println(amount + " deposited Successfully!!");
     }
     public void withdraw(double amount) // Withdrawal Method
     {
         if (amount <= balance)
         {
             balance = balance - amount;
             System.out.println(amount + " withdrawn Successfully!!");
         }
         else
         {
             System.out.println("oops!! Insufficient Funds..");
         }
     }
     public double getBalance() // Balance Check Method
     {
         return balance;
     }
}
