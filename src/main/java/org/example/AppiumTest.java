package org.example;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumTest {

    public static AppiumDriver getDriver(String platformVersion, String udid) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set your desired capabilities here
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", udid);
        capabilities.setCapability("appPackage", "com.whatsapp");
        capabilities.setCapability("appActivity", "com.whatsapp.Main");
        capabilities.setCapability("platformVersion", platformVersion);

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
