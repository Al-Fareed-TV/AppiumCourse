package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginInteractionDemo {
    public static void main(String[] args) throws MalformedURLException {
        DriverInitializer driverInitializer = new DriverInitializer();
        DesiredCapabilities caps = driverInitializer.initializeDriver();

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);

        try{
            // Setting the implicit wait. Note that using explicit waits is recommended for a more efficient and reliable solution
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Identify the username field, send keys, and hide keyboard
            MobileElement usernameField = driver.findElementByAccessibilityId("test-Username");
            usernameField.sendKeys("abc");
            driver.hideKeyboard();

            // Identify the password field, send keys, and hide keyboard
            MobileElement passwordField = driver.findElementByAccessibilityId("test-Password");
            passwordField.sendKeys("123345");
            driver.hideKeyboard();

            driver.findElementByAccessibilityId("test-LOGIN").click();

            Thread.sleep(4000);
        }catch (Exception e){
            System.out.println("Encountered error : "+e.getLocalizedMessage());
        }finally {
            driver.quit();
        }
    }
}
