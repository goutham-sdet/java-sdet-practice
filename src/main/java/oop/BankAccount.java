package oop;

public class BankAccount {
    private final String accountName;
    private double balance;

    public BankAccount(String accountName , double balance) //Parameterized Constructor
    {
        if(accountName == null || accountName.isBlank())
        {
            throw new IllegalArgumentException(" Account name Required!!");
        }
        if(balance < 0)
        {
            throw new IllegalArgumentException(" Initial Balance should not be Negative");
        }
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName()
    {
        return accountName;
    }
    public double getBalance() // Balance Check Method
    {
        return balance;
    }
     public void deposit(double amount) // Deposit Method
     {
         if(amount<=0)
         {
             throw new IllegalArgumentException("Deposit Amount should be more than 0");
         }
         else
         {
             balance = balance + amount;
             System.out.println(amount + " deposited Successfully!!");
         }
     }
     public void withdraw(double amount) // Withdrawal Method
     {
         if (amount <= 0)
         {
             throw new IllegalArgumentException("Withdraw amount must be > 0");
         }
         if (amount > balance)
         {
             throw new IllegalArgumentException("oops!! Insufficient Funds..");
         }
         else
         {
             balance = balance - amount;
             System.out.println(amount + " withdrawn Successfully!!");
         }
     }
}
