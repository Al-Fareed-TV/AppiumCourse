package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Login {
    public AndroidDriver<MobileElement> loginToAccount() throws MalformedURLException {
        DriverInitializer driverInitializer = new DriverInitializer();
        DesiredCapabilities caps = driverInitializer.initializeDriver();

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        // Setting the implicit wait for demonstration. Note that using explicit waits is recommended for a more efficient and reliable solution
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-standard_user\"]/android.widget.TextView")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView")).click();
        return driver;
    }
}
