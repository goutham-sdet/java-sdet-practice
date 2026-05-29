package oop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest
{
    // protected = child classes can use 'driver' directly
    protected WebDriver driver;

    @BeforeEach
    void setUp()
    {
        // Downloads matching ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Headless options for CI (works locally too)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage","--window-size=1920,1080");
        driver = new ChromeDriver(options);
        // we use explicit waits only , so indicating implicit wait as 0
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
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
