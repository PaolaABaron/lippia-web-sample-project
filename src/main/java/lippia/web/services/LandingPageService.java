package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import junit.framework.Assert;
import lippia.web.constants.LandingPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.crowdar.core.actions.ActionManager.getElement;
import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class LandingPageService {
    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void clickOnMyAccount() {
        WebActionManager.click(LandingPageConstants.MY_ACCOUNT_BUTTON);
    }

    public static void clickOnShop() {
        WebActionManager.click(LandingPageConstants.SHOP_BUTTON);
    }

    public static void verifySliders() {
        List<WebElement> slides = DriverManager.getDriverInstance()
                .findElements(By.xpath("//div[@id='n2-ss-6']//div[contains(@class, 'n2-ss-layers-container')]"));
        Assert.assertEquals("Expected exactly 3 slides", 3, slides.size());
    }

    public static void verifyArrivals() {
        List<WebElement> arrivals = DriverManager.getDriverInstance()
                .findElements(By.xpath("//ul[@class='products']/li[.//h3[text()='Selenium Ruby']] | //ul[@class='products']/li[.//h3[text()='Thinking in HTML']] | //ul[@class='products']/li[.//h3[text()='Mastering JavaScript']]"));
        Assert.assertEquals("Expected exactly 3 arrivals", 3, arrivals.size());
    }

    public static void clickOnProduct(String product) {
        String locator;

        switch (product.toLowerCase()) {

            case "selenium":
                locator = LandingPageConstants.SELENIUM_IMAGE;
                break;
            case "html":
                locator = LandingPageConstants.HTML_IMAGE;
                break;
            case "javascript":
                locator = LandingPageConstants.JAVASCRIPT_IMAGE;
                break;

            default:
                throw new IllegalArgumentException("Invalid product: " + product);
        }

        WebElement element = getElement(locator);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }
}
