package oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class BankAccountTest
 {
     @Test
     void depositIncreasesBalance() {

         BankAccount acc = new BankAccount("Goutham", 1000); // or new BankAccount(1000) or new BankAccount()

         acc.deposit(500);
         assertEquals(1500, acc.getBalance());
     }

     @Test
     void withdrawDecreasesBalance() {
         BankAccount acc = new BankAccount("Goutham", 1000);

         acc.withdraw(300);
         assertEquals(700, acc.getBalance());
     }

     @Test
     void withdrawMoreThanBalanceShouldNotGoNegative()
     {
         BankAccount acc = new BankAccount("Goutham", 250);//Arrange

         acc.withdraw(375);//Act
         assertEquals(250, acc.getBalance(), "Balance should not go Negative");//Assert
     }

     @Test
     void depositNegativeAmountShouldBeIgnored()
     {
         BankAccount acc = new BankAccount("Goutham", 800);

         acc.deposit(-600);
         assertEquals(10000, acc.getBalance() , "Negative amount deposit should not change Balance");
     }
 }

