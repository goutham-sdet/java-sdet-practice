package oop.junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DropDownTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-sham-usage");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @Test
    void selectByVisibleTextAndValue()
    {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        Select dd = new Select(dropdown);

        // Select by visible text
        dd.selectByVisibleText("Option 1");
        assertEquals("Option 1", dd.getFirstSelectedOption().getText());

        // Select by value
        dd.selectByValue("2");
        assertEquals("Option 2", dd.getFirstSelectedOption().getText());
    }

    @Test
    void getAllOptions()
    {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        //To fetch and store all options from dropdown for Validation
        List <WebElement> options = dropdown.getOptions();

        assertEquals(3,options.size()); // including "Please select"
        assertFalse(dropdown.isMultiple()); // To Verify single select
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
