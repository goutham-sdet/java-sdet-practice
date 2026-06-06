package oop.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @ParameterizedTest(name = "deposit: {0} + {1} = {2}")
    @CsvSource({
            "1000.0, 500.0, 1500.0",   // normal deposit
            "0.0, 250.0, 250.0",       // from zero Balance
            "2000.0, 100.0, 2100.0",    // new scenario for normal deposit
            "1500.0, 1500.0, 3000.0"     // making Zero Balance
    })
    void depositScenarios(double startBalance, double depositAmount, double expectedBalance) {
        BankAccount account = new BankAccount("TestUser", startBalance);
        account.deposit(depositAmount);
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    @ParameterizedTest(name = "withdraw: {0} - {1} = {2}")
    @CsvSource({
            "1000.0, 400.0, 600.0",    // normal withdraw
            "500.0, 500.0, 0.0",       // exact balance
    })
    void withdrawScenarios(double startBalance, double withdrawAmount, double expectedBalance) {
        BankAccount account = new BankAccount("TestUser", startBalance);
        account.withdraw(withdrawAmount);
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }
    @Test
    void depositNegativeThrows() {
        BankAccount acc = new BankAccount("Test", 1000.0);
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(-100));
    }

    @Test
    void withdrawOverdraftThrows() {
        BankAccount acc = new BankAccount("Test", 300.0);
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(400));
    }
}
