package com.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DeviceSetup extends BaseTest {

    static AppiumDriver prepareDevice() throws MalformedURLException {
        final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
        URL url = new URL(URL_STRING);
        DesiredCapabilities capabilities;
        IOSDriver<IOSElement> driver;

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability("useNewWDA", false);

        driver = new IOSDriver<>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, SECONDS);

        return driver;
    }
}