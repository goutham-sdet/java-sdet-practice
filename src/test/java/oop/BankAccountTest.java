package oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class BankAccountTest
 {
     @Test
     void depositIncreasesBalance() {
         // CHANGE THIS to your constructor
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
 }

