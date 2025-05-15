package lippia.web.services;

import com.crowdar.driver.DriverManager;
import junit.framework.Assert;
import lippia.web.constants.ProductConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.crowdar.core.actions.ActionManager.getElement;
import static com.crowdar.core.actions.ActionManager.isVisible;

public class ProductService {

    public static void clickOnReview() {
        WebElement element = getElement(ProductConstants.REVIEW_BUTTON);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }


    public static void verifyReview() {
        Assert.assertTrue(isVisible(ProductConstants.REVIEWS));
    }
}
