package lippia.web.constants;

public class MyAccountConstants {
    public static final String EMAIL_INPUT = "xpath://*[@id='username']";
    public static final String PASS_INPUT = "xpath://*[@id='password']";
    public static final String LOGIN_BUTTON ="xpath://input[@type='submit' and @name='login' and @value='Login']";
    public static final String HELLO_MESSAGE = "xpath://*[@id='page-36']//p[contains(text(), 'Hello')]";
    public static final String EMAIL_ERROR= "xpath://li[contains(text(), 'A user could not be found')]";
    public static final String PASS_ERROR= "xpath://ul[contains(@class, 'woocommerce-error')]/li";
    public static final String EMAIL_REQUIRED_ERROR= "xpath://ul[contains(@class, 'woocommerce-error')]/li/strong";
    public static final String PASS_REQUIRED_ERROR= "xpath://li[contains(text(), 'Password is required')]";
    public static final String ORDERS_LINK = "xpath://a[contains(text(), 'Orders')]";
    public static final String LOGOUT_LINK = "xpath://a[text()='Logout']";
    public static final String LOGIN_PAGE = "xpath://h2[text()='Login']";
    public static final String EMAIL_REGISTER_INPUT = "xpath://input[@id='reg_email']";
    public static final String PASS_REGISTER_INPUT = "xpath://input[@id='reg_password']";
    public static final String REGISTER_BUTTON = "xpath://input[@name='register']";
    public static final String EMAIL_REGISTER_ERROR = "xpath://li[contains(., 'Error:') and contains(., 'valid email address')]";
    public static final String PASS_REGISTER_ERROR = "xpath://li[contains(., 'Error:') and contains(., 'account password')]";
}
