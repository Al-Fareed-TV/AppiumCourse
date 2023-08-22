package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.Set;

import static java.lang.Thread.sleep;

public class WebViewContextSwitch {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Login login = new Login();
        AndroidDriver<MobileElement> driver = login.loginToAccount();

        try {
            MobileElement burgerIcon = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView"));
            burgerIcon.click();
            sleep(2000);
            MobileElement webviewButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-WEBVIEW\"]"));
            webviewButton.click();

            MobileElement webURLInputField = driver.findElementByAccessibilityId("test-enter a https url here...");
            webURLInputField.sendKeys("https://www.ultralesson.ai");

            MobileElement goToSite = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-GO TO SITE\"]/android.widget.TextView"));
            goToSite.click();

            Set<String> contextHandles = driver.getContextHandles();

            sleep(10000);

            for (String context : contextHandles) {
                System.out.println(context);
                if (context.contains("WEBVIEW")) {
                    driver.context(context);
                    break;
                }
            }

            System.out.println("Title of webpage: " + driver.getTitle());

            driver.context("NATIVE_APP");

            burgerIcon.click();

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally {
            sleep(3000);
            driver.quit();
        }

    }
}

