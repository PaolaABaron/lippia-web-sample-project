package lippia.web.constants;

public class ShopConstants {

    public static final String ANDROID_CATEGORY = "xpath://div[@id='woocommerce_product_categories-2']//a[text()='Android']";
    public static final String HTML_CATEGORY = "xpath://ul[@class='product-categories']/li/a[text()='HTML']";
    public static final String JAVASCRIPT_CATEGORY = "xpath://ul[contains(@class, 'product-categories')]//a[normalize-space()='JavaScript']";
    public static final String SELENIUM_CATEGORY = "xpath://ul[contains(@class, 'product-categories')]//a[normalize-space()='selenium']";
    public static final String HOME_MENU_BUTTON = "xpath://div[@id='content']//nav//a";
    public static final String DEFAULT_SORTING_DROPDOWN = "xpath://select[@name='orderby']";
    public static final String PRODUCT_LIST = "//li[contains(@class, 'product')]";
}
