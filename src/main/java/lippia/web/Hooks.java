package lippia.web;

import com.crowdar.driver.DriverManager;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@ResetBeforeEach")
    public void resetStateBeforeTaggedExample() {
        DriverManager.getDriverInstance().navigate().refresh();
    }
}
