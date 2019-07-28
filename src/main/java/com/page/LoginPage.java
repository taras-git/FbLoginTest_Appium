package com.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    
    public void loginUnsuccessful() {
        driver.get("http://m.facebook.com/");

        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.getText().contains("Log In"));

        WebElement email = driver.findElementById("m_login_email");
        email.sendKeys("somefakeemail@qmail.com");

        WebElement password = driver.findElementById("m_login_password");
        password.sendKeys("qwerty");

        WebElement loginButton = driver.findElementByName("login");
        loginButton.click();

        WebElement warningMessage = wait.until(driver -> driver.findElement(By.xpath("//div[@data-sigil='m_login_notice']")));

        System.out.println("Login was not successful");
    }
}