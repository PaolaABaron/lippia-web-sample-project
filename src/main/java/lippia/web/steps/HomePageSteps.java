package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.LandingPageService;
import lippia.web.services.ProductService;
import lippia.web.services.ShopService;

public class HomePageSteps {


    @Given("The client is on home page")
    public void LandingPage() {
        LandingPageService.navegarWeb();
        LandingPageService.clickOnShop();
        ShopService.clickOnHome();
    }

    @Then("Only three sliders are shown")
    public void verifyOnlyThreeSliders() {
        LandingPageService.verifySliders();
    }

    @Then("Only three arrivals are shown")
    public void verifyOnlyThreeArrivals() {
        LandingPageService.verifyArrivals();
    }

    @When("The client clicks on {string} image")
    public void ClicksOnProduct(String product) {
        LandingPageService.clickOnProduct(product);
    }

    @And("The client clicks on 'Reviews' button")
    public void ClicksOnReviews() {
        ProductService.clickOnReview();
    }


    @Then("The review for the product is shown")
    public void verifyReviewForTheProduct() {
        ProductService.verifyReview();
    }
}
