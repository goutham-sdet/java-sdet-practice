package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class JSUtil
{
    private final JavascriptExecutor js;

    public JSUtil(WebDriver driver)
    {
        this.js = (JavascriptExecutor) driver;
    }
    public void scrollIntoView(WebElement el)
    {
        js.executeScript("arguments[0].scrollIntoView({behaviour:'smooth', block:'center'})", el);
    }
    public void click(WebElement el)
    {
        js.executeScript("arguments[0].click();", el);
    }
    public void highlight(WebElement el)
    {
        js.executeScript("arguments[0].style.border='3px solid red'", el);
    }
    public String getPageTitle()
    {
        return (String) js.executeScript("return document.title;");
    }

}
