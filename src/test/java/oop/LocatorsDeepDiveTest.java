package oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class LocatorsDeepDiveTest
{
    private WebDriver driver;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    void linkTextAndPartialLinkText()
    {
        driver.get("https://the-internet.herokuapp.com/");
        //By linkText
        driver.findElement(By.linkText("Form Authentication")).click();
        assertTrue(driver.getCurrentUrl().contains("login"));
        driver.navigate().back();
        //By partialLinkText
        driver.findElement(By.partialLinkText("Dynamic Loading")).click();
        assertTrue(driver.getCurrentUrl().contains("dynamic_loading"));
    }

    @Test
    void classNameTagNameAndCss()
    {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //By Tagname
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        assertEquals(2, checkboxes.size());
        //By cssSelector
        WebElement firstBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
       if (!firstBox.isSelected())
       {
           firstBox.click();
       }
       assertTrue(firstBox.isSelected());
       //By className
       driver.get("https://the-internet.herokuapp.com/");
       WebElement heading = driver.findElement(By.className("heading"));
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
