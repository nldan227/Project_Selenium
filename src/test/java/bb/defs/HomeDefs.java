package bb.defs;

import bb.common.BasePage;
import bb.steps.HomeSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import static org.assertj.core.api.Assertions.assertThat;


public class HomeDefs extends BasePage {

    @Steps
    HomeSteps homeSteps;

    @Given("Navigate to Automation Exercise")
    public void navigateToAutomationExercise(){
        homeSteps.openHomePage();
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

    @When("Click Delete Account button")
    public void clickBtnDeleteAcc(){
        homeSteps.clickBtnDeleteAcc();
    }

    @When("Click Logout button")
    public void clickBtnLogout(){
        homeSteps.clickOnLogout();
    }
}
