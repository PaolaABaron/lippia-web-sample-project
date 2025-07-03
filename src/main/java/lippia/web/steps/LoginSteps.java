package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.LandingPageService;
import lippia.web.services.MyAccountService;

public class LoginSteps extends PageSteps {


    @Given("The client is on my account page")
    public void MyAccountPage() {
        LandingPageService.navegarWeb();
        LandingPageService.clickOnMyAccount();
    }

    @When("The client logs in with email (.*) and password (.*)")
    public void doFailedLogin(String email, String pass) {
        MyAccountService.setInvalidCredentials(email,pass);
        MyAccountService.clickOnLogin();
    }

    @When("The client logs in with registered email (.*) and password (.*)")
    public void doSuccessfulLogin(String email, String pass) {
        MyAccountService.setValidCredentials(email,pass);
        MyAccountService.clickOnLogin();

    }

    @And("The client navigates back")
    public void NavigatesBack() {
        MyAccountService.navigatesBack();
    }

    @Then("The client is on login page")
    public void validateLoginPage() {
        MyAccountService.validateLoginPage();
    }
}
