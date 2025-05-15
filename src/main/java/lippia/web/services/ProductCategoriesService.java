package lippia.web.services;

import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.ProductCategoriesConstants;
import org.testng.Assert;

public class ProductCategoriesService {

    public static void verifyProductVisible(String expectedProduct) {
        String productLocator;

        switch (expectedProduct.toLowerCase()) {
            case "android":
                productLocator = ProductCategoriesConstants.ANDROID_PRODUCT;
                break;
            case "html":
                productLocator = ProductCategoriesConstants.HTML_PRODUCT;
                break;
            case "javascript":
                productLocator = ProductCategoriesConstants.JAVASCRIPT_PRODUCT;
                break;
            case "selenium":
                productLocator = ProductCategoriesConstants.SELENIUM_PRODUCT;
                break;
            default:
                throw new IllegalArgumentException("Unknown product: " + expectedProduct);
        }

        boolean isVisible = WebActionManager.isVisible(productLocator);
        Assert.assertTrue(isVisible, "Expected product '" + expectedProduct + "' was not visible");
    }

}
