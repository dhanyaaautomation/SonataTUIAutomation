package org.sonatatui.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonatatui.drivers.DriverManager;

import java.time.Duration;
import java.util.Collections;

public class BasePage {

    protected void click(WebElement element) {
        explicitWait(element);
        element.click();
    }

    protected void click(By by) {

        click(DriverManager.getDriver().findElement(by));
    }

    protected void sendKeys(WebElement element, String value) {
        explicitWait(element);
        element.sendKeys(value);
    }

    public static void scroll(){

        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.10);

        //To do swipe actions y coordinate remains x changes
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence1 = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(50)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(),endX,endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) DriverManager.getDriver())
                .perform(Collections.singletonList(sequence1));

    }

    public static void scrollToSpecificElement(By by){

        while(DriverManager.getDriver().findElements(by).isEmpty())
        {
            Dimension size = DriverManager.getDriver().manage().window().getSize();
            int startX = size.getWidth() / 2;
            int startY = size.getHeight() / 2;
            int endX = startX;
            int endY = (int) (size.getHeight() * 0.8);

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

            Sequence sequence1 = new Sequence(finger1,1)
                    .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1,Duration.ofMillis(200)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(),endX,endY))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            ((AppiumDriver) DriverManager.getDriver())
                    .perform(Collections.singletonList(sequence1));

        }
        if(!DriverManager.getDriver().findElements(by).isEmpty()){
            DriverManager.getDriver().findElement(by).click();
        }
    }

    protected void explicitWait(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .withMessage("")
                .pollingEvery(Duration.ofSeconds(5)).until(ExpectedConditions
                        .visibilityOf(element));

    }
}
