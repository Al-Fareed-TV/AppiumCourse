package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MobileElementMethodsDemo {
    public static void main(String[] args) throws MalformedURLException {
        Login login = new Login();
        AndroidDriver<MobileElement> driver = login.loginToAccount();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Replace "Your_Locator_Strategy" and "Your_Locator_Value" with the appropriate locator strategy and value
        List<MobileElement> productTitles = driver.findElements(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])"));
        System.out.println("Size of the product titles - " + productTitles.size());
        System.out.println("Get the text of single product title - " + productTitles.get(0).getText());
        System.out.println("Get attribute of the product title element - " + productTitles.get(0).getAttribute("package"));
        System.out.println("Is product title element displayed - " + productTitles.get(0).isDisplayed());
        System.out.println("Is product title selected selected - " + productTitles.get(0).isSelected());
        System.out.println("Is product title element enabled - " + productTitles.get(0).isEnabled());
        System.out.println("Get the tag name of product title - " + productTitles.get(0).getTagName());
        System.out.println(productTitles);
        driver.quit();
    }
}