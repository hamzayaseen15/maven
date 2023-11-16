package org.example;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Main {

    private AppiumDriver driver;
    private final String platformVersion;
    private final String udid;
    private final TestScenario testScenario;

    private ExtentReports extent;
    private ExtentTest extentTest;

    public enum TestScenario {
        INITIATE_CALL,
        RECEIVE_CALL
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"7.0", "R38GA09C3CW", TestScenario.INITIATE_CALL},
//                {"device_version_2", "device_udid_2", TestScenario.RECEIVE_CALL},
        });
    }

    public Main(String platformVersion, String udid, TestScenario testScenario) {
        this.platformVersion = platformVersion;
        this.udid = udid;
        this.testScenario = testScenario;
    }

    @Before
    public void setUp() throws MalformedURLException {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("results123/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        driver = AppiumTest.getDriver(platformVersion, udid);
//        driver = null;

        extentTest = extent.createTest(testScenario.name());

    }

    @Test
    public void myTest() {
        switch (testScenario) {
            case INITIATE_CALL:

                break;

            case RECEIVE_CALL:

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + testScenario);
        }
    }

    @After
    public void tearDown() {
        if (driver == null) {
            extentTest.log(Status.FAIL, "Test failed");
        }
        if (driver != null) {
            driver.quit();
        }
        extent.flush();

    }
}
