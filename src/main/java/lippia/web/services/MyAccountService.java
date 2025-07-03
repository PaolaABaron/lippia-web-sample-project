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

    public static void validateError(String error) {
        WebActionManager.waitVisibility(MyAccountConstants.PASS_ERROR);
        Assert.assertTrue(isVisible(MyAccountConstants.PASS_ERROR));
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


    public static void setInvalidCredentials(String email, String pass) {
        WebActionManager.setInput(MyAccountConstants.EMAIL_INPUT, email);
        WebActionManager.setInput(MyAccountConstants.PASS_INPUT,pass);
    }

    public static void setValidCredentials(String email, String pass) {
        WebActionManager.setInput(MyAccountConstants.EMAIL_INPUT, email);
        WebActionManager.setInput(MyAccountConstants.PASS_INPUT,pass);
    }

    public static void signOut() {
        WebElement element = getElement(MyAccountConstants.SIGN_OUT_LINK);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);
    }

    public static void navigatesBack() {
        DriverManager.getDriverInstance().navigate().back();
    }

    public static void validateLoginPage() {
        Assert.assertTrue(WebActionManager.isVisible(MyAccountConstants.LOGIN_TITLE));
    }

    public static void clicksOnMyAccount() {
        WebElement element = getElement(MyAccountConstants.MY_ACCOUNT_LINK);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);

    }

    public static void clicksOnAccountDetails() {
        WebElement element = getElement(MyAccountConstants.ACCOUNT_DETAILS_LINK);
        ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].click();", element);

    }

    public static void validateAccountDetails() {
        WebActionManager.waitVisibility (MyAccountConstants.PASSWORD_CHANGE_TITLE);
        Assert.assertTrue(isVisible(MyAccountConstants.PASSWORD_CHANGE_TITLE));

    }
}


