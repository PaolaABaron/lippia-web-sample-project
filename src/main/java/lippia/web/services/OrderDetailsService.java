package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.OrderDetailsConstants;
import org.testng.Assert;

public class OrderDetailsService {


    public static void validateOrder() {
        WebActionManager.waitVisibility(OrderDetailsConstants.ORDER_DETAILS_TITLE);
        Assert.assertTrue(WebActionManager.isVisible(OrderDetailsConstants.ORDER_DETAILS_TITLE));

    }
}
