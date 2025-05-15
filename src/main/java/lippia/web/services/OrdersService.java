package lippia.web.services;

import com.crowdar.driver.DriverManager;
import junit.framework.Assert;
import lippia.web.constants.OrdersConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.crowdar.core.actions.ActionManager.getElement;
import static com.crowdar.core.actions.ActionManager.isVisible;

public class OrdersService {

    public static void verifyOrdersVisible() {
        Assert.assertTrue(isVisible(OrdersConstants.ORDERS));
    }

    public static void clickOnView() {
        WebElement element = getElement(OrdersConstants.VIEW_BUTTON);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);

    }

    public static void verifyOrdersDetails() {
        Assert.assertTrue(isVisible(OrdersConstants.ORDERS_DETAILS));
    }
}
