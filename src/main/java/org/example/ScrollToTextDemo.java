package org.example;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ScrollToTextDemo {
    public static void main(String[] args) throws MalformedURLException {
        // Initialize the driver and launch the app
        DriverInitializer driverInitializer = new DriverInitializer();
        DesiredCapabilities desiredCapabilities = driverInitializer.initializeDriver();
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        // Setting the implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\"And the password for all users is:\"))"));

        driver.quit();
    }
}
