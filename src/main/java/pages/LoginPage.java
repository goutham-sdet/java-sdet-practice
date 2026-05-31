package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage
{
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By flash = By.id("flash");

    public LoginPage (WebDriver driver)
    {
        super (driver);
    }

    public void open()
    {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // Just submits the form, does NOT wait for /secure
    public void submitLogin(String user, String pass)
    {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public SecureAreaPage login(String user , String pass)
    {
        submitLogin(user, pass);
        waitForUrlContains("/secure");
        return new SecureAreaPage(driver);
    }

    public String getFlashText()
    {
        return getFlashText(flash);
    }

    public Boolean waitForFlash(String expectedText)
    {
        return waitForFlashContains(flash, expectedText);
    }
}
