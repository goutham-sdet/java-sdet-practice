package oop;

import org.openqa.selenium.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import utils.ScreenshotUtil;

public class ScreenshotTest extends BaseTest
{
    @RegisterExtension
    static ScreenshotWatcher watcher = new ScreenshotWatcher();

    @Test
    void captureOnFailureDemo()
    {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Intentional failure to prove screenshot works
        Assertions.assertEquals("The Internet", driver.getTitle());
    }

    static class ScreenshotWatcher implements AfterTestExecutionCallback
    {
        @Override
        public void afterTestExecution(ExtensionContext context)
        {
            //Only Take Screenshot if test failed
            context.getExecutionException().ifPresent(ex ->
            {
                Object testInstance = context.getRequiredTestInstance();
                if (testInstance instanceof BaseTest baseTest)
                {
                    String path = ScreenshotUtil.takeScreenshot(baseTest.driver, context.getDisplayName());
                    System.out.println("Screenshot saved: " + path);
                }

            });

        }
    }
}
