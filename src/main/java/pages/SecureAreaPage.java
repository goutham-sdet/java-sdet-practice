package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage
{
    private By flash = By.id("flash");
    private By logoutBtn = By.cssSelector("a[href='/logout']");

    public SecureAreaPage(WebDriver driver)
    {
        super (driver);
    }

    public String getFlashText()
    {
        return getFlashText(flash);
    }

    public Boolean waitForFlash(String expectedText)
    {
        return waitForFlashContains(flash, expectedText);
    }

    public LoginPage logout()
    {
        click(logoutBtn);
        waitForUrlContains("/login");
        return new LoginPage (driver);
    }

    public Boolean isLogoutBtnVisible()
    {
        return waitForVisible(logoutBtn).isDisplayed();
    }
}
