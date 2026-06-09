package oop.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import static org.testng.Assert.*;

public class LoginTestNG extends BaseTestNG
{
    @DataProvider (name = "logins",parallel = true)
    public Object[][] data()
    {
        return new Object[][]
                {
                        {"tomsmith","SuperSecretPassword!", true},
                        {"tomsmith","wrongPass",false}
                };
    }

    @Test (dataProvider = "logins", retryAnalyzer = oop.testng.listeners.RetryAnalyzer.class)
    public void loginTest( String user, String pass, boolean shouldPass)
    {
        LoginPage login = new LoginPage(getDriver());
        login.open();
        login.submitLogin(user, pass);

        if(shouldPass)
        {
            assertTrue(new SecureAreaPage(getDriver()).waitForFlash("You logged into"));
        }
        else
        {
            assertTrue(login.getFlashText().contains("invalid"));
        }
    }
}
