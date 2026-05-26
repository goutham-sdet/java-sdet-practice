package oop;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class FluentWaitTest
{
    private WebDriver driver;
    private Wait<WebDriver> fluent;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        // FluentWait: check every 500ms, ignore NoSuchElement,StaleElementReference - timeout 20s
        fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    @Test
    void fluentWaitForElementAfterAjax()
    {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        // wait for start button first
        WebElement start = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start button")));
        start.click();

        // Fluent wait with lambda - more flexible than ExpectedConditions
        WebElement hello = fluent.until(drv->{
            var el = drv.findElements(By.id("finish"));
            if (!el.isEmpty() && el.get(0).isDisplayed())
            {
                return el.get(0);
            }
            return null; // keep polling
        });

        assertEquals("Hello World!",hello.getText().trim());
    }

    @Test
    void fluentWaitForElementToDisappear() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // Wait until checkbox disappears
        Boolean gone = fluent.until(drv ->
                drv.findElements(By.id("checkbox")).isEmpty()
        );

        assertTrue(gone);
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
