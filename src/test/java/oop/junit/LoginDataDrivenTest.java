package oop.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginDataDrivenTest extends BaseTest
{
    @ParameterizedTest (name = "login with user={0}")
    @CsvSource ({
            "tomsmith, SuperSecretPassword!, true",
            "tomsmith, wrongPass, false",
            "wrongUser, SuperSecretPassword!, false"
    })

    void loginWithMulptileCredentials(String user , String pass , Boolean shouldSucceed)
    {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.submitLogin(user, pass);

        if (shouldSucceed)
        {
            SecureAreaPage secure = new SecureAreaPage(driver);
            assertTrue(secure.waitForFlash("You logged into a secure area"));
            assertTrue(secure.isLogoutBtnVisible());
        }
        else
        {
            // stays on login page, error flash appears
            String flash = login.getFlashText();
            assertTrue(flash.contains("Your username is invalid")
                             || flash.contains("Your password is invalid"),"Expected invalid credentials flash, got: " + flash );
        }
    }
}
