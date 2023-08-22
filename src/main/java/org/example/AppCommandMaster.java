package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppCommandMaster {
    public static void main(String[] args) throws MalformedURLException {
        DriverInitializer driverInitializer = new DriverInitializer();
        DesiredCapabilities desiredCapabilities = driverInitializer.initializeDriver();
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        // Uninstall the Sauce Labs app
        driver.removeApp("io.swaglabs.mobileapp");

        // Install the Sauce Labs app
        driver.installApp("/Users/testvagrant/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // Launch the Sauce Labs app
        driver.launchApp();

        // Reset the Sauce Labs app
        driver.resetApp();
    }
}
