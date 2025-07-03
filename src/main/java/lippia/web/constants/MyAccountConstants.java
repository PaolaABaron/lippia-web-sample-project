package lippia.web.constants;

public class MyAccountConstants {
    public static final String EMAIL_INPUT = "xpath://*[@id='username']";
    public static final String PASS_INPUT = "xpath://*[@id='password']";
    public static final String LOGIN_BUTTON ="xpath://input[@type='submit' and @name='login' and @value='Login']";
    public static final String PASS_ERROR= "xpath://li[strong[text()='Error:'] and contains(., 'The password you entered for the username') and contains(., 'is incorrect.')]";
    public static final String LOGOUT_LINK = "xpath://a[text()='Logout']";
    public static final String LOGIN_PAGE = "xpath://h2[text()='Login']";
    public static final String EMAIL_REGISTER_INPUT = "xpath://input[@id='reg_email']";
    public static final String PASS_REGISTER_INPUT = "xpath://input[@id='reg_password']";
    public static final String REGISTER_BUTTON = "xpath://input[@name='register']";
    public static final String EMAIL_REGISTER_ERROR = "xpath://li[contains(., 'Error:') and contains(., 'valid email address')]";
    public static final String PASS_REGISTER_ERROR = "xpath://li[contains(., 'Error:') and contains(., 'account password')]";
    public static final String SIGN_OUT_LINK = "xpath://a[normalize-space()='Sign out']";
    public static final String LOGIN_TITLE = "xpath://h2[normalize-space()='Login']";
    public static final String MY_ACCOUNT_LINK = "xpath://a[normalize-space()='My Account']";
    public static final String ACCOUNT_DETAILS_LINK = "xpath://a[normalize-space()='Account Details']";
    public static final String PASSWORD_CHANGE_TITLE = "xpath://legend[normalize-space()='Password Change']";
}
