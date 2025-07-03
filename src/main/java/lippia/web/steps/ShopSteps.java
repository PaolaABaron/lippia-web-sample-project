package lippia.web.steps;

import io.cucumber.java.en.Then;
import lippia.web.services.CheckoutService;

public class ShopSteps {


    @Then("The tax amount should be correct for country (.*) with rate (.*)")
    public void validateTaxAmount(String country, double rate) {
        CheckoutService.selectBillingCountry(country);
        CheckoutService.validateTaxRate(rate, country);
    }
}
