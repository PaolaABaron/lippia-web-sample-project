package lippia.web.services;

import com.crowdar.driver.DriverManager;
import lippia.web.constants.ProductConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.crowdar.core.actions.ActionManager.getElement;

public class ProductService {

    public static void clickOnAddToBasket() {
        WebElement element = getElement(ProductConstants.ADD_TO_BASKET);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);

    }

    public static void clickOnItemLink() {
        WebElement element = getElement(ProductConstants.ITEM_LINK);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);

    }
}
