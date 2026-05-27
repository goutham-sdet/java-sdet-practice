package oop;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class MouseHoverTest
{
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @Test
    void hoverRevealsCaption()
    {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='figure'])[1]/img")));
        // Hover over first Element
        actions.moveToElement(hover).pause(Duration.ofMillis(800)).perform();

        // Fetch the text which appears after hovering for Validation
        WebElement caption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='figure'])[1]//div[@class='figcaption']/h5")));
        assertTrue(caption.getText().contains("name: user1"));
    }

    @Test
    void DragAndDrop()
    {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-a")));
        WebElement target = driver.findElement(By.id("column-b"));

        //Perform Drag and Drop Action
        actions.dragAndDrop(source, target).build().perform();

        // Verify swap - after drag, A should be where B was
        WebElement headerA = driver.findElement(By.cssSelector("#column-a header"));
        assertEquals("B", headerA.getText());
    }

    @Test
    void rightClickContextMenu()
    {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement hotspot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hot-spot")));

        //Perform Right Click in Hotspot area
        actions.contextClick(hotspot).perform();

         // Verify Alert appears on right click
         Alert alert = wait.until(ExpectedConditions.alertIsPresent());
         // Verify Text present inside Alert popup
         assertEquals("You selected a context menu", alert.getText());
         // Close alert Popup by clicking Ok
         alert.accept();
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
