package oop;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.*;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class FramesAlertsTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void switchToFrameAndType()
    {
        driver.get("https://demoqa.com/frames");
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame1")));
        // Switch Control to Frame
        driver.switchTo().frame(iframe);

        //Validate the text inside the frame
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
        assertEquals("This is a sample page", heading.getText());

        // Switch the Control back to main Window and Verify the Presence of Frames in it
        driver.switchTo().defaultContent();
        WebElement framesAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame1")));
        assertNotNull(framesAgain);
    }

    @Test
    void javaScriptAlertAccept()
    {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Trigger the JavaScript Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //Verify Presence of Alert and Click Ok
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        //Validate the Result after accepting Alert popup
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        assertEquals("You successfully clicked an alert", result.getText());
    }

    @Test
    void javaScriptAlertDismiss()
    {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Trigger an Alert with ok and Cancel Buttons
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //Verify Presence of Alert and Click Cancel
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        //Validate the Result after Clicking Cancel
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        assertEquals("You clicked: Cancel", result.getText());
    }

    @Test
    void javaScriptPromptSendKeys()
    {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Trigger an alert which contains input field that accepts input
        WebElement button = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        button.click();

        //Verify Presence of Alert , Enter inputs , Click OK
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        alert1.sendKeys("SDET 45 Days!");
        alert1.accept();

        //Verify the Result after sending Input
        WebElement result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        assertEquals("You entered: SDET 45 Days!", result1.getText());

        //Trigger Prompt popup again
        button.click();

        //Verify Presence of Alert , Don't Enter anything , Click Cancel
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.dismiss();

        //Verify the Result after dismissing popup by sending Nothing
        WebElement result2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        assertEquals("You entered: null", result2.getText());
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
