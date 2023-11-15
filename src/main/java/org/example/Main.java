package org.example;
import io.appium.java_client.AppiumDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class Main {

    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        // Initialize the driver using AppiumConfig
        driver = AppiumTest.getDriver();
    }

    @Test
    public void myTest() {
        // Write your test logic here using Appium commands
        // Example: driver.findElementByAccessibilityId("myElement").click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
