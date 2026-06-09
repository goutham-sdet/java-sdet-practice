package oop.testng.listeners;

import io.qameta.allure.Allure;
import oop.testng.BaseTestNG;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener
{
    @Override
    public void onTestFailure(ITestResult result)
    {
        //Get Driver from Thread Instance (thread-safe)
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTestNG)
        {
            WebDriver driver = ((BaseTestNG) testInstance).getDriver();

            if (driver != null)
            {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failure Screenshot - " + result.getName(),
                        new ByteArrayInputStream(screenshot));
            }
        }
        System.out.println("TEST FAILED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("TEST PASSED: " + result.getName());
    }
}
