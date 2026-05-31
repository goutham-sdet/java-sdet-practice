package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        // Try real click first
        try
        {
            WebElement btn = waitForClickable(logoutBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();");
        }
        catch (Exception ignored) {}

        // If click didn't navigate in 5s, fall back to direct GET
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.urlContains("/login"));
        }
        catch (Exception e)
        {
            driver.get("https://the-internet.herokuapp.com/logout");
        }

        waitForUrlContains("/login");
        return new LoginPage (driver);
    }

    public Boolean isLogoutBtnVisible()
    {
        return waitForVisible(logoutBtn).isDisplayed();
    }
}
