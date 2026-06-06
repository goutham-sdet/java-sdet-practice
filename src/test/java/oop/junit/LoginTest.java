package oop.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void Setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new" , "--no-sandbox" , "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @Test
    void ValidLoginShowsSuccess()
    {
        //To Launch the Page
        driver.get("https://the-internet.herokuapp.com/login");
        //To Enter Username
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("tomsmith");
        //To Enter Password
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("SuperSecretPassword!");
        //To Click Login button
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
        //To Locate and Store the Guide Message
        WebElement success_msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));
        //To fetch and Validate the Guide Message
        assertTrue(success_msg.getText().contains("You logged into a secure area!"));
    }
    @Test
    void InvalidLoginThrowsError()
    {
        driver.get("https://the-internet.herokuapp.com/login");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("wrongname");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("wrongpassword");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.radius"))).click();
        WebElement Error_msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
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
