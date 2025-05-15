package lippia.web.constants;

public class OrdersConstants {

    public static final String ORDERS = "xpath://a[contains(text(), 'Orders')]";
    public static final String VIEW_BUTTON = "xpath://a[contains(@href, '/view-order/') and contains(@class, 'button') and text()='View']";
    public static final String ORDERS_DETAILS = "xpath://h2[contains(text(), 'Order Details')]";
}
