package oop.junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import utils.JSUtil;
import static org.junit.jupiter.api.Assertions.*;

public class JavaScriptExecutorTest extends BaseTest
{
    @Test
    void jsScrollClickHighlight()
    {
        driver.get("https://the-internet.herokuapp.com/large");
        JSUtil js = new JSUtil(driver);

        WebElement footer = driver.findElement(By.id("page-footer"));
        js.scrollIntoView(footer); // scroll 10,000px down
        js.highlight(footer);   // Apply red border for Easy debugging

        WebElement link = driver.findElement(By.linkText("Elemental Selenium"));
        js.click(link); // JS click bypasses scroll issues

        //Link opens in new window , so switch control to that window
        for (String newWindow : driver.getWindowHandles())
        {
            driver.switchTo().window(newWindow);
        }
        //Verify that page title for confirmation
        assertTrue(driver.getCurrentUrl().contains("elementalselenium"));
    }

    @Test
    void jsGetTitleFaster()
    {
        driver.get("https://example.com");
        JSUtil js = new JSUtil(driver);
        String title = js.getPageTitle();

        //example.com site title doesn't change . It will always be "Example Domain"
        assertTrue(title.contains("Example"),"Actual title: " + title);
    }
}
