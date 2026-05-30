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

    public void login(String user , String pass)
    {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public String getFlashText()
    {
        return driver.findElement(flash).getText();
    }
}
