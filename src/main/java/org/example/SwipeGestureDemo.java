package org.example;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.lang.Thread.sleep;

public class SwipeGestureDemo {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        // Initialize the driver and launch the app
        Login login = new Login();
        AndroidDriver<MobileElement> driver = login.loginToAccount();
        // Setting the implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sleep(2999);
        int startX = 300; // Starting X coordinate
        int startY = 500; // Starting Y coordinate
        int endX = 300; // Ending X coordinate
        int endY = 100; // Ending Y coordinate
        int duration = 2000; // Duration of the swipe (in milliseconds)

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();

        // Add a wait time to observe the action
        sleep(1500);

        driver.quit();
    }
}