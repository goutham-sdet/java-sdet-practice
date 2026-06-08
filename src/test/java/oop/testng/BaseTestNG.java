package oop.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Random;
import java.util.UUID;

public class BaseTestNG
{
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<> ();
    protected WebDriverWait wait;

    protected WebDriver getDriver()
    {
        return tlDriver.get();
    }

    @BeforeMethod
    public void SetUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage",
                "--window-size=1920,1080", "--disable-gpu", "--remote-allow-origins=*");
        /* String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome-" + UUID.randomUUID();
        options.addArguments("--user-data-dir=" + userDataDir);
        options.addArguments("--remote-debugging-port=" + (9222 + new Random().nextInt(2000))); */

        tlDriver.set(new ChromeDriver(options));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if (getDriver() != null)
        {
            if (!result.isSuccess())
            {
                Allure.addAttachment("Failure Screenshot",
                        new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
            }
            getDriver().quit();
            tlDriver.remove();
        }
    }
}
