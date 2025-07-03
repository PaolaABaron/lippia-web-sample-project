package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.LandingPageService;
import lippia.web.services.MyAccountService;

public class MyAccountSteps {

    @Then("The message (.*) is shown")
    public void validateErrorMessage(String error) {
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


    @When("The client clicks on 'Log out' link")
    public void ClicksOnLogOutLink() {
        MyAccountService.clickOnLogOut();
    }

    @Then("The client comes out from the site")
    public void verifyLogOut() {
        MyAccountService.verifyLogOut();
    }

    @When("The client registers with email (.*) and password (.*)")
    public void RegistersWithEmailAndPassword(String email, String pass) {
        MyAccountService.setTheEmail(email);
        MyAccountService.setThePass(pass);
        MyAccountService.clickOnRegister();
    }

    @Then("The client sees the error (.*)")
    public void verifyError(String error) {
        MyAccountService.verifyError(error);
    }


    @And("The client clicks on 'Sign out' link")
    public void SignOut() {
        MyAccountService.signOut();
    }

    @When("The client clicks on 'My account' link")
    public void ClicksOnMyAccount() {
        MyAccountService.clicksOnMyAccount();
    }

    @And("The client clicks on 'Account details' link")
    public void ClicksOnAccountDetails() {
        MyAccountService.clicksOnAccountDetails();
    }

    @Then("The account details are shown")
    public void validateAccountDetails() {
        MyAccountService.validateAccountDetails();
    }
}
