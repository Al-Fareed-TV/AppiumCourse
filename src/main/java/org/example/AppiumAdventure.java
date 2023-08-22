package org.example;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;


import static java.lang.Thread.sleep;

public class AppiumAdventure {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //... continue from previous task
        Login login = new Login();
        AndroidDriver<MobileElement> driver = login.loginToAccount();
        // Scroll until we have "Sauce Labs Onesie" product is found
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\"Sauce Labs Onesie\"))"));
        MobileElement product = driver.findElement(MobileBy.xpath("//*[@text='Sauce Labs Onesie']"));

        product.click();

        // Adding the product to cart by clicking on the add to cart button
        MobileElement addToCartButton = driver.findElement(MobileBy.AccessibilityId("test-ADD TO CART"));
        addToCartButton.click();

        // Clicking on the cart icon
        MobileElement cartIcon = driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"));
        cartIcon.click();

        // Clicking on the proceed to checkout button
        MobileElement proceedToCheckoutButton = driver.findElement(MobileBy.AccessibilityId("test-CHECKOUT"));
        proceedToCheckoutButton.click();

        // Adding checkout details
        MobileElement fullNameField = driver.findElement(MobileBy.AccessibilityId("test-First Name"));
        fullNameField.sendKeys("Rebecca");
        driver.hideKeyboard();

        MobileElement lastname = driver.findElement(MobileBy.AccessibilityId("test-Last Name"));
        lastname.sendKeys("Winter");
        driver.hideKeyboard();

//        MobileElement addressLine2 = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        addressLine2.sendKeys("Entrance 1");
//        driver.hideKeyboard();
//
//        MobileElement cityName = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        cityName.sendKeys("Truro");
//        driver.hideKeyboard();
//
//        MobileElement state = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        state.sendKeys("Cornwall");
//        driver.hideKeyboard();

        MobileElement zipCode = driver.findElement(MobileBy.AccessibilityId("test-Zip/Postal Code"));
        zipCode.sendKeys("89750");
        driver.hideKeyboard();

//        MobileElement country = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        country.sendKeys("United Kingdom");
//        driver.hideKeyboard();

        // Clicking on the payment button to go to payment page
        MobileElement continueButton = driver.findElement(MobileBy.AccessibilityId("test-CONTINUE"));
        continueButton.click();

        driver.findElementByAccessibilityId("test-FINISH").click();

        sleep(2000);

        driver.quit();

        // Quit the driver
    }
}
