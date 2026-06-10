package ui.advanced;

import oop.testng.BaseTestNG;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSExecutorTest extends BaseTestNG
{
    @Test
    public void testJavaScriptExecutor()
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        // Part 1 – scroll and click (assert BEFORE navigating away)
        getDriver().get("https://the-internet.herokuapp.com/large");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement link = getDriver().findElement(By.linkText("Elemental Selenium"));
        js.executeScript("arguments[0].click();", link);

        // Switch to new tab
        for(String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        Assert.assertTrue(getDriver().getCurrentUrl().contains("elementalselenium"),
                "Did not navigate to Elemental Selenium");

        // Part 2 – set value via JS (separate assertion)
        getDriver().get("https://the-internet.herokuapp.com/login");
        js.executeScript("document.getElementById('username').value='tomsmith';");
        String value = (String) js.executeScript("return document.getElementById('username').value;");
        Assert.assertEquals(value, "tomsmith");
    }
}
