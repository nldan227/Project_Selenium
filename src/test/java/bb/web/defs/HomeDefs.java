package bb.web.defs;

import bb.web.common.BasePage;
import bb.web.steps.HomeSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;


public class HomeDefs extends BasePage {

    @Steps
    HomeSteps homeSteps;

    @Given("Navigate to Automation Exercise")
    public void navigateToAutomationExercise(){
        homeSteps.openHomePage();
        homeSteps.verifyHomePageIsDisplayed();
    }

    @And("Home page is visible")
    public void verifyHomePageIsVisible(){
        homeSteps.verifyHomePageIsDisplayed();
    }

    @And("^Click on Signup/Login button$")
    public void clickOnSignupOrLogin(){
        homeSteps.clickOnSignupOrLogin();
    }

    @When("Click Test Cases button")
    public void clickOnBtnTCs(){
        homeSteps.clickBtnTCs();
    }

    @Then("{string} label is visible")
    public void verifyLoggedInAsLblVisible(String fullText){
        homeSteps.verifyTextLoggedInAsLbl(fullText);
        homeSteps.verifyLoggedInAsLblDisplayed();
    }

    @Then("'Logged in as username' is displayed at top")
    public void verifyLoggedInAsUsername() {
        String username = Serenity.sessionVariableCalled("firstname");
        String expectedText = "Logged in as " + username;

        homeSteps.verifyTextLoggedInAsLbl(expectedText);
        homeSteps.verifyLoggedInAsLblDisplayed();
    }

    @When("Click Delete Account button")
    public void clickBtnDeleteAcc(){
        homeSteps.clickBtnDeleteAcc();
    }

    @When("Click Logout button")
    public void clickBtnLogout(){
        homeSteps.clickOnLogout();
    }

    @When("Click on Contact Us button")
    public void clickBtnContact() {
        homeSteps.clickBtnContact();
    }

    @When("Click on Products button")
    public void clickBtnProducts() {
        homeSteps.clickBtnProducts();
    }

    @When("Click Cart button")
    public void clickBtnCart() {
        homeSteps.clickBtnCart();
    }

    @When("Scroll down to footer")
    public void scrollToFooter() {
        homeSteps.scrollToFooter();
    }

    @When("Scroll up page to top")
    public void scrollToTop() {
        homeSteps.scrollToTop();
    }

    @When("Enter email address in input and click arrow button")
    public void submitSubscription(){
        homeSteps.submitSubscription();
    }

    @When("Click on {string} category")
    @When("Click on {string} brand")
    public void clickOnCategory(String category){
        homeSteps.clickCategory(category);
    }

    @When("Click on {string} sub category under {string}")
    public void clickOnSubCategory(String sub, String parent){
        homeSteps.clickSubCategory(parent, sub);
    }

    @Then("Recommend items are visible")
    public void verifyRcmItemsAreVisible(){
        homeSteps.verifyRcmItemsAreVisible();
    }

    @When("Click on arrow at bottom right side to move upward")
    public void clickOnArrow(){
        homeSteps.clickIcScrollUp();
    }

}
