package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.objectweb.asm.TypeReference;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class PressGestureLocatorDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Login login = new Login();
        AndroidDriver<MobileElement> driver = login.loginToAccount();
        try{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Press on product image element using its locator
            MobileElement productImage = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView"));
            new TouchAction(driver).press(ElementOption.element(productImage)).release().perform();
            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
            sleep(2000);
            Point productImageCoordinates = productImage.getLocation();
            int productImageXCoordinate = productImageCoordinates.getX();
            int productImageYCoordinate = productImageCoordinates.getY();
            new TouchAction(driver).press(PointOption.point(productImageXCoordinate, productImageYCoordinate)).release().perform();

        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }finally{
            sleep(2000);
            driver.quit();
        }
    }
}
