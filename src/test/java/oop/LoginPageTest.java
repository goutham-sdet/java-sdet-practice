package oop;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest
{
    @Test
    void validLoginWithPom()
    {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("tomsmith" , "SuperSecretPassword!");

        assertTrue(login.getFlashText().contains("You logged into"));
    }
}
