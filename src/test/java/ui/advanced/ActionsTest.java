package ui.advanced;

import oop.testng.BaseTestNG;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTestNG
{
    @Test
    public void testAdvancedActions()
    {
        // 1. Drag and drop – use JS because native Actions is flaky on this site
        getDriver().get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = getDriver().findElement(By.id("column-a"));
        WebElement target = getDriver().findElement(By.id("column-b"));

        // JS drag-drop workaround
        ((JavascriptExecutor)getDriver()).executeScript(
                "function createEvent(type){var e=document.createEvent('CustomEvent');e.initCustomEvent(type,true,null);e.dataTransfer={data:{},setData:function(k,v){this.data[k]=v},getData:function(k){return this.data[k]}};return e} function dispatch(e,t,el){el.dispatchEvent(e)} var s=arguments[0],t=arguments[1],d1=createEvent('dragstart'),d2=createEvent('drop'),d3=createEvent('dragend');dispatch(d1,'dragstart',s);dispatch(d2,'drop',t);dispatch(d3,'dragend',s);",
                source, target);

        // 2. Key press – test a simple key
        getDriver().get("https://the-internet.herokuapp.com/key_presses");
        WebElement input = getDriver().findElement(By.id("target"));
        input.sendKeys("A");

        String result = getDriver().findElement(By.id("result")).getText();
        Assert.assertTrue(result.contains("A"), "Key press failed, got: " + result);
    }
}
