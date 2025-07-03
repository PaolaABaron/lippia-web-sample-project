package lippia.web;

import com.crowdar.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class Utils {


    public static void scrollIntoView(By locator) {
        WebElement element = DriverManager.getDriverInstance().findElement(locator);
        JavascriptExecutor jse = DriverManager.getDriverInstance();
        jse.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

}