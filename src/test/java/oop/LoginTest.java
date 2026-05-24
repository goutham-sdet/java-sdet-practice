package oop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest
{
    private WebDriver driver;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new" , "--no-sandbox" , "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }
    @Test
    void ValidLoginShowsSuccess()
    {
        //To Launch the Page
        driver.get("https://the-internet.herokuapp.com/login");
        //To Enter Username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //To Enter Password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //To Click Login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //To Locate and Store the Guide Message
        WebElement success_msg = driver.findElement(By.xpath("//div[@id='flash']"));
        //To fetch and Validate the Guide Message
        assertTrue(success_msg.getText().contains("You logged into a secure area!"));
    }
    @Test
    void InvalidLoginThrowsError()
    {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("wrongname");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.cssSelector("button.radius")).click();
        WebElement Error_msg = driver.findElement(By.id("flash"));
        assertTrue(Error_msg.getText().contains("Your username is invalid!"));
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
