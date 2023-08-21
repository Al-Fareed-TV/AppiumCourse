package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TapGestureDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Login login = new Login();
        AndroidDriver<MobileElement> driver = login.loginToAccount();

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement productImage = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView"));
            new TouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(productImage))).perform();

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            sleep(3000);
            driver.quit();
        }

    }
}
