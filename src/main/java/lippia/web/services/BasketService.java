package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.Utils;
import lippia.web.constants.BasketConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.crowdar.core.actions.ActionManager.getElement;

public class BasketService {

    public static void clickOnProceedToCheckout() {
        Utils.scrollIntoView(By.xpath(BasketConstants.PROCEED_TO_CHECKOUT_BUTTON.replace("xpath:", "")));
        WebActionManager.waitVisibility(BasketConstants.PROCEED_TO_CHECKOUT_BUTTON);
        WebElement element = getElement(BasketConstants.PROCEED_TO_CHECKOUT_BUTTON);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);

    }
}
