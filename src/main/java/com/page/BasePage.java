package com.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;


class BasePage {

    public AppiumDriver driver;
    public Wait<WebDriver> wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
    }

    void click(By element) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    String getText(By element) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    boolean isEnableElement(By element) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
        return true;
    }

    void assertText(By element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertEquals(driver.findElement(element).getText(),"");
    }
}