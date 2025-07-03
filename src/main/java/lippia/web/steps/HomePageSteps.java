package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.*;

public class HomePageSteps {


    @Given("The client is on checkout page")
    public void goToCheckoutPage() {
        String defaultProduct= "Selenium Ruby";
        LandingPageService.navegarWeb();
        LandingPageService.clickOnProduct(defaultProduct);
        ProductService.clickOnAddToBasket();
        ProductService.clickOnItemLink();
        BasketService.clickOnProceedToCheckout();
    }

    @Then("The billing, order and payment details are shown")
    public void verifyCheckoutDetails() {
        CheckoutService.verifyCheckoutDetails();

    }

    @When("The client sets:(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)")
    public void SetBillingDetails(String firstName,String lastName,String emailAddress,String phone,String country,String address,String city,String state,String postcode) {
        CheckoutService.setBillingDetails(firstName,lastName,emailAddress,phone,country,address,city,state,postcode);

    }

    @And("The client selects 'Cash on Delivery' payment method")
    public void SelectPaymentMethod() {
        CheckoutService.selectPaymentMethod();
    }

    @And("The client clicks on 'Place Order' button")
    public void ClicksOnPlaceOrder() {
        CheckoutService.placeOrder();
    }

    @Then("The order details are shown")
    public void validateOrderDetails() {
        OrderDetailsService.validateOrder();
    }
}
