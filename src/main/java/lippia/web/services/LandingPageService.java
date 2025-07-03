package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.LandingPageConstants;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class LandingPageService {
    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void clickOnMyAccount() {

        WebActionManager.click(LandingPageConstants.MY_ACCOUNT_BUTTON);
    }

    public static void clickOnProduct(String defaultProduct) {
        WebActionManager.click(LandingPageConstants.SELENIUM_IMAGE);

    }
}
