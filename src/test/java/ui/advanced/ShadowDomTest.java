package ui.advanced;

import oop.testng.BaseTestNG;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShadowDomTest extends BaseTestNG
{
    @Test
    public void testShadowDOM()
    {
        getDriver().get("https://the-internet.herokuapp.com/shadowdom");

        // Selenium 4 native shadow root support
        WebElement shadowHost = getDriver().findElement(By.cssSelector("my-paragraph:nth-of-type(1)"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("p"));
        String text = shadowContent.getText();

        // Actual text on the page is "Let's have some different text!"
        System.out.println("Shadow text found: " + text);
        Assert.assertTrue(text.contains("Let's have some different"),
                "Expected shadow text not found, got: " + text);
    }
}
