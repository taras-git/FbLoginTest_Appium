package com.setup;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class BaseTest {

    public static AppiumDriver driver;
    private String testCaseName;
    private long testStartTime;
    private long testFinishTime;
    private long testDurationTime;
    private String testFailedMsg;

    public AppiumDriver getDriver() {
        return driver;
    }

    protected long getTestStartTime() {
        return testStartTime;
    }

    protected void setTestStartTime(long testStartTime) {
        this.testStartTime = testStartTime;
    }

    protected long getTestFinishTime() {
        return testFinishTime;
    }

    protected void setTestFinishTime(long testFinishTime) {
        this.testFinishTime = testFinishTime;
    }

    protected long getTestDurationTime() {
        return testDurationTime;
    }

    protected void setTestDurationTime(long testDurationTime) {
        this.testDurationTime = testDurationTime;
    }

    protected String getTestCaseName() {
        return testCaseName;
    }

    protected void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestFailedMsg() {
        return testFailedMsg;
    }

    public void setTestFailedMsg(String testFailedMsg) {
        this.testFailedMsg = testFailedMsg;
    }


    @BeforeSuite()
    public void setUp() throws MalformedURLException, InterruptedException, FileNotFoundException {
        driver = DeviceSetup.prepareDevice();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}