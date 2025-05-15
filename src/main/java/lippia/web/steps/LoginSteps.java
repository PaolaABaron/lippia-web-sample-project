package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lippia.web.services.LandingPageService;
import lippia.web.services.MyAccountService;

public class LoginSteps extends PageSteps {


    @Given("The client is on my account page")
    public void MyAccountPage() {
        LandingPageService.navegarWeb();
        LandingPageService.clickOnMyAccount();

    }

    @When("The client logs in with registered email {string} and password {string}")
    public void SetsEmailAndPassword(String email, String pass) {
        MyAccountService.setEmail(email);
        MyAccountService.setPass(pass);
        MyAccountService.clickOnLogin();
    }


    @When("The client logs in with email {string} and password {string}")
    public void SetsTheEmailAndPassword(String email, String pass) {
        MyAccountService.setEmail(email);
        MyAccountService.setPass(pass);
        MyAccountService.clickOnLogin();
    }


}
