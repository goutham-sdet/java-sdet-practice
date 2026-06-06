package oop.junit;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class ExplicitWaitTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    @Test
    void waitForHiddenElementToAppear()
    {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        // Click Start
        driver.findElement(By.cssSelector("#start button")).click();
        // Explicit wait: wait up to 15s for #finish to be VISIBLE
        WebElement hello = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assertEquals("Hello World!", hello.getText().trim());
    }

    @Test
    void waitForElementToBecomeEnabled()
    {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Click Enable
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        // Wait until input is clickable (enabled)
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example input")));
        input.sendKeys("Day10");
        assertTrue(input.isEnabled());
        assertEquals("Day10",input.getAttribute("value"));
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
