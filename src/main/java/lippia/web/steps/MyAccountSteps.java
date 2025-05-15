package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.LandingPageService;
import lippia.web.services.MyAccountService;
import lippia.web.services.OrdersService;
import lippia.web.utils;

public class MyAccountSteps {
    @Then("The client is on the home page")
    public void HomePage() {
        MyAccountService.verifyMessage();
    }

    @Then("The message {string} is shown")
    public void theMessageIsShown(String error) {
        MyAccountService.validateError(error);

    }

    @Given("The client is on my account page with email {string} and password {string}")
    public void MyAccountPage(String email, String pass) {
        LandingPageService.navegarWeb();
        LandingPageService.clickOnMyAccount();
        MyAccountService.setEmail(email);
        MyAccountService.setPass(pass);
        MyAccountService.clickOnLogin();
    }


    @Then("The orders are shown")
    public void verifyOrders() {
        OrdersService.verifyOrdersVisible();
    }

    @And("The client clicks on 'VIEW' button")
    public void ClicksOnVIEWButton() {
        OrdersService.clickOnView();
    }

    @Then("The orders details are shown")
    public void verifyOrdersDetails() {
        OrdersService.verifyOrdersDetails();
    }

    @When("The client clicks on 'Orders' link")
    public void ClicksOnOrdersLink() {
        MyAccountService.clickOnOrders();
    }

    @When("The client clicks on 'Log out' link")
    public void ClicksOnLogOutLink() {
        MyAccountService.clickOnLogOut();
    }

    @Then("The client comes out from the site")
    public void verifyLogOut() {
        MyAccountService.verifyLogOut();
    }

    @When("The client registers with email {string} and password {string}")
    public void RegistersWithEmailAndPassword(String email, String pass) {
        MyAccountService.setTheEmail(email);
        MyAccountService.setThePass(pass);
        MyAccountService.clickOnRegister();
    }

    @Then("The {string} is shown")
    public void verifyError(String error) {
        MyAccountService.verifyError(error);
    }

    @When("The client registers with the email {string} and the password {string}")
    public void RegistersWithTheEmailAndThePassword(String email, String pass) {
        email = utils.correoAleatorio(email);
        MyAccountService.setCredentials(email,pass);
        MyAccountService.clickOnRegister();
    }
}
