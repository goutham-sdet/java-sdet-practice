package oop;

public class BankAccount {
    String accountName;
    double balance;

    public BankAccount(String accountName , double balance) //Parameterized Constructor
    {
        this.accountName = accountName;
        this.balance = balance;
    }
     public void deposit(double amount) // Deposit Method
     {
         if(amount>0)
         {
             balance = balance + amount;
             System.out.println(amount + " deposited Successfully!!");
         }
         else
         {
             System.out.println("Invalid Deposit Amount");
         }
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
