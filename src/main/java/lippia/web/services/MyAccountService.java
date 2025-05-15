package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import junit.framework.Assert;
import lippia.web.constants.MyAccountConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.crowdar.core.actions.ActionManager.isVisible;
import static com.crowdar.core.actions.WebActionManager.getElement;

public class MyAccountService {
    public static void setEmail(String email) {
        WebActionManager.setInput(MyAccountConstants.EMAIL_INPUT, email);
    }

    public static void setPass(String pass) {
        WebActionManager.setInput(MyAccountConstants.PASS_INPUT,pass);
    }

    public static void clickOnLogin() {
        WebElement element = getElement(MyAccountConstants.LOGIN_BUTTON);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }
    public static void clickOnOrders() {
        WebElement element = getElement(MyAccountConstants.ORDERS_LINK);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }
    public static void verifyMessage() {
        WebActionManager.waitVisibility (MyAccountConstants.HELLO_MESSAGE);
        Assert.assertTrue(isVisible(MyAccountConstants.HELLO_MESSAGE));

    }

    public static void validateError(String error) {
        String errorToValidate;

        if (error.equalsIgnoreCase("Error: A user could not be found with this email address.")) {
            errorToValidate = MyAccountConstants.EMAIL_ERROR;
        } else if (error.equalsIgnoreCase("Error: Password is required.")) {
            errorToValidate = MyAccountConstants.PASS_REQUIRED_ERROR;
        } else if (error.equalsIgnoreCase("Error: Username is required.")) {
            errorToValidate = MyAccountConstants.EMAIL_REQUIRED_ERROR;
        } else if (error.startsWith("Error: The password you entered")) {
            errorToValidate = MyAccountConstants.PASS_ERROR;
        } else {
            throw new IllegalArgumentException("Error no reconocido: " + error);
        }

        WebActionManager.waitVisibility(errorToValidate);
        Assert.assertTrue(isVisible(errorToValidate));
    }

    public static void clickOnLogOut() {
        WebElement element = getElement(MyAccountConstants.LOGOUT_LINK);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }

    public static void verifyLogOut() {
        Assert.assertTrue(isVisible(MyAccountConstants.LOGIN_PAGE));
    }

    public static void setTheEmail(String email) {
        WebActionManager.setInput(MyAccountConstants.EMAIL_REGISTER_INPUT, email);
    }

    public static void setThePass(String pass) {
        WebActionManager.setInput(MyAccountConstants.PASS_REGISTER_INPUT, pass);
    }

    public static void clickOnRegister() {
        WebElement element = getElement(MyAccountConstants.REGISTER_BUTTON);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }

    public static void verifyError(String error) {
        String errorToValidate;

        if (error.equalsIgnoreCase(" Error: Please provide a valid email address.")) {
            errorToValidate = MyAccountConstants.EMAIL_REGISTER_ERROR;
        } else if (error.equalsIgnoreCase("Error: Please enter an account password.")) {
            errorToValidate = MyAccountConstants.PASS_REGISTER_ERROR;
        }else if (error.equalsIgnoreCase("Error: Please provide a valid email address.")) {
                errorToValidate = MyAccountConstants.EMAIL_REGISTER_ERROR;
        } else {
            throw new IllegalArgumentException("Error no reconocido: " + error);
        }

        WebActionManager.waitVisibility(errorToValidate);
        Assert.assertTrue(isVisible(errorToValidate));
    }

    public static void setCredentials(String email, String pass) {
        WebActionManager.setInput(MyAccountConstants.EMAIL_REGISTER_INPUT, email);
        WebActionManager.setInput(MyAccountConstants.PASS_REGISTER_INPUT, pass);

    }
}


