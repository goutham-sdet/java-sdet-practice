package com.goutham.sdet.oop;

public class MainTransaction {
    static double amount;
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount("1234ABC" , 6000);
        account1.deposit(5000);
        account1.withdraw(2000);
        account1.deposit(1000);
        System.out.println("The Current available balance after this transaction is : " + account1.getBalance());
    }
}
