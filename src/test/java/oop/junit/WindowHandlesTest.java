package oop.junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.Set;

public class WindowHandlesTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void switchToNewWindowAndBack()
    {
        driver.get("https://the-internet.herokuapp.com/windows");

        //Store the main window handle (address) and verify the number of windows present
        String mainWindow = driver.getWindowHandle();
        assertEquals(1, driver.getWindowHandles().size());

        //Open New Window
        driver.findElement(By.linkText("Click Here")).click();

        //Wait until a new window is opened
        wait.until( d -> d.getWindowHandles().size() == 2);

        //Switch the Control to the newly opened Window
        Set <String> allWindows = driver.getWindowHandles();
        for ( String newWindow : allWindows)
        {
            if ( !newWindow.equals(mainWindow))
            {
                driver.switchTo().window(newWindow);
                break;
            }
        }

        //verify Heading of new window
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        assertEquals("New Window", heading.getText());
        driver.close(); //Close the New window

        //Switch the Control back to main window
        driver.switchTo().window(mainWindow);

        //Verify the Heading of main window for Confirmation
        WebElement mainHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        assertEquals("Opening a new window", mainHeading.getText());
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
