package oop.junit;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest
{
    @Test
    void validLoginAndLogoutFlowWithPom()
    {
        LoginPage login = new LoginPage(driver);
        login.open(); //Open login

        //Login → get SecureAreaPage
        SecureAreaPage secure = login.login("tomsmith" , "SuperSecretPassword!");

        //Verify flash + logout button
        assertTrue(secure.waitForFlash("You logged into a secure area"));
        assertTrue(secure.isLogoutBtnVisible(), "Logout button not visible");

        //Logout → get LoginPage back
        LoginPage loginAgain = secure.logout();

        //Verify logged out message
        assertTrue(loginAgain.waitForFlash("You logged out of the secure area"));
    }
}
