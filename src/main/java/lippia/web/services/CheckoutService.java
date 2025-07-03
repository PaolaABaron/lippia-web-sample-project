package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.Utils;
import lippia.web.constants.CheckoutConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.crowdar.core.actions.ActionManager.getElement;

public class CheckoutService {

    public static void verifyCheckoutDetails() {
        Assert.assertTrue(WebActionManager.isVisible(CheckoutConstants.BILLING_DETAILS_TITLE));
    }

    public static void setBillingDetails(String firstName,String lastName,String emailAddress,String phone,String country,String address,String city,String state,String postcode) {
        WebActionManager.setInput(CheckoutConstants.FIRST_NAME_INPUT,firstName);
        WebActionManager.setInput(CheckoutConstants.LAST_NAME_INPUT,lastName);
        Utils.scrollIntoView(By.xpath(CheckoutConstants.EMAIL_ADDRESS_INPUT.replace("xpath:", "")));
        WebActionManager.setInput(CheckoutConstants.EMAIL_ADDRESS_INPUT,emailAddress);
        WebActionManager.setInput(CheckoutConstants.PHONE_INPUT,phone);
        WebElement element = getElement(CheckoutConstants.COUNTRY_DROPDOWN);
        ((JavascriptExecutor) DriverManager.getDriverInstance())
                .executeScript("var evt = new MouseEvent('mousedown', {bubbles: true}); arguments[0].dispatchEvent(evt);", element);
        WebActionManager.setInput(CheckoutConstants.COUNTRY_INPUT,country);
        DriverManager.getDriverInstance().findElement(By.tagName("body")).click();
        WebActionManager.setInput(CheckoutConstants.ADDRESS_INPUT,address);
        WebActionManager.setInput(CheckoutConstants.CITY_INPUT,city);
        WebElement element2 = getElement(CheckoutConstants.STATE_DROPDOWN);
        ((JavascriptExecutor) DriverManager.getDriverInstance())
                .executeScript("var evt = new MouseEvent('mousedown', {bubbles: true}); arguments[0].dispatchEvent(evt);", element2);
        WebActionManager.setInput(CheckoutConstants.STATE_INPUT,state);
        WebActionManager.setInput(CheckoutConstants.POSTCODE_INPUT,postcode);
    }

    public static void selectPaymentMethod() {
        WebElement element = getElement(CheckoutConstants.PAYMENT_RADIO_BUTTON);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);

    }

    public static void placeOrder() {
        WebElement element = getElement(CheckoutConstants.PLACE_ORDER_BUTTON);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }

    public static void selectBillingCountry(String country) {
        Utils.scrollIntoView(By.xpath(CheckoutConstants.COUNTRY_DROPDOWN.replace("xpath:", "")));
        WebDriver driver = DriverManager.getDriverInstance();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement dropdown = driver.findElement(By.xpath(CheckoutConstants.COUNTRY_DROPDOWN.replace("xpath:", "")));
        dropdown.click();

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CheckoutConstants.COUNTRY_INPUT.replace("xpath:", ""))));
        input.clear();
        input.sendKeys(country);

        String optionXpath = String.format(CheckoutConstants.COUNTRY_OPTION.replace("xpath:", ""), country);
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        option.click();
    }

    public static double getSubtotal() {

        return getAmount(CheckoutConstants.SUBTOTAL_AMOUNT);
    }

    public static double getTotal() {
        return getAmount(CheckoutConstants.TOTAL_AMOUNT);
    }

    private static double getAmount(String locator) {
        String text = DriverManager.getDriverInstance().findElement(By.cssSelector(locator)).getText();
        return Double.parseDouble(text.replaceAll("[^\\d.]", ""));
    }
    public static void validateTaxRate(double expectedRate, String country) {
        double subtotal = CheckoutService.getSubtotal();
        double total = CheckoutService.getTotal();
        double actualTax = total - subtotal;
        double expectedTax = subtotal * (expectedRate / 100);

        Assert.assertTrue(Math.abs(actualTax - expectedTax) < 0.01,
                "Expected tax for " + country + " was " + expectedTax + " but found " + actualTax);
    }

}
