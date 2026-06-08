package oop.junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.util.List;

public class LocatorsDeepDiveTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void Setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080", "--disable-gpu", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    @Test
    void linkTextAndPartialLinkText()
    {
        driver.get("https://the-internet.herokuapp.com/");
        //By linkText
        WebElement formAuth = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Form Authentication")));
        formAuth.click();
        wait.until(ExpectedConditions.urlContains("login"));
        assertTrue(driver.getCurrentUrl().contains("login"));

        driver.navigate().back();
        //By partialLinkText
        WebElement DynamicLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Dynamic Loading")));
        DynamicLink.click();
        wait.until(ExpectedConditions.urlContains("dynamic_loading"));
        assertTrue(driver.getCurrentUrl().contains("dynamic_loading"));
    }

    @Test
    void classNameTagNameAndCss()
    {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //By Tagname
        List<WebElement> checkboxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("input")));
        assertEquals(2, checkboxes.size());
        //By cssSelector
        WebElement firstBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
       if (!firstBox.isSelected())
       {
           firstBox.click();
       }
       assertTrue(firstBox.isSelected());
       //By className
       driver.get("https://the-internet.herokuapp.com/");
       WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("heading")));
       assertEquals("Welcome to the-internet", heading.getText());
    }

    @AfterEach
    void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }
}
