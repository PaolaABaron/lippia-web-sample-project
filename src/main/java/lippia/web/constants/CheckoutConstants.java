package lippia.web.constants;

public class CheckoutConstants {


    public static final String BILLING_DETAILS_TITLE = "xpath://h3[contains(text(), 'Billing Details')]";
    public static final String FIRST_NAME_INPUT = "xpath://input[@id='billing_first_name']";
    public static final String LAST_NAME_INPUT = "xpath://input[@id='billing_last_name']";
    public static final String EMAIL_ADDRESS_INPUT = "xpath://input[@id='billing_email']";
    public static final String PHONE_INPUT = "xpath://input[@id='billing_phone']";
    public static final String COUNTRY_DROPDOWN = "xpath://div[contains(@class,'country_to_state')]//a[contains(@class,'select2-choice')]";
    public static final String COUNTRY_INPUT = "xpath://input[@aria-owns='select2-results-1']";
    public static final String COUNTRY_OPTION = "xpath://li[contains(@class,'select2-result') and normalize-space(.)='%s']";
    public static final String ADDRESS_INPUT = "xpath://input[@id='billing_address_1']";
    public static final String CITY_INPUT = "xpath://input[@id='billing_city']";
    public static final String STATE_DROPDOWN = "xpath://span[@id='select2-chosen-2']/ancestor::a";
    public static final String STATE_INPUT = "xpath://input[@aria-owns='select2-results-2']";
    public static final String POSTCODE_INPUT = "xpath://input[@id='billing_postcode']";
    public static final String PAYMENT_RADIO_BUTTON = "xpath://input[@id='payment_method_cod']";
    public static final String PLACE_ORDER_BUTTON = "xpath://input[@id='place_order']";
    public static final String SUBTOTAL_AMOUNT = ".cart-subtotal .amount";
    public static final String TOTAL_AMOUNT = ".order-total .amount";
}
