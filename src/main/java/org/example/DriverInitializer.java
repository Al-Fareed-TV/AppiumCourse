package org.example;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverInitializer {
    public DesiredCapabilities initializeDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Oppo_A76");
        caps.setCapability("udid", "emulator-5554"); // You can get it from 'adb devices' command
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/testvagrant/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk"); // Replace with your app's path
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        return caps;
    }
}
