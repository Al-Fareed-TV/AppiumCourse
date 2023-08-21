package org.example;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductListDemo {
    public static void main(String[] args) throws MalformedURLException {
        DriverInitializer driverInitializer= new DriverInitializer();
        DesiredCapabilities caps = driverInitializer.initializeDriver();

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);;
        // Set up an implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-standard_user\"]/android.widget.TextView")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView")).click();


        // Use your identified locator strategy to find the product title elements
        List<MobileElement> productTitles = driver.findElements(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])"));

        // Loop through each title element and print them to the console
        for(MobileElement productTitle : productTitles){
            System.out.println("The product title: " + productTitle.getText());
        }

        driver.quit();
    }
}
