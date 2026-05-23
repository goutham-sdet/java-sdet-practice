package oop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GoogleTest
{
    private WebDriver driver;

    @BeforeEach
    void setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    void googlePageTitleContainsGoogle()
    {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertTrue(title.contains("Google"), "Title should contain Google , But was : " + title);
    }

    @AfterEach
    void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }
}
