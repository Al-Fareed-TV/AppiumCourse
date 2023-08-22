package org.example;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileDriverInitializer {
    public DesiredCapabilities initalizer(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_3a");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("chromedriverExecutable","/Users/testvagrant/Downloads/chromedriver_mac64/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", false);
        capabilities.merge(chromeOptions);
        return capabilities;
    }
}
