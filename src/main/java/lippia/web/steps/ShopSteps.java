package lippia.web.steps;

import com.crowdar.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.FilterMapper;
import lippia.web.services.LandingPageService;
import lippia.web.services.ProductCategoriesService;
import lippia.web.services.ShopService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShopSteps {

    @Given("The client is on shop page")
    public void ShopPage() {
        LandingPageService.navegarWeb();
        LandingPageService.clickOnShop();
    }

    @When("The client clicks on {string}")
    public void ClicksOnCategory(String category) {
        ShopService.clickOnCategory(category);
    }

    @Then("The product {string} is shown")
    public void verifyProductIsShown(String expectedProduct) {
        ProductCategoriesService.verifyProductVisible(expectedProduct);
    }

    @When("The client clicks on {string} option")
    public void ClicksOnFilter(String filter) {
        ShopService.clickOnFilter(filter);
    }

    @Then("The filtered {string} are shown")
    public void verifyFilteredProducts(String expectedProductsKey) {
        Select dropdown = new Select(DriverManager.getDriverInstance().findElement(By.className("orderby")));
        String selectedFilterValue = dropdown.getFirstSelectedOption().getAttribute("value");
        String validationKey = FilterMapper.getValidationKey(selectedFilterValue);
        ShopService.verifyFilteredProducts(validationKey);
        Assert.assertEquals(validationKey, expectedProductsKey, "El filtro aplicado no coincide con el esperado");
    }


}
