package oop;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @ParameterizedTest(name = "deposit: {0} + {1} = {2}")
    @CsvSource({
            "1000.0, 500.0, 1500.0",   // normal deposit
            "0.0, 250.0, 250.0",       // from zero
            "1000.0, 0.0, 1000.0",     // zero deposit
            "1000.0, -100.0, 1000.0",   // negative ignored
            "2000.0, 100.0, 2100.0"    // new scenario for normal deposit
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
            "300.0, 400.0, 300.0",     // overdraft blocked
            "1000.0, -50.0, 1000.0",   // negative ignored
            "800.0, 0.0, 800.0"        // zero withdraw
    })
    void withdrawScenarios(double startBalance, double withdrawAmount, double expectedBalance) {
        BankAccount account = new BankAccount("TestUser", startBalance);
        account.withdraw(withdrawAmount);
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }
}
